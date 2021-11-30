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

  public void createJoueur(String name)
  {
    Joueur joueur = new Joueur(name, numeroProchain);
    this.listeJoueurs[last + 1] = joueur;
    this.last++;
    this.numeroProchain += 10;
  }

  public Joueur get(int indice) throws IllegalArgumentException
  {
    if (indice >= 0 || indice <= listeJoueurs.length)
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
    int minId = this.listeJoueurs[0].getId();

    for (Joueur joueur : listeJoueurs)
    {
      if (joueur.getScore() < min)
      {
        min = joueur.getScore();
        minId = joueur.getId();
      }
    }

    return minId;
  }

  public void remove(int indice)
  {
    for (int i = indice; i < this.last; i++){
      this.listeJoueurs[i] = this.listeJoueurs[i + 1];
    }
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

  public Joueur selectRandomPlayer(){
    return this.listeJoueurs[(int)(Math.random() * (this.listeJoueurs.length))];
  }

  public void createRandomPlayer(int nbOfPlayers) throws IllegalArgumentException
  {
    if (nbOfPlayers + last >= 19){
      throw new IllegalArgumentException("Index out of range");
    }
    for (int i = 0; i < nbOfPlayers; i++){
      this.createJoueur("Joueur Aléatoire " + i);
    }
  }

}
