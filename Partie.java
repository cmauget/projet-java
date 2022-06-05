import java.util.Scanner;

public class Partie {

  public Cacheur cacheur;
  public Chercheur chercheur;
  public Combinaison combi;
  public int nbEssais;
  public int taille;
  //public enum etatJeu {jeuActuel, jeuGagne, jeuPerdu};
  //public int taille;

  public Partie(){
    this.cacheur=new Cacheur();
    this.chercheur=new Chercheur();
    this.combi=new Combinaison();
    this.nbEssais=0;
    this.taille=4;//niveau de base
  }

  public Partie(int diff){
    this.cacheur=new Cacheur();
    this.chercheur=new Chercheur();
    this.combi=new Combinaison(diff);
    this.nbEssais=0;
    this.taille=diff;//niveau de base
  }

  public Partie(Cacheur cach, Chercheur cherch, Combinaison comb, int essais, int diff){
    this.cacheur = cach;
    this.chercheur = cherch;
    this.combi = comb;
    this.nbEssais = essais;
    this.taille=diff;
  }

  public void lancerPartie(){ //cree et lance une partie
    Scanner sc=new Scanner(System.in);
    Scanner sc2=new Scanner(System.in);
    Scanner sc3=new Scanner(System.in);
    int test;
    String wait;
    //initialise les parametres du chercheur
    System.out.println("La partie commence, le cacheur est un ordi(1) ou un joueur(0) ?");
    test=sc.nextInt();
    if(test==1){
      this.cacheur.combi=new Combinaison(this.taille);
      this.cacheur.combi.genererCombi(this.taille);
    } else {
      this.cacheur.humain=true;
      this.cacheur.pseudo="Ordi";
      this.cacheur.combi.creerCombi(this.taille);
    }
    this.combi=this.cacheur.combi;
    System.out.println("Quel est le pseudo du chercheur ? ");
    this.chercheur.pseudo=sc2.nextLine();
    System.out.println("La partie est bien initialisée");
    System.out.println("Le nom du joueur est : "+this.chercheur.pseudo);
    System.out.println("Le cacheur est un humain : "+this.cacheur.humain);
    System.out.println("La combinaison est : "+this.combi);
    System.out.println("Appuyez sur [Entree] pour commencer");
    wait=sc3.nextLine();
  }

  public void arreterPartie(Partie part){//Un peu moche
    part=null;
    System.gc(); //garbage collector
    System.out.println("La partie c'est bien arrétée");
  }

  public void setNbEssais(int nbessais){
    this.nbEssais = nbessais;
  }

  public int getNbEssais(){
    return this.nbEssais;
  }

  public static void main(String[] args){
    Partie part=new Partie();
    part.lancerPartie();
    part.arreterPartie(part);
  }


}
