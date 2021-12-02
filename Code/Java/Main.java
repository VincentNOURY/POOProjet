package pooprojet;
import java.io.File;
import java.util.Scanner;

class Main
{
  public static void main(String args[])
  {
    Jeu jeu = new Jeu();
    Scanner scanner = new Scanner(System.in);
    jeu.createRandomPlayers(4);
    //jeu.afficheJoueurs();
    //jeu.afficheJoueurs();
    //jeu.afficheJoueurs();
    //jeu.afficheAllQuestions();
    //boolean test;
    //for (int i = 0; i < 10; i ++){
    //  test = jeu.poserQuestion();
    //}
    String reponse = "";
    Question question;
    //jeu.prochainTheme();
    //jeu.prochainTheme();
    //jeu.prochainTheme();
    //jeu.prochainTheme();
    //jeu.prochainTheme();
    for (int j = 0; j < 3; j++){
      do{
        for (int i = 0; i < jeu.getNbJoueurs(); i++){
          jeu.selectNextJoueur();
          question = jeu.poserQuestion();
          reponse = scanner.nextLine();
          jeu.validateQuestion(question, reponse);
          jeu.prochainTheme();
          //jeu.afficheJoueurs();
        }
      }while (jeu.continuer());
      jeu.nouvellePhase();
    }
  }
}
