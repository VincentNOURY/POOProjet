package pooprojet;
import java.util.ArrayList;

class Joueurs
{
  private int numeroProchain;
  private ArrayList<Joueur> listeJoueurs;

  public Joueurs()
  {
    this.numeroProchain = 100;
    listeJoueurs = new ArrayList<>();
  }

  public void addJoueur(Joueur joueur)
  {
    this.listeJoueurs.add(joueur);
  }

  public void createJoueur(String name)
  {
    Joueur joueur = new Joueur(name, numeroProchain);
    listeJoueurs.add(joueur);
    this.numeroProchain += 10;
  }

  public Joueur get(int indice)
  {
    if (indice >= 0 || indice <= listeJoueurs.size())
    {
      return listeJoueurs.get(indice);
    }
    else
    {
      throw new IllegalArgumentException("Index out of range");
    }
  }

  public int trouveMinJoueur()
  {
    int min = this.listeJoueurs.get(0).getScore();
    int minId = this.listeJoueurs.get(0).getId();

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
    this.listeJoueurs.remove(indice);
  }

  @Override
  public String toString()
  {
    String joueursInfo = "";
    for (Joueur joueur : listeJoueurs)
    {
      joueursInfo += joueur + "\n";
    }
    return "Joueurs : [\n" + joueursInfo + "]";
  }
}
