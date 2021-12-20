package application;
import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Math;

class Questions{
  private ArrayList<Question> questions;
  private ArrayList<Question> diff1;
  private ArrayList<Question> diff2;
  private ArrayList<Question> diff3;

  public Questions(){
      this.questions = new ArrayList<>();
      this.diff1 = new ArrayList<>();
      this.diff2 = new ArrayList<>();
      this.diff3 = new ArrayList<>();
  }

  public int size(){
    return this.questions.size();
  }

  public void add(Question q){
    this.questions.add(q);
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

  public void remove(int i){
      this.questions.remove(i);
  }

  public String getByTheme(String theme){
    String text = "";
    for (Question question : this.questions){
      if (question.getTheme().equals(theme))
      {
        text += question + "\n";
      }
    }
    return text;
  }

  public ArrayList<Question> getListByTheme(String theme){
    ArrayList<Question> array = new ArrayList<>();
    for (Question question : this.questions){
      if (question.getTheme().equals(theme))
      {
        array.add(question);
      }
    }
    return array;
  }

  @Override
  public String toString(){
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
      if (question.getTheme().equals(theme)){
        themed.add(question);
      }
    }
    return themed.get((int)(Math.random() * (themed.size())));
  }
}
