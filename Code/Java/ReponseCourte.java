package pooprojet;

class ReponseCourte extends Question
{
  private String reponse;

  public ReponseCourte(String theme, String question, int difficulte, String reponse)
  {
    super(theme, question, difficulte);
    this.reponse = reponse;
  }

  @Override
  public String toString()
  {
    return "Theme : " + super.theme + "\nDifficulté : " + super.difficulte + "\nQuestion : " + super.question;
  }

  public String getTheme()
  {
    return this.theme;
  }
}
