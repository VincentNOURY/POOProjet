package pooprojet;

class Main
{
  public static void main(String args[])
  {
    Jeu jeu = new Jeu();
    jeu.createRandomPlayers(20);
    jeu.afficheJoueurs();
    jeu.selectNext();
    jeu.afficheJoueurs();
    for (int i = 0; i < 25; i++){
      jeu.selectNext();
    }
    jeu.afficheJoueurs();
  }
}
