package application;
import java.util.ArrayList;

class Themes
{
  private ArrayList<String> themeList;

  public Themes()
  {
    themeList = new ArrayList<>();
  }

  public void addTheme(String theme)
  {
    themeList.add(theme);
  }

  public void remove(int i){
    themeList.remove(i);
  }

  public int size(){
    return this.themeList.size();
  }

  public ArrayList<String> getList()
  {
    return this.themeList;
  }

  public int getIndex(String theme) throws IllegalArgumentException{
    for (int i = 0; i < this.themeList.size(); i++){
      if (themeList.get(i).equals(theme)){
        return i;
      }
    }
    throw new IllegalArgumentException("Le theme spécifié n'existe pas");
  }

  public String getThemeByIndex(int index) throws IllegalArgumentException{
    if (index < themeList.size() && index >= 0){
      return themeList.get(index);
    }
    else{
      throw new IllegalArgumentException("Le theme spécifié n'existe pas");
    }
  }

  public String[] getRandomThemes(int n){
    ArrayList<String> themes = new ArrayList<>();
    ArrayList<Integer> alreadySelected = new ArrayList<>();
    for (int i = 0; i < n; i++){
      int index = (int)(Math.random() * (themeList.size() + 1));
      if (!alreadySelected.contains(index)){
        alreadySelected.add(index);
        themes.add(themeList.get(index));
      }
    }
    String[] ret = {themes.get(0), themes.get(1), themes.get(2), themes.get(3), themes.get(4)};
    return ret;
  }

  @Override
  public String toString()
  {
    String text = "";
    for (int i = 0; i < themeList.size() - 1; i++)
    {
      text += themeList.get(i) + " - index : " + i + ", ";
    }
    text += themeList.get(themeList.size() - 1) + " - index : " + (themeList.size() - 1);
    return "[" + text + "]";
  }
}
