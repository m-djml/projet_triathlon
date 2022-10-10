public class Athlete extends Personne {
  private int y;
  private String nom;
  private boolean estTricheur = false;
  private boolean estDansPiscine = true; // les athlètes commencent dans une piscine
  private Terrain terr;
  private boolean aFini = false;
  private int rang;

  public Athlete(int y, String nom, Terrain terr) {
    this.y = y;
    this.nom = nom;
    this.terr = terr;
  }

  public Athlete clone() { // clone
    return new Athlete(y, nom, terr);
  }

  public void seDeplacer(int vitesse) throws NePeutPasAvancerException {
    if (vitesse>=0){
      if (x<terr.getLongueur()){
        terr.resetCase(x, y);
      } else {
        throw new NePeutPasAvancerException();
      }
      x+=vitesse;
      estTricheur = false;
        if (x<terr.getLongueur()){
          terr.deplacement(x, y, nom);
        } else {
          throw new NePeutPasAvancerException();
        }
    } else {
      System.out.println(nom+" a du mal à avancer !");
      if (Math.random()<0.8) seDoper();
    }
  }

  public void pousserAthlete(Athlete a) {
    if ((y == a.y + 1) || (y == a.y - 1) || !(terr instanceof Piscine)) {
      a.vitesse -= 1;
      estTricheur = true;
      System.out.print(nom);
      System.out.print(" a poussé ");
      System.out.print(a.nom);
      System.out.println(" !");
    } else {
      String message = String.format("%s ne peut pas pousser %s car %s\n", nom, a.getNom(), terr.getNomTerrain());
      System.out.println(message);
    }
  }

  public void seDoper() {
    vitesse+=3;
    estTricheur = true;
    System.out.print(nom);
    System.out.println(" s'est dopé !");
  }

  public void baisserVitesse() {
    vitesse--;
  }

  public static int getVitesse() {
    return vitesse;
  }

  public int getY() {
    return y;
  }

  public String getNom() {
    return nom;
  }

  public Terrain getTerrain(){
    return terr;
  }

  public void changerTerrain(Terrain terr) {
    this.terr = terr;
  }

  public boolean getTricherie() {
    return estTricheur;
  }

  public void remiseA0(){
    x=0;
    vitesse=5;
  }

  public void finir(){
    aFini = true;
  }

  public boolean aFini(){
    return aFini;
  }

  public void modifierRang(int rang){
    this.rang = rang;
  }

  public int getRang(){
    return rang;
  }
}
