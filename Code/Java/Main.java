package pooprojet;
import java.io.File;


class Main
{
  public static void main(String args[])
  {
    Jeu jeu = new Jeu();
    jeu.createRandomPlayers(20);
    //jeu.afficheJoueurs();
    //jeu.selectNext();
    //jeu.afficheJoueurs();
    //for (int i = 0; i < 25; i++){
    //  jeu.selectNext();
    //}
    //jeu.afficheJoueurs();
    //jeu.afficheAllQuestions();
    //boolean test;
    //for (int i = 0; i < 10; i ++){
    //  test = jeu.poserQuestion();
    //}
    jeu.afficheThemeActuel();
    jeu.prochainTheme();
    jeu.afficheThemeActuel();
  }
}
