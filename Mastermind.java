import java.util.Scanner;

public class Mastermind extends JeuA2Joueur{

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
		System.out.println("Choississez ce que vous souhaitez faire : ");
		System.out.println(" 1) Nouvelle Partie");
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
		int taille2 = this.taille+3;
		int[][] ancienCombi = new int [this.maxEssais][taille2];
		int restant=0;
		int j=0;
		int l=1;
		System.out.print("\033[H\033[2J");
		System.out.flush();
		for (int i=0;i<this.maxEssais;i++){
			System.out.print("| "+0+" | "+0+" | "+0+" | "+0);
			System.out.print(" | nbp: "+0+" | nmp :"+0+" | nbEssais restants : "+restant);
			System.out.println(" ");
		}
		//demander combi utilisateur, test, tant que nbE<MaxE et pasTrouve combi
		do{
			part.chercheur.combi.creerCombi(this.taille);
			res = part.combi.testCombi(part.chercheur.combi);
			for (int k=0;k<=this.taille-1;k++){
				ancienCombi[j][k]=part.chercheur.combi.combi[k];
			}
			ancienCombi[j][this.taille]=res[1];
			ancienCombi[j][this.taille+1]=res[2];
			part.nbEssais++;
			restant=this.maxEssais-part.nbEssais;
			ancienCombi[j][this.taille+2]=restant;
			j++;
			//affichage
			affichage(part, restant, res, ancienCombi);
			} while((part.nbEssais<this.maxEssais)&&(res[1]!=this.taille));
				if (res[1]==this.taille){
					System.out.println("BRAVO ! Vous avez gagné :))");
					part.chercheur.score=this.maxEssais-part.nbEssais;
					this.scoreBoard.setScore(part.chercheur.score,part.chercheur.pseudo);
				}else
					{System.out.println("DOMMAGE ! Vous avez perdu :(");}
	}

	public void affichage(Partie part,int restant, int[] res, int[][] ancienCombi){
			System.out.print("\033[H\033[2J");
      System.out.flush();
			int indiceTab;
			indiceTab=this.maxEssais-restant;
			for (int j=0;j<indiceTab;j++){
				for (int i=0;i<this.taille;i++){
					System.out.print("| "+ancienCombi[j][i]);
					//System.out.print("| "+part.chercheur.combi.combi[i]);
				}
				System.out.print(" | nbp: "+ancienCombi[j][this.taille]+" | nmp :"+ancienCombi[j][this.taille+1]+" | nbEssais restants : "+ancienCombi[j][this.taille+2]);
				System.out.println(" ");
			}

			for (int j=indiceTab;j<this.maxEssais;j++){
				System.out.print("| "+0+" | "+0+" | "+0+" | "+0);
				System.out.print(" | nbp : "+0+" | nmp : "+0+" | nbEssais restants : "+0);
				System.out.println(" ");
			}
	}

	//Jeu du mastermind
  public static void main(String[] args){
  	 Mastermind mast = new Mastermind();
		 int test;
		 do{
			 mast.scoreBoard.chargerHall();
			 test=mast.menu();
			 if (test==2){
			 Partie newPartie = new Partie(mast.taille);
       newPartie.lancerPartie();
			 mast.jeu(newPartie);
			 mast.scoreBoard.enregisterHall();
		  }
		}while(test!=1);
  }
}
