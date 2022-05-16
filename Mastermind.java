import java.util.Scanner;

public class Mastermind extends Partie{

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

  //Menu
  public void menu(){
    Scanner sc = new Scanner(System.in);//lire une variable
		System.out.println("Choississez ce que vous souhaitez faire : 1) Nouvelle Partie ");
    System.out.println(" 2) Regles");
    System.out.println(" 3) HallOfFame");
    System.out.println(" 4) Quitter");
		String str = sc.nextLine();

    if (str.equals("1")) {
      saisirNiveau();
      lancerPartie(int maxEssais,int taille);
    }
    if (str.equals("2")) {
      regles();
    }
    if (str.equals("3")) {
      System.out.println("");
    }
    if (srt.equals("4")){
      Partie newPartie = new Partie();
      newPartie.arreterPartie(int this.maxEssais,int this.taille);
    }
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


//texte de regles du menu
  public void regles(){
	   System.out.println("Pouvez-vous trouver ma combinaison de " + this.taille +" symboles");
	   System.out.println("[chiffres entre 1 et 7 avec repetitions possibles]");
	   System.out.println("en moins de "+ this.maxEssais +" coups? Entrez les symboles des ");
	   System.out.println("propositions terminees par [Entree].");
     System.out.println("(# un bien place, o un mal place)" + "\n");
	}


	//Jeu du mastermind
  public static void main(String[] args){
  	 Mastermind mast = new Mastermind();
     int nbEssais=0;
     mast.saisirNiveau();
  }
}
