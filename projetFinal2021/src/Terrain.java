public abstract class Terrain {
  protected static final int longueur = 30;
  protected static final int largeur = 7;
  protected String[][] tab;

  public void resetTerrain() {
    for (int i = 0; i < longueur; i++) {
      for (int j = 1; j < largeur; j++) {
        tab[0][j] = "\n";
        if ((j == 1) || (j == largeur - 1)) {
          tab[i][j] = "_";
        }
      }
    }
  }

  public void resetCase(int x, int y) {
    tab[x][y] = " ";
  }

  public abstract String[][] creerTerrain();

  public void deplacement(int x, int y, String s) {
    tab[x][y] = s;
  }

  public int getLongueur() {
    return longueur;
  }

  public int getLargeur() {
    return largeur;
  }

  public String getNomTerrain() {
    return "terrain";
  }
}
