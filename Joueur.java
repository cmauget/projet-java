import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import java.util.Scanner;



public class Joueur extends Combinaison {

  public String pseudo;
  public Combinaison combi;


  public Joueur(){
    this.pseudo="";
    this.combi= new Combinaison();
  }

  public Joueur(String pseudo){
    this.pseudo=pseudo;
    this.combi= new Combinaison();
  }


  public void creerCombi(int taille){
    int i=0;
    System.out.println("Veuillez entrer votre combinaison svp");

    for(i=0;i<combi.taille;i++)
    {
    Scanner sc = new Scanner(System.in);
    String CombiClavier = sc.nextLine();
    System.out.println("vous avez saisi la combinaison suivante:"+CombiClavier);
    }
  }

   public String toString(){
     int i=0;
     String res="";
     res = combi.toString();
     res=res+" joueur = "+this.pseudo;
     return res;
   }


  //test
  public static void main(String[] args){
    Joueur j1=new Joueur("diane");
    System.out.println(j1.toString());
    couleur[] combi2=new couleur[]{couleur.bleu, couleur.rouge, couleur.vert};
    Combinaison combi=new Combinaison(3, combi2);
    System.out.println(combi.toString());
    Combinaison NewCombi = new creerCombi(5);
  }
}
