package application;

public class PhaseII implements Phase{
  private int incrPhase;
  private int nbJoueurs;
  private int toEliminate;
  private int nbTours;
  private int tour;

  public PhaseII(){
    this.incrPhase = 3;
    this.nbJoueurs = 3;
    this.nbTours = 2;
    this.tour = 0;
  }

  public int nbJoueursMin(){
    return this.nbJoueurs;
  }

  public void selectJoueursPourProchainePhase(Joueurs joueurs){
    joueurs.keepTwoMax();
    System.out.println("Les derniers joueurs en lice sont : " + joueurs);
  }

  public void setToEliminate(Joueurs joueurs){
    this.toEliminate = joueurs.size();
  }

  public void incrScore(Joueur joueur){
    joueur.majScore(this.incrPhase);
  }

  public void prochainTour(){
    this.tour++;
  }

  public boolean checkTours(){
    return this.tour >= this.nbTours;
  }

  public int toEliminate(){
    return this.toEliminate;
  }

  public int getPhase(){
    return 2;
  }
}
