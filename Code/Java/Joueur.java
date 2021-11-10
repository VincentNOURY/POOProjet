package pooprojet;

class Joueur
{
  private String nom;
  private int numero;
  private int score;
  private String etat;

  public Joueur(String nom, int numero)
  {
    this.nom = nom;
    this.numero = numero;
    this.score = 0;
    this.etat = "en attente";
  }
}
