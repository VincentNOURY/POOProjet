package pooprojet;

public abstract class Jeu implements Phase
{
  private int phase;
  private Joueurs joueurs = new Joueurs();

  public Jeu()
  {
    this.phase = 0;
  }

  public void nouvellePhase()
  {

  }

  public void selectJoueurs()
  {
    joueurs.remove(joueurs.trouveMinJoueur());
  }
}
