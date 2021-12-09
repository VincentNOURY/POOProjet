package pooprojet;

public class PhaseI implements Phase{
  private int incrPhase;
  private int nbJoueurs;
  private int toEliminate;
  private int nbTours;
  private int tour;

  public PhaseI(){
    this.incrPhase = 2;
    this.nbJoueurs = 4;
    this.nbTours = 1;
    this.tour = 0;
  }
  public int nbJoueursMin(){
    return this.nbJoueurs;
  }

  public void selectJoueursPourProchainePhase(Joueurs joueurs){
    for (int i = 0; i < this.toEliminate; i++){
      System.out.println("Le joueur " + joueurs.get(joueurs.trouveMinJoueur()) + " est éliminé applaudissez-le\n\n\n");
      joueurs.remove(joueurs.trouveMinJoueur());
    }
  }

  public void incrScore(Joueur joueur){
    joueur.majScore(this.incrPhase);
  }

  public void prochainTour(){
    this.tour++;
  }

  public void setToEliminate(Joueurs joueurs){
    if (joueurs.size() > 15){
      this.toEliminate = 6;
    }
    else if (joueurs.size() > 10){
      this.toEliminate = 4;
    }
    else if (joueurs.size() > 5){
      this.toEliminate = 2;
    }
    else{
      this.toEliminate = 1;
    }
  }

  public boolean checkTours(){
    return this.tour >= this.nbTours;
  }

  public int toEliminate(){
    return this.toEliminate;
  }

  public int getPhase(){
    return 1;
  }
}
