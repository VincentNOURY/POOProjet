package pooprojet;

abstract class Question
{
  protected String theme;
  protected String question;
  protected int difficulte;

  public Question(String theme, String question, int difficulte)
  {
    this.theme = theme;
    this.question = question;
    this.difficulte = difficulte;
  }

  @Override
  public abstract String toString();

  public abstract String getTheme();
}
