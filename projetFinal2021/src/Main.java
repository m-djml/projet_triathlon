import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    ArrayList<Athlete> classement = new ArrayList<Athlete>();
    ArrayList<Athlete> athletes = new ArrayList<Athlete>();
    ArrayList<Spectateur> spectateurs = new ArrayList<Spectateur>();

    Piscine piscine = new Piscine();
    piscine.creerTerrain();

    PisteCyclable pisteCyc = new PisteCyclable();
    pisteCyc.creerTerrain();

    PisteCourse pisteCour = new PisteCourse();
    pisteCour.creerTerrain();

    // spectateurs placés au hasard sur la première ligne
    Spectateur s1 = new Spectateur((int) Math.random() * 10);
    Spectateur s2 = new Spectateur((int) Math.random() * 20 + 10);

    // on les ajoute dans la liste des spectateurs
    spectateurs.add(s1);
    spectateurs.add(s2);

    // on crée l'athlète de l'utilisateur et les deux autres
    NameSingleton votreNom = NameSingleton.getInstance();
    Athlete vous = new Athlete(3, votreNom.toString(), piscine);
    Athlete a2 = new Athlete(4, "B", piscine);
    Athlete a3 = new Athlete(5, "A", piscine);

    // on les ajoute dans la liste d'athlètes
    athletes.add(vous);
    athletes.add(a2);
    athletes.add(a3);

    // on place les athlètes et les spectateurs sur le premier terrain
    piscine.placerSpectateurs(spectateurs);
    piscine.placerAthletes(athletes);
    pisteCyc.placerSpectateurs(spectateurs);
    pisteCour.placerSpectateurs(spectateurs);

    Epreuve triathlon = new Epreuve(piscine, pisteCyc, pisteCour, athletes, spectateurs, classement);
    triathlon.simuler();
    for (int i = 0; i < athletes.size(); i++) {
      Athlete athleteTemp = athletes.get(i);
      if (athleteTemp.aFini()) {
        int temp = athleteTemp.getRang() + 1;
        System.out.println(athleteTemp.getNom() + " est n°" + temp);
      }
    }
  }
}
