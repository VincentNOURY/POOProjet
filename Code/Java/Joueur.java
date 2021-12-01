package pooprojet;
import java.util.Scanner;

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
    return this.toString();
  }

  public void majScore(int s)
  {
    this.score += s;
  }

  public void chgtEtat(String str)
  {
    this.etat = str;
    /*sélectionné
      gagnant
      super gagnant
      éliminé
      en attente
    */
  }

  public String getEtat(){
    return this.etat;
  }

  public int getScore()
  {
    return this.score;
  }

  public int getId()
  {
    return this.numero;
  }

  public String getNom(){
    return this.nom;
  }

  @Override
  public String toString()
  {
    return "Joueur : [nom : " + this.nom + ", numero : " + this.numero + ", score : " + this.score + ", etat : " + this.etat + "]";
  }
}
