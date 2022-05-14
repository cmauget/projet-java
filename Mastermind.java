import java.util.Scanner;

public class Mastermind {

	public static int taille;
	public static int maxEssais;

	public Mastermind(){
		this.taille=0;
		this.maxEssais=0;
	}

	public Mastermind(int tail, int mEssais){
		this.taille=tail;
		this.maxEssais=mEssais;
	}

	//saisir niveau du jeu
	public void saisirNiveau(){
  	Scanner input=new Scanner(System.in);
  	char c= '.';
  	while(!(c == 'n' || c == 'p' || c == 'k'))
  	{
   	 System.out.print("Niveau n)ovice p)ro k)iller?");
	 c=input.next().charAt(0);
	}
	  switch (c)
	    {
	    case 'n':
	      this.taille=4;
	      this.maxEssais=10;
	      //System.out.println(this.maxEssais + " " + this.taille);
	      break;
	    case 'p':
	      this.taille=5;
	      this.maxEssais=12;
	      //System.out.println(this.maxEssais + " " + this.taille);
	      break;
	    case 'k':
	      this.taille=6;
	      this.maxEssais=15;
	      //System.out.println(this.maxEssais + " " + this.taille);
	      break;
	    }
	}


//	texte daccueil du jeu
//	public void bienvenu(int combi.taille, int maxCoups){
//	System.out.println("Pouvez-vous trouver ma combinaison de " + combi.taille +" symboles");
//	System.out.println("[chiffres entre 1 et 7 avec repetitions possibles]");
//	System.out.println("en moins de "+ maxEssais +" coups? Entrez les symboles des ");
//	System.out.println("propositions terminees par [Entree].");
//	System.out.println("(# un bien place, o un mal place)" + "\n");
//	}


	//Jeu du mastermind


  	public static void main(String[] args){
  	  Mastermind mast = new Mastermind();
    	int nbEssais=0;
    	mast.saisirNiveau();
    }
}
