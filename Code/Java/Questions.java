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
      themes.addTheme(q.getTheme());
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
      text+= "[" + theme + "\n";
      for (Question question : questions){
        if (question.getTheme().equals(theme)){
          text += question;
        }
      }
      text += "]\n";
    }
    return "[" + text + "]";
  }
}
