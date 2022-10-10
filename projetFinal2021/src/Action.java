public interface Action{
  public void seDeplacer(int vitesse) throws NePeutPasAvancerException;
  public void pousserAthlete(Athlete a);
  public void lancerProjectile(Athlete a);
  public void acclamerAthlete(Athlete a);
  public void huerAthlete(Athlete a);
  public void seDoper();
}
