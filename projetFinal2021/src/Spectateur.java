public class Spectateur extends Personne {
    public Spectateur(int x) {
        this.x=x;
    }

    public void lancerProjectile(Athlete a) {
      if ((a.getTricherie())&&((a.x==x)||(a.x==x+1)||(a.x==x-1))) {
        a.baisserVitesse();
        System.out.print(a.getNom());
        System.out.println(" s'est pris un projectile !");
      }
    }

    public void acclamerAthlete(Athlete a){
      System.out.println(a.getNom()+" se fait acclamer !");
      double rand = Math.random();
      if (rand<0.4){
         a.vitesse++;
         System.out.println(a.getNom()+" est confiant !");
       }
    }
    public void huerAthlete(Athlete a){
      System.out.println(a.getNom()+" se fait huer !");
      double rand = Math.random();
      if (rand<0.4){
        a.vitesse--;
        System.out.println(a.getNom()+" n'est pas confiant...");
    }
  }
}
