import java.util.ArrayList;

public class Piscine extends Terrain {

  public Piscine() {
    tab = new String[longueur][largeur];
    for (int i = 0; i < longueur; i++) {
      for (int j = 0; j < largeur; j++) {
        tab[i][j] = " ";
      }
    }
  }

  public void placerSpectateurs(ArrayList<Spectateur> ps) {
    for (int i = 0; i < ps.size(); i++) {
      tab[(ps.get(i)).getX()][0] = "S";
    }
  }

  public void placerAthletes(ArrayList<Athlete> pa) {
    for (int i = 0; i < pa.size(); i++) {
      tab[(pa.get(i)).getX()][(pa.get(i)).getY()] = (pa.get(i)).getNom();
    }
  }

  public String[][] creerTerrain() {
    for (int i = 0; i < longueur; i++) {
      for (int j = 1; j < largeur; j++) {
        tab[0][j] = "\n";
        if ((j == 1) || (j == largeur - 1)) {
          tab[i][j] = "_";
        }
      }
    }
    return tab;
  }

  public void deplacement(int x, int y, String s, Athlete a) {
    try {
      tab[x][y] = s;
      a.remiseA0();
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    }
  }

  public String toString() {
    String res = "";
    for (int j = 0; j < largeur; j++) {
      for (int i = 0; i < longueur; i++) {
        res += tab[i][j];
      }
    }
    return res;
  }

  public String[][] getTab() {
    return tab;
  }

  public String getNomTerrain() {
    return "piscine";
  }
}
