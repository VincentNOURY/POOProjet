package pooprojet;

class VraiFaux extends Question
{
  private boolean reponse;

  public VraiFaux(String theme, String question, int difficulte, boolean reponse)
  {
    super(theme, question, difficulte);
    this.reponse = reponse;
  }
}
