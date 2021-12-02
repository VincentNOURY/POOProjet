package pooprojet;

class VraiFaux extends Question
{
  private String reponse;

  public VraiFaux(String theme, String question, int difficulte, String reponse)
  {
    super(theme, question, difficulte);
    this.reponse = reponse;
  }

  @Override
  public String toString()
  {
    String outputReponses = "";
    outputReponses += " Vrai\n Faux\n";
    return "Type : Vrai Faux\nTheme : " + super.theme + "\nDifficulté : " + super.difficulte + "\nQuestion : " + super.question + "\nRéponses :\n" + outputReponses;
  }

  public String getTheme()
  {
    return super.theme;
  }

  public int getDifficulte(){
    return super.difficulte;
  }

  public boolean reponse(String res){
    return res.equals(this.reponse);
  }

  public String getType(){
    return "VraiFaux";
  }

  public String getReponse(){
    return this.reponse;
  }
}
