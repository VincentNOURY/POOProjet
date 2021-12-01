package pooprojet;

public class Jeu implements Phase
{
  private int phase;
  private Joueurs joueurs;
  private int toSelect;

  public Jeu()
  {
    this.phase = 1;
    this.joueurs = new Joueurs();
    this.toSelect = 0;
  }

  public boolean nbJoueurSuffisant(){
    if (this.phase == 1){
      
    }
  }

  public void nouvellePhase()
  {
    this.phase++;
  }

  public void selectJoueurs()
  {
    joueurs.remove(joueurs.trouveMinJoueur());
  }

  public void createRandomPlayers(int n){
    try{
      this.joueurs.createRandomPlayers(n);
    }
    catch (IllegalArgumentException e){
      System.out.println("Il est impossible de créer ce nombre de joueurs");
      System.out.println(e);
    }
  }

  public void afficheJoueurs(){
    System.out.println(joueurs);
  }

  public void selectNext(){
    if (this.toSelect == joueurs.size() - 1)
    {
      this.joueurs.get(toSelect - 1).chgtEtat("en attente");
      this.toSelect = 0;
    }
    else if (this.toSelect == 0){
      this.joueurs.get(joueurs.size() - 1).chgtEtat("en attente");
    }
    else{
      this.joueurs.get(toSelect - 1).chgtEtat("en attente");
    }
    this.joueurs.get(this.toSelect).chgtEtat("sélectionné");
    System.out.println("Joueur " + this.joueurs.get(this.toSelect).getNom() + ", numéro : " + this.joueurs.get(this.toSelect).getId() + " c'est a vous.");
    this.toSelect++;
  }
}
