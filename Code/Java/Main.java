package pooprojet;
import java.io.File;


class Main
{
  public static void main(String args[])
  {
    Jeu jeu = new Jeu();
    jeu.createRandomPlayers(4);
    jeu.afficheJoueurs();
    //jeu.afficheJoueurs();
    //jeu.afficheJoueurs();
    //jeu.afficheAllQuestions();
    //boolean test;
    //for (int i = 0; i < 10; i ++){
    //  test = jeu.poserQuestion();
    //}
    for (int i = 0; i < 1; i++){
      jeu.selectNextJoueur();
      jeu.validateQuestion(jeu.poserQuestion());
      jeu.afficheJoueurs();
    }
  }
}
