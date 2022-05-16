import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import java.util.Scanner;



public class Joueur{

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


  public Combinaison creerCombi(int taille){
    int i=0;
    System.out.println("Veuillez entrer votre combinaison svp");
    int[] CombiClavier = new int[taille];
    Scanner sc = new Scanner(System.in);

    for(i=0;i<taille;i++){
      do{
          CombiClavier[i] = sc.nextInt();
        /*  System.out.println("Indice ; "+i);
          System.out.println(CombiClavier[i]<0 && CombiClavier[i]>8); */
       } while(CombiClavier[i]<=0 || CombiClavier[i]>=8);
   }
   Combinaison combi=new Combinaison(taille,CombiClavier);
   return combi;
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
    int[] combi2=new int[]{1,2,3,4,5};
    Combinaison combi=new Combinaison(5, combi2);
    System.out.println(combi.toString());
    Combinaison testCombi = new Combinaison(5);
    Joueur j3 = new Joueur();
    testCombi=j3.creerCombi(5);
    System.out.println(testCombi.toString());

    //Combinaison NewCombi = new  Combinaison(5,testCombi);

    System.out.println(" ");
  }
}
