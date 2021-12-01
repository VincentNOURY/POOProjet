package pooprojet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Jeu implements Phase
{
  private int phase;
  private Joueurs joueurs;
  private int toSelect;
  private Questions questions;
  private String currentTheme;
  private Themes themes;
  private int incrPhase;

  public Jeu()
  {
    this.phase = 1;
    this.incrPhase = 2;
    this.joueurs = new Joueurs();
    this.toSelect = 0;
    this.questions = new Questions();
    this.themes = new Themes();
    this.readFile("../Code/Database/QCM.txt", "qcm");
    this.readFile("../Code/Database/ReponseCourte.txt", "ReponseCourte");
    this.readFile("../Code/Database/VraiFaux.txt", "VraiFaux");
    this.currentTheme = themes.getThemeByIndex(0);
  }

  public int getNbJoueurs(){
    return this.joueurs.size();
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
    for (String theme : this.themes.getList())
    {
      System.out.println("Theme : " + theme);
      questions.getByTheme(theme);
      System.out.println("\n\n");
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
    if (this.phase == 1){
      return this.joueurs.size() >= 4;
    }
    else if (this.phase == 2){
      return this.joueurs.size() >= 3;
    }
    else if (this.phase == 3){
      return this.joueurs.size() == 2;
    }
    else{
      System.out.println("Ceci n'est pas censé arriver.");
      return false;
    }
  }

  public void nouvellePhase(){
    this.phase++;
    if (this.phase == 2){
      this.incrPhase = 3;
    }
    else if (this.phase == 3){
      this.incrPhase = 5;
    }
    this.selectJoueursPourProchainePhase();
    if (!this.nbJoueurSuffisant()){
      System.out.println("Nombre de joueurs insuffisant");
    }
  }

  public void selectJoueursPourProchainePhase(){
    if (this.phase == 2){
      joueurs.remove(joueurs.trouveMinJoueur());
    }
    else if (this.phase == 3){
      joueurs.keepTwoMax();
    }
  }

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
    if (this.toSelect == this.joueurs.size())
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
    if (this.phase == 1){
      Question question = questions.getRandomLevel1ByTheme(this.currentTheme);
      System.out.println(question);
      return question;
    }
    else if (this.phase == 2){
      Question question = questions.getRandomLevel2ByTheme(this.currentTheme);
      System.out.println(question);
      return question;
    }
    else{
      Question question = questions.getRandomLevel3ByTheme(this.currentTheme);
      System.out.println(question);
      return question;
    }
  }

  public void validateQuestion(Question question){
    if(question.reponse(this.readReponseString())){
      joueurs.getSelectionne().majScore(this.incrPhase);
      System.out.println("Bravo ceci est la bonne réponse votre score est désormais de " + joueurs.getSelectionne().getScore());
    }
  }

  public String readReponseString(){
    Scanner scanner = new Scanner(System.in);
    String reponse = scanner.nextLine();
    scanner.close();
    return reponse;
  }

  public void readFile(String path, String type) {
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
            this.ajouteQuestion(new VraiFaux(line[0], line[1], Integer.parseInt(line[2]), Boolean.parseBoolean(line[3])));
          }
        }
        scanner.close();
      }
      catch (FileNotFoundException e) {
        System.out.println("File not found Exception");
      }
  }
}
