package pooprojet;
import java.util.ArrayList;
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


  public Question getRandomLevel1(){
    return diff1.get((int)(Math.random() * (diff1.size() + 1)));
  }

  public Question getRandomLevel2(){
    return diff2.get((int)(Math.random() * (diff2.size() + 1)));
  }

  public Question getRandomLevel3(){
    return diff3.get((int)(Math.random() * (diff3.size() + 1)));
  }
}
