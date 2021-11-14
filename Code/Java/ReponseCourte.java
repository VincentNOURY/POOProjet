package pooprojet;

class ReponseCourte extends Question
{
  private String reponse;

  public ReponseCourte(String theme, String question, int difficulte, String reponse)
  {
    super(theme, question, difficulte);
    this.reponse = reponse;
  }

}
