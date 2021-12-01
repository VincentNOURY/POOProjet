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

    for (Joueur joueur : listeJoueurs)
    {
      if (joueur.getScore() > max1)
      {
        max1 = joueur.getScore();
        maxJoueur1 = joueur;
      }
      else if (joueur.getScore() > max2)
      {
        max2 = joueur.getScore();
        maxJoueur2 = joueur;
      }
    }
    Joueur[] temp = {maxJoueur1, maxJoueur2};
    this.listeJoueurs = temp;
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
    if (indice >= 0 || indice <= last)
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
