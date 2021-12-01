package pooprojet;

class VraiFaux extends Question
{
  private boolean reponse;

  public VraiFaux(String theme, String question, int difficulte, boolean reponse)
  {
    super(theme, question, difficulte);
    this.reponse = reponse;
  }

  @Override
  public String toString()
  {
    String outputReponses = "";
    outputReponses += "Vrai\nFaux\n";
    return "Type : Vrai Faux\nTheme : " + super.theme + "\nDifficulté : " + super.difficulte + "\nQuestion : " + super.question + "\nRéponses :\n" + outputReponses;
  }

  public String getTheme()
  {
    return super.theme;
  }

  public int getDifficulte(){
    return super.difficulte;
  }
}
