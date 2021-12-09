package pooprojet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Jeu
{
  private Phase phase;
  private Phase phase1;
  private Phase phase2;
  private Phase phase3;
  private Joueurs joueurs;
  private int toSelect;
  private Questions questions;
  private String currentTheme;
  private Themes themes;

  public Jeu()
  {
    this.joueurs = new Joueurs();
    this.toSelect = 0;
    this.questions = new Questions();
    this.themes = new Themes();
    try{
      System.out.println("[Info] Initialisation des questions par les fichiers.");
      this.readFile("../Code/Database/QCM.txt", "qcm");
      this.readFile("../Code/Database/ReponseCourte.txt", "ReponseCourte");
      this.readFile("../Code/Database/VraiFaux.txt", "VraiFaux");
      System.out.println("[Info] Questions initialisées avec succès");
    }
    catch (FileNotFoundException fnfe){
      System.out.println("[Error] Fichiers texte non trouvés, ceci peut etre du a l'environement utilisé où l'endroit d'execution du code.");
      System.out.println("[Info] Bascule sur le constructeur.");
      System.out.println("[Info] Initialisation du constructeur.");
      Constructeur constructeur = new Constructeur(this);
      System.out.println("[Info] Questions Initialisées avec succès, bon jeu.");
    }
    System.out.println("\n\n\n\n\n\n\n");
    this.currentTheme = themes.getThemeByIndex(0);
    this.phase = new PhaseI();
  }

  public int getNbJoueurs(){
    return this.joueurs.size();
  }

  public void start(){
    Scanner scanner = new Scanner(System.in);
    String plyer;
    String name;
    do{
      System.out.println("Souhaitez-vous ajouter manuellement 1 joueur ?(y/n)");
      plyer = scanner.nextLine();
      if (plyer.equals("y")){
        System.out.println("Veuillez entrer votre nom");
        name = scanner.nextLine();
        this.joueurs.createJoueur(name);
      }
      else if(this.getNbJoueurs() < phase.nbJoueursMin()){
        this.createRandomPlayers(phase.nbJoueursMin() - this.getNbJoueurs());
      }
    }while((this.getNbJoueurs() < phase.nbJoueursMin() || this.getNbJoueurs() != 20) && plyer.equals("y"));
    phase.setToEliminate(this.joueurs);
    System.out.println("\n\n\n\n\n\n");
    String reponse = "";
    Question question;
    for (int j = 0; j < 3; j++){
      do{
        for (int i = 0; i < this.getNbJoueurs(); i++){
          this.selectNextJoueur();
          question = this.poserQuestion();
          reponse = scanner.nextLine();
          this.validateQuestion(question, reponse);
          this.prochainTheme();
        }
        phase.prochainTour();
      }while (this.continuer());
      this.nouvellePhase();
    }
    scanner.close();
  }

  public boolean continuer(){
    return joueurs.yaPlusPetit(phase.toEliminate()) || !phase.checkTours();
    // NE fonctionne pas a Modifier
  }

  public void ajouteQuestion(Question q){
    this.questions.add(q);
    boolean exists = false;
    for (String theme : this.themes.getList()){
      if (theme.equals(q.getTheme())){
        exists = true;
      }
    }
    if (!exists){
      this.themes.addTheme(q.getTheme());
    }
  }

  public void afficheAllQuestions(){
    System.out.println();
    for (String theme : this.themes.getList())
    {
      System.out.println("Theme : " + theme + "\n" + questions.getByTheme(theme) + "\n");
    }
  }

  public void prochainTheme(){
    if (themes.getIndex(this.currentTheme) + 1 == themes.size()){
      this.currentTheme = themes.getThemeByIndex(0);
    }
    else{
      this.currentTheme = themes.getThemeByIndex(themes.getIndex(this.currentTheme) + 1);
    }
  }

  public boolean nbJoueurSuffisant(){
      return this.joueurs.size() >= phase.nbJoueursMin();
  }

  public void nouvellePhase(){
    this.phase.selectJoueursPourProchainePhase(joueurs);
    if (this.phase.getPhase() == 1){
      this.phase = this.phase2 = new PhaseII();
      this.phase.setToEliminate(this.joueurs);
    }
    else if (this.phase.getPhase() == 2){
      this.phase = new PhaseIII(this.themes);
      this.phase.setToEliminate(this.joueurs);
      this.currentTheme = "Sport";
    }
    //else{
    //  System.out.println("Le jeu est terminé");
    //  System.out.println("Le gagnant est " + joueurs.gagnant());
    //}
    /*if (this.phase == 2){
      this.incrPhase = 3;
      this.selectJoueursPourProchainePhase();
      if (!this.nbJoueurSuffisant()){
        System.out.println("Nombre de joueurs insuffisant");
      }
    }
    else if (this.phase == 3){
      this.incrPhase = 5;
      this.selectJoueursPourProchainePhase();
      if (!this.nbJoueurSuffisant()){
        System.out.println("Nombre de joueurs insuffisant");
      }
      for (int i = 0; i < themes.size(); i++){
        themes.remove(0);
      }
      themes.addTheme("Sport");
      themes.addTheme("Espace");
      themes.addTheme("Alcool");
      this.currentTheme = "Sport";
    }
    else if (this.phase == 4){
      System.out.println("Le jeu est terminé");
      System.out.println("Le gagnant est " + joueurs.gagnant());
    }*/
  }

  /*public void selectJoueursPourProchainePhase(){
    if (this.phase == 2){
      for (int i = 0; i < this.toEliminate(); i++){
        System.out.println("Le joueur " + joueurs.get(joueurs.trouveMinJoueur()) + " est éliminé applaudissez-le\n\n\n");
        joueurs.remove(joueurs.trouveMinJoueur());
      }
    }
    else if (this.phase == 3){
      joueurs.keepTwoMax();
      System.out.println("Les derniers joueurs en lice sont : " + joueurs);
    }
  }*/

  public void createRandomPlayers(int n){
    try{
      this.joueurs.createRandomPlayers(n);
    }
    catch (IllegalArgumentException e){
      System.out.println("Il est impossible de créer ce nombre de joueurs");
      System.out.println(e);
    }
  }

  public void afficheJoueurs(){
    System.out.println(joueurs);
  }

  public void afficheThemeActuel(){
    System.out.println("Theme actuel : " + this.currentTheme);
  }

  public void selectNextJoueur(){
    if (this.toSelect > this.joueurs.size()){
      for (int i = 0; i < this.joueurs.size(); i++){
        this.joueurs.get(i).chgtEtat("en attente");
      }
      this.toSelect = 0;
    }
    else if (this.toSelect == this.joueurs.size())
    {
      this.joueurs.get(toSelect - 1).chgtEtat("en attente");
      this.toSelect = 0;
    }
    else if (this.toSelect == 0){
      this.joueurs.get(joueurs.size() - 1).chgtEtat("en attente");
    }
    else{
      this.joueurs.get(toSelect - 1).chgtEtat("en attente");
    }
    this.joueurs.get(this.toSelect).chgtEtat("sélectionné");
    System.out.println("Joueur " + this.joueurs.get(this.toSelect).getNom() + ", numéro : " + this.joueurs.get(this.toSelect).getId() + " c'est a vous.");
    this.toSelect++;
  }

  public Question poserQuestion(){
    if (this.phase.getPhase() == 1){
      Question question = questions.getRandomLevel1ByTheme(this.currentTheme);
      System.out.println(question);
      return question;
    }
    else if (this.phase.getPhase() == 2){
      Question question = questions.getRandomLevel2ByTheme(this.currentTheme);
      System.out.println(question);
      return question;
    }
    else{
      System.out.println(this.currentTheme);
      Question question = questions.getRandomLevel3ByTheme(this.currentTheme);
      System.out.println(question);
      return question;
    }
  }

  public void validateQuestion(Question question, String reponse){
    if(question.reponse(reponse)){
      phase.incrScore(joueurs.getSelectionne());
      System.out.println("Bravo ceci est la bonne réponse votre score est désormais de " + joueurs.getSelectionne().getScore());
    }
    else{
      System.out.println("Vous n'avez pas trouvé la bonne réponse, la bonne réponse était " + question.getReponse());
    }
    System.out.println("\n\n");
  }

  public void readFile(String path, String type) throws FileNotFoundException {
      File data = new File(path);
      try {
        Scanner scanner = new Scanner(data);
        String[] line;
        while (scanner.hasNextLine()) {
          line = scanner.nextLine().split(",");
          if (type.equals("qcm")){
            this.ajouteQuestion(new Qcm(line[0], line[1], Integer.parseInt(line[2]), line[3].split(";"), Integer.parseInt(line[4])));
          }
          if (type.equals("ReponseCourte")){
            this.ajouteQuestion(new ReponseCourte(line[0], line[1], Integer.parseInt(line[2]), line[3]));
          }
          if (type.equals("VraiFaux")){
            this.ajouteQuestion(new VraiFaux(line[0], line[1], Integer.parseInt(line[2]), line[3].split(" ")[1]));
          }
        }
        scanner.close();
      }
      catch (FileNotFoundException e) {
        throw new FileNotFoundException("File not found Exception");
      }
  }
}
