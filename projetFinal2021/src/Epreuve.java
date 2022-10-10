import java.util.ArrayList;

public class Epreuve {
    private Piscine piscine;
    private PisteCyclable pisteCyc;
    private PisteCourse pisteCour;
    private ArrayList<Athlete> athletes;
    private ArrayList<Spectateur> spectateurs;
    private ArrayList<Athlete> classement;

    public Epreuve(Piscine piscine, PisteCyclable pisteCyc, PisteCourse pisteCour, ArrayList<Athlete> athletes, ArrayList<Spectateur> spectateurs, ArrayList<Athlete> classement) {
      this.piscine = piscine;
      this.pisteCyc = pisteCyc;
      this.pisteCour = pisteCour;
      this.athletes = athletes;
      this.spectateurs = spectateurs;
      this.classement = classement;
    }

    public void triche(Athlete a){
      if (Math.random()<0.5) a.pousserAthlete(athletes.get((int)(Math.random()*2+1)));
      if (Math.random()<0.5) a.seDoper();

      if (Math.random()<0.5) (spectateurs.get((int)(Math.random()*(spectateurs.size())))).lancerProjectile(athletes.get((int)(Math.random()*2)));
      if (Math.random()<0.5) (spectateurs.get((int)(Math.random()*(spectateurs.size())))).acclamerAthlete(athletes.get((int)(Math.random()*2)));
      if (Math.random()<0.5) (spectateurs.get((int)(Math.random()*(spectateurs.size())))).huerAthlete(athletes.get((int)(Math.random()*2)));
    }

    public void simuler(){
      int rang = 0;
      while (rang<=2){
        for (int i=0; i<athletes.size(); i++){
          Athlete athleteTemp = athletes.get(i);
          if (classement.contains(athleteTemp)) continue;
          //Exceptions
          if (athleteTemp.getTerrain() instanceof Piscine){
            try { // piscine
              athleteTemp.seDeplacer(athleteTemp.getVitesse());
              triche(athleteTemp);
            } catch (NePeutPasAvancerException e){
                    athleteTemp.changerTerrain(pisteCyc); // l'athlete passe dans la piste cyclable
                    pisteCyc.deplacement(0, athleteTemp.getY(), athleteTemp.getNom(), athleteTemp); // il se place au début de la piste cyclable
              }
            }
          else if (athleteTemp.getTerrain() instanceof PisteCyclable){
            try { // piste cyclable
              athleteTemp.seDeplacer(athleteTemp.getVitesse());
              triche(athleteTemp);
            } catch (NePeutPasAvancerException e2){
                  athleteTemp.changerTerrain(pisteCour);
                  pisteCour.deplacement(0, athleteTemp.getY(), athleteTemp.getNom(), athleteTemp); // il se place au début de la piste de course
            }
          }
          else if (athleteTemp.getTerrain() instanceof PisteCourse){
            try { // piste course
              athleteTemp.seDeplacer(athleteTemp.getVitesse());
              triche(athleteTemp);
          } catch (NePeutPasAvancerException e3){
                  athleteTemp.finir();
                  String message = String.format("%s a fini le triathlon !\n", athleteTemp.getNom());
                  System.out.println(message);
                  athleteTemp.modifierRang(rang);
                  classement.add(athleteTemp);
                  rang++;
            }
          }
          System.out.println("\n      PISCINE");
          piscine.resetTerrain();
          System.out.println(piscine);
          System.out.println("      PISTE CYCLABLE");
          pisteCyc.resetTerrain();
          System.out.println(pisteCyc);
          System.out.println("      PISTE DE COURSE");
          pisteCour.resetTerrain();
          System.out.println(pisteCour+"\n");

          try {
              Thread.sleep(1000);
          } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
          }
        }
      }
    }
  }
