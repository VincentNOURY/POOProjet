package pooprojet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Math;

class Questions
{
  private ArrayList<Question> questions;
  private ArrayList<Question> diff1;
  private ArrayList<Question> diff2;
  private ArrayList<Question> diff3;
  private Themes themes;

  public Questions()
  {
      questions = new ArrayList<>();
      themes = new Themes();
      diff1 = new ArrayList<>();
      diff2 = new ArrayList<>();
      diff3 = new ArrayList<>();
  }

  public void add(Question q)
  {
      this.questions.add(q);
      this.themes.addTheme(q.getTheme());
      if (q.getDifficulte() == 1){
        diff1.add(q);
      }
      else if (q.getDifficulte() == 2){
        diff2.add(q);
      }
      else if (q.getDifficulte() == 3){
        diff3.add(q);
      }
  }

  public void remove(int i)
  {
      this.questions.remove(i);
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
    for (String theme : this.themes.getList())
    {
      text+= "[" + theme + "\n";
      for (int i = 0; i < questions.size(); i++){
        if (questions.get(i).getTheme().equals(theme)){
          text += "numero : " + i + "\n" + questions.get(i);
        }
      }
      text += "]\n";
    }
    return "[" + text + "]";
  }


  public Question getRandomLevel1ByTheme(String theme){
    LinkedList<Question> themed = new LinkedList<>();
    for (Question question : diff1){
      if (question.getDifficulte() == 1 && question.getTheme().equals(theme)){
        themed.add(question);
      }
    }
    return themed.get((int)(Math.random() * (themed.size() + 1)));
  }

  public Question getRandomLevel2ByTheme(String theme){
    LinkedList<Question> themed = new LinkedList<>();
    for (Question question : diff1){
      if (question.getDifficulte() == 2 && question.getTheme().equals(theme)){
        themed.add(question);
      }
    }
    return themed.get((int)(Math.random() * (themed.size() + 1)));
  }

  public Question getRandomLevel3ByTheme(String theme){
    LinkedList<Question> themed = new LinkedList<>();
    for (Question question : diff1){
      if (question.getDifficulte() == 3 && question.getTheme().equals(theme)){
        themed.add(question);
      }
    }
    return themed.get((int)(Math.random() * (themed.size() + 1)));
  }
}
