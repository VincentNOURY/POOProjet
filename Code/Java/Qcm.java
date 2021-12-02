package pooprojet;

class Qcm extends Question //implements Question
{
  private String[] reponses = new String[3];
  private int indiceBonneReponse;

  public Qcm(String theme, String question, int difficulte, String[] reponses, int indiceBonneReponse)
  {
    super(theme, question, difficulte);
    this.reponses = reponses;
    this.indiceBonneReponse = indiceBonneReponse;
  }

  @Override
  public String toString()
  {
    String outputReponses = "";
    for (String reponse : reponses)
    {
      outputReponses += reponse + "\n";
    }
    return "Type : QCM\nTheme : " + super.theme + "\nDifficulté : " + super.difficulte + "\nQuestion : " + super.question + "\nRéponses :\n" + outputReponses;
  }

  public String getTheme()
  {
    return super.theme;
  }

  public int getDifficulte(){
    return super.difficulte;
  }

  public boolean reponse(String res){
    return Integer.parseInt(res) - 1 == this.indiceBonneReponse;
  }

  public String getType(){
    return "Qcm";
  }

  public String getReponse(){
    return this.reponses[indiceBonneReponse];
  }
}
