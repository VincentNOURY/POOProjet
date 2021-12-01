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

  public Jeu()
  {
    this.phase = 1;
    this.joueurs = new Joueurs();
    this.toSelect = 0;
    this.questions = new Questions();
    this.readFile("../Code/Database/QCM.txt", "qcm");
    this.readFile("../Code/Database/ReponseCourte.txt", "ReponseCourte");
    this.readFile("../Code/Database/VraiFaux.txt", "VraiFaux");
    this.currentTheme = "";
  }

  public void afficheAllQuestions(){
    System.out.println(questions);
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

  public void nouvellePhase()
  {
    this.phase++;
  }

  public void selectJoueurs()
  {
    joueurs.remove(joueurs.trouveMinJoueur());
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

  public void selectNext(){
    if (this.toSelect == joueurs.size() - 1)
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

  public boolean poserQuestion(){
    if (this.phase == 1){
      System.out.println(questions.getRandomLevel1ByTheme(this.currentTheme));
    }
    return true;
  }

  public String readReponseString(){
    Scanner scanner = new Scanner(System.in);
    String reponse = scanner.nextLine();
    scanner.close();
    return reponse;
  }

  public int readReponseInt(){
    Scanner scanner = new Scanner(System.in);
    int reponse = scanner.nextInt();
    scanner.close();
    return reponse;
  }

  public boolean readReponseBoolean(){
    Scanner scanner = new Scanner(System.in);
    boolean reponse = scanner.nextBoolean();
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
            this.questions.add(new Qcm(line[0], line[1], Integer.parseInt(line[2]), line[3].split(";"), Integer.parseInt(line[4])));
          }
          if (type.equals("ReponseCourte")){
            this.questions.add(new ReponseCourte(line[0], line[1], Integer.parseInt(line[2]), line[3]));
          }
          if (type.equals("VraiFaux")){
            this.questions.add(new VraiFaux(line[0], line[1], Integer.parseInt(line[2]), Boolean.parseBoolean(line[3])));
          }
        }
        scanner.close();
      }
      catch (FileNotFoundException e) {
        System.out.println("File not found Exception");
      }
  }
}
