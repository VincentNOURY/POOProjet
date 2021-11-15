package pooprojet;

class Main
{
  public static void main(String args[])
  {
    Joueur joueur1 = new Joueur("TestName", 100);
    String[] testReponses = {"30", "60", "90"};
    Joueurs joueurs = new Joueurs();
    joueurs.createJoueur("testName1");
    joueurs.createJoueur("testName2");
    System.out.println(joueurs);
    Question question1 = new Qcm("Culture générale", "Combien y a t'il de secondes dans une minute ?", 1, testReponses, 1);
    System.out.println(question1);
    System.out.println(joueur1);
  }
}
