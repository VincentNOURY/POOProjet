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

  public String saisie()
  {
    Scanner scanner = new Scanner (System.in);
    this.nom = scanner.nextLine();
    scanner.close();
    return this.nom;
  }

  public void majScore(int s)
  {
    this.score += s;
  }

  public void chgtEtat(String str)
  {
    this.etat = str;
  }

  @Override
  public String toString()
  {
    return "Joueur : [nom : " + this.nom + ", numero : " + this.numero + ", score : " + this.score + ", etat : " + this.etat + "]";
  }
}
