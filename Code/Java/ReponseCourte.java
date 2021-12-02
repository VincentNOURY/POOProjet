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
    return "Type : Réponse Courte\nTheme : " + super.theme + "\nDifficulté : " + super.difficulte + "\nQuestion : " + super.question + "\n";
  }

  public String getTheme()
  {
    return this.theme;
  }

  public int getDifficulte(){
    return super.difficulte;
  }

  public boolean reponse(String res){
    return res.equals(this.reponse);
  }

  public String getType(){
    return "ReponseCourte";
  }

  public String getReponse(){
    return this.reponse;
  }
}
