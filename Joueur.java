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
