package pooprojet;
import java.util.ArrayList;
import java.lang.Math;

class Joueurs
{
  private int numeroProchain;
  private Joueur[] listeJoueurs;
  private int last;

  public Joueurs()
  {
    this.numeroProchain = 100;
    this.listeJoueurs = new Joueur[20];
    this.last = -1;
  }

  public void addJoueur(Joueur joueur) throws IllegalArgumentException
  {
    if (last < 19){
      this.listeJoueurs[last + 1] = joueur;
      this.last += 1;
    }
    else{
      throw new IllegalArgumentException("Le nombre de joueurs maximum est atteint");
    }
  }

  public void keepTwoMax(){
    int max1 = this.listeJoueurs[0].getScore();
    Joueur maxJoueur1 = this.listeJoueurs[0];
    int max2 = this.listeJoueurs[1].getScore();
    Joueur maxJoueur2 = this.listeJoueurs[1];

    for (int i = 2; i < this.last + 1; i++)
    {
      if (listeJoueurs[i].getScore() > max1)
      {
        max1 = listeJoueurs[i].getScore();
        maxJoueur1 = listeJoueurs[i];
      }
      else if (listeJoueurs[i].getScore() > max2)
      {
        max2 = listeJoueurs[i].getScore();
        maxJoueur2 = listeJoueurs[i];
      }
    }
    Joueur[] temp = {maxJoueur1, maxJoueur2};
    this.listeJoueurs = temp;
    this.last = 1;
  }

  public Joueur gagnant(){
    if (listeJoueurs[0].getScore() > listeJoueurs[1].getScore()){
      return listeJoueurs[0];
    }
    else{
      return listeJoueurs[1];
    }
  }

  public boolean YaPlusPetit(){
    int min = listeJoueurs[0].getScore();
    boolean egal = false;
    for (int i = 1; i < this.last; i++){
      if (listeJoueurs[i].getScore() < min){
        min = listeJoueurs[i].getScore();
        egal = false;
      }
      else if (listeJoueurs[i].getScore() == min){
        egal = true;
      }
    }
    return egal;
  }

  public void createJoueur(String name)
  {
    Joueur joueur = new Joueur(name, numeroProchain);
    this.last++;
    this.listeJoueurs[last] = joueur;
    this.numeroProchain += 10;
  }

  public Joueur get(int indice) throws IllegalArgumentException
  {
    if (indice >= 0 && indice <= last)
    {
      return listeJoueurs[indice];
    }
    else
    {
      throw new IllegalArgumentException("Index out of range");
    }
  }

  public int trouveMinJoueur()
  {
    int min = this.listeJoueurs[0].getScore();
    int minId = 0;

    for (int i = 0; i < this.last; i++)
    {
      if (this.listeJoueurs[i].getScore() < min)
      {
        min = this.listeJoueurs[i].getScore();
        minId = i;
      }
    }
    return minId;
  }

  public void remove(int indice)
  {
    for (int i = indice; i < this.last; i++){
      this.listeJoueurs[i] = this.listeJoueurs[i + 1];
    }
    last--;
  }

  @Override
  public String toString()
  {
    String joueursInfo = "";
    for (Joueur joueur : listeJoueurs)
    {
      if (joueur != null){
        joueursInfo += joueur + "\n";
      }

    }
    return "Joueurs : [\n" + joueursInfo + "]";
  }

  public Joueur getSelectionne() throws IllegalStateException{
    for (Joueur joueur : listeJoueurs){
      if (joueur.getEtat().equals("sélectionné")){
        return joueur;
      }
    }
    throw new IllegalStateException("Aucun joueur n'est en état sélectionné");
  }

  public Joueur selectRandomPlayer(){
    return this.listeJoueurs[(int)(Math.random() * (this.listeJoueurs.length))];
  }

  public void createRandomPlayers(int nbOfPlayers) throws IllegalArgumentException
  {
    if (nbOfPlayers + this.last > 19){
      throw new IllegalArgumentException("Index out of range");
    }
    for (int i = 0; i < nbOfPlayers; i++){
      this.createJoueur("Joueur Aléatoire " + i);
    }
  }

  public int size(){
    return last + 1;
  }
}
