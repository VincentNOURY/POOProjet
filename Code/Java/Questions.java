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
      this.questions = new ArrayList<>();
      this.themes = new Themes();
      this.diff1 = new ArrayList<>();
      this.diff2 = new ArrayList<>();
      this.diff3 = new ArrayList<>();
  }

  public void add(Question q)
  {
      if (q.getDifficulte() == 1){
        this.diff1.add(q);
      }
      else if (q.getDifficulte() == 2){
        this.diff2.add(q);
      }
      else if (q.getDifficulte() == 3){
        this.diff3.add(q);
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
      if (question.getTheme().equals(theme))
      {
        System.out.println(question);
      }
    }
  } // might be useless

  public String getAllQuestionsByTheme(String theme){
    String text = "";
    for (int i = 0; i < this.questions.size(); i++){
      if (questions.get(i).getTheme().equals(theme)){
        text += "numero : " + i + "\n" + this.questions.get(i)+ "\n";
      }
    }
    return text;
  }

  @Override
  public String toString()
  {
    String text = "";
    for (int i = 0; i < this.questions.size(); i++){
      text += "numero : " + i + "\n" + this.questions.get(i)+ "\n";
    }
    return "[" + text + "]";
  }


  public Question getRandomLevel1ByTheme(String theme){
    LinkedList<Question> themed = new LinkedList<>();
    for (Question question : this.diff1){
      if (question.getTheme().equals(theme)){
        themed.add(question);
      }
    }
    return themed.get((int)(Math.random() * (themed.size())));
  }

  public Question getRandomLevel2ByTheme(String theme){
    LinkedList<Question> themed = new LinkedList<>();
    for (Question question : this.diff2){
      if (question.getTheme().equals(theme)){
        themed.add(question);
      }
    }
    return themed.get((int)(Math.random() * (themed.size())));
  }

  public Question getRandomLevel3ByTheme(String theme){
    LinkedList<Question> themed = new LinkedList<>();
    for (Question question : this.diff3){
      if ( question.getTheme().equals(theme)){
        themed.add(question);
      }
    }
    return themed.get((int)(Math.random() * (themed.size())));
  }
}
