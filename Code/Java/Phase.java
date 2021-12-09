package pooprojet;

interface Phase
{
  abstract public void incrScore(Joueur joueur);

  abstract public int nbJoueursMin();

  abstract public int toEliminate();

  abstract public void selectJoueursPourProchainePhase(Joueurs joueurs);

  abstract public void prochainTour();

  abstract public boolean checkTours();

  abstract public void setToEliminate(Joueurs joueurs);

  abstract public int getPhase();
}
