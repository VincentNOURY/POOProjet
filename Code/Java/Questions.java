package pooprojet;
import java.util.ArrayList;

class Questions
{
  private ArrayList<Question> questions;
  private Themes themes;

  public Questions()
  {
      questions = new ArrayList<>();
      themes = new Themes();
  }

  public void add(Question q)
  {
      questions.add(q);
  }

  public void remove(int i)
  {
      questions.remove(i);
  }

  public void getByTheme(String theme)
  {
    for (Question question : this.questions)
    {
      if (question.getTheme() == theme)
      {
        System.out.println(question);
      }
    }
  }

  @Override
  public String toString()
  {
    String text = "";
    for (String theme : themes.getList())
    {
      text += theme + " ";
    }
    return "[" + text + "]";
  }
}
