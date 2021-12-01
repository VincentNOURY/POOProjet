package pooprojet;

class VraiFaux extends Question
{
  private boolean reponse;
  private String[] reponses;

  public VraiFaux(String theme, String question, int difficulte, boolean reponse, String[] reponses)
  {
    super(theme, question, difficulte);
    this.reponse = reponse;
    this.reponses = reponses;
  }

  @Override
  public String toString()
  {
    String outputReponses = "";
    for (String reponse : reponses)
    {
      outputReponses += reponse + "\n";
    }
    return "Theme : " + super.theme + "\nDifficulté : " + super.difficulte + "\nQuestion : " + super.question + "\nRéponses :\n" + outputReponses;
  }

  public String getTheme()
  {
    return super.theme;
  }

  public int getDifficulte(){
    return super.difficulte;
  }
}
