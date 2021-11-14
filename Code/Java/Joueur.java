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

  @Override
  public String toString()
  {
    return "Joueur : [nom : " + this.nom + ", numero : " + this.numero + ", score : " + this.score + ", etat : " + this.etat + "]";
  }
}
