import java.util.Scanner;

public class Mastermind{

	public int taille;
	public int maxEssais;
	public int niveauDifficulte;
	public HallOfFame scoreBoard;

	public Mastermind(){
		this.taille=0;
		this.maxEssais=0;
		this.niveauDifficulte=1;
		this.scoreBoard=new HallOfFame();
	}

	public Mastermind(int tail, int mEssais,int niveau, HallOfFame score){
		this.taille=tail;
		this.maxEssais=mEssais;
		this.niveauDifficulte=niveau;
		this.scoreBoard=score;
	}

  //Menu
  public int menu(){
		int jeu=0;
    Scanner sc = new Scanner(System.in);//lire une variable
		System.out.println("Choississez ce que vous souhaitez faire : 1) Nouvelle Partie ");
    System.out.println(" 2) Regles");
    System.out.println(" 3) HallOfFame");
    System.out.println(" 4) Quitter");
		String str = sc.nextLine();


    if (str.equals("1")) {
      saisirNiveau();
			jeu=2;
    }
    if (str.equals("2")) {
      regles();
    }
    if (str.equals("3")) {
      System.out.println(this.scoreBoard);
    }
    if (str.equals("4")){
			jeu=1;
      //newPartie.arreterPartie(maxEssais, taille, niveauDifficulte);
    }
		return jeu;
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
				this.niveauDifficulte=1;
	      //System.out.println(this.maxEssais + " " + this.taille);
	      break;
	    case 'p':
	      this.taille=5;
	      this.maxEssais=12;
				this.niveauDifficulte=2;
	      //System.out.println(this.maxEssais + " " + this.taille);
	      break;
	    case 'k':
	      this.taille=6;
	      this.maxEssais=15;
				this.niveauDifficulte=3;
	      //System.out.println(this.maxEssais + " " + this.taille);
	      break;
	    }
			//return (niveauDifficulte);
	}


//texte de regles du menu
  public void regles(){
	   System.out.println("Pouvez-vous trouver ma combinaison de 4 à 6 symboles");
	   System.out.println("[chiffres entre 1 et 7 avec repetitions possibles]");
	   System.out.println("en moins de 10 à 15 coups? Entrez les symboles des ");
	   System.out.println("propositions terminees par [Entree].");
	}

	//procédure jeu
	public void jeu(Partie part){
		int[] res = new int[3];
		int restant;
		//demander combi utilisateur, test, tant que nbE<MaxE et pasTrouve combi
		do{
			part.chercheur.combi.creerCombi(this.taille);
			res = part.combi.testCombi(part.chercheur.combi);
			System.out.println("bien place : " +res[1]+" mal place : "+res[2]);
			part.nbEssais++;
			restant=this.maxEssais-part.nbEssais;
			System.out.println("il reste "+ restant+" essais");
		} while((part.nbEssais<this.maxEssais)&&(res[1]!=this.taille));
		if (res[1]==this.taille){
			System.out.println("BRAVO ! Vous avez gagné :))");
			part.chercheur.score=this.maxEssais-part.nbEssais;
		}else
		{System.out.println("DOMMAGE ! Vous avez perdu :(");}
	}


	//Jeu du mastermind
  public static void main(String[] args){
  	 Mastermind mast = new Mastermind();
		 int test;
		 do{
			 test=mast.menu();
			 if (test==2){
			 Partie newPartie = new Partie(mast.taille);
       newPartie.lancerPartie();
			 mast.jeu(newPartie);
		  }
		}while(test!=1);
  }
}
