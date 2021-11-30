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
    System.out.println(joueur1);
    joueurs.createRandomPlayer(4);
    System.out.println(joueurs);

    Questions questions = new Questions();
    Question question1 = new Qcm("Culture générale", "Combien y a t'il de secondes dans une minute ?", 1, testReponses, 1);
    System.out.println(question1);
    String[] str = {"Vrai", "Faux"};
    Question question2 = new VraiFaux("vraifaux", "Combien y a t'il de secondes dans une minute ?", 1, true, str);
    Question question3 = new Qcm("test2 générale", "Combien y a t'il de secondes dans une minute ?", 1, testReponses, 1);
    questions.add(question1);
    questions.add(question2);
    questions.add(question3);
    System.out.println(questions);
  }
}
