package pooprojet;
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

  public ArrayList<String> getList()
  {
    return this.themeList;
  }

  @Override
  public String toString()
  {
    String text = "";
    for (int i = 0; i < themeList.size() - 1; i++)
    {
      text += themeList.get(i) + i + ", ";
    }
    text += themeList.get(themeList.size() - 1);
    return "[" + text + "]";
  }
}
