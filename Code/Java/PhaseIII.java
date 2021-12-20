package application;

public class PhaseIII implements Phase{

  private int incrPhase;
  private int nbJoueurs;
  private int toEliminate;
  private int nbTours;
  private int tour;

  public PhaseIII(Themes themes){
    this.incrPhase = 5;
    this.nbJoueurs = 2;
    this.nbTours = 2;
    this.tour = 0;

    for (int i = 0; i < themes.size(); i++){
      themes.remove(0);
    }
    themes.addTheme("Sport");
    themes.addTheme("Espace");
    themes.addTheme("Alcool");
  }

  public int nbJoueursMin(){
    return this.nbJoueurs;
  }

  public void selectJoueursPourProchainePhase(Joueurs joueurs){
    System.out.println("Le jeu est terminé");
    System.out.println("Le gagnant est " + joueurs.gagnant());
  }

  public void incrScore(Joueur joueur){
    joueur.majScore(this.incrPhase);
  }

  public void prochainTour(){
    this.tour++;
  }

  public void setToEliminate(Joueurs joueurs){
    this.toEliminate = joueurs.size() + 1;
  }

  public boolean checkTours(){
    return this.tour >= this.nbTours;
  }

  public int toEliminate(){
    return this.toEliminate;
  }

  public int getPhase(){
    return 3;
  }
}
