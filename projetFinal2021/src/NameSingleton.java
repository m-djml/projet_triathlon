import java.util.Scanner;

public class NameSingleton{

  private static final NameSingleton instance = new NameSingleton();
  private String votreNom;

  private NameSingleton(){
    // Athlete du joueur
    Scanner toScan = new Scanner(System.in);
    System.out.println("Entrez votre nom (un seul caractère):");
    votreNom = toScan.nextLine();
  }

  public static final NameSingleton getInstance(){
    return instance;
  }

  public String toString(){
    return votreNom;
  }
}
