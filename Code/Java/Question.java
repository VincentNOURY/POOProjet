package pooprojet;

class Question
{
  private String theme;
  private String question;
  private int difficulte;

  public Question(String theme, String question, int difficulte)
  {
    this.theme = theme;
    this.question = question;
    this.difficulte = difficulte;
  }

  @Override
  public String toString()
  {
    return "Thème : " + this.theme + "\nQuestion : " + this.question;
  }
}