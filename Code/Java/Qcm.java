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
}
