public class Partie {

  public Cacheur cacheur;
  public Chercheur chercheur;
  public Combinaison combi;
  public int nbEssais;
  //public enum etatJeu {jeuActuel, jeuGagne, jeuPerdu};
  //public int maxEssais;

  public Partie(){
    Cacheur cacheur=new Cacheur();
    Chercheur chercheur=new Chercheur();
    Combinaison combi=new Combinaison();
    nbEssais=0;
  }

  public Partie(Cacheur cach, Chercheur cherch, Combinaison comb, int essais){
    cacheur = cach;
    chercheur = cherch;
    combi = comb;
    nbEssais = essais;
  }

  public void lancerPartie(int maxEssais,int taille, int niveauDifficulte){
    Partie part = new Partie();
    Combinaison combi = new Combinaison(niveauDifficulte);
    Combinaison combi2 = new Combinaison(niveauDifficulte);
    combi.genererCombi(niveauDifficulte);
    int nbp=0;
    int nmp=0;
    //initialise les parametres du chercheur
    nbEssais = 0;
    //test proposition=solution
    boolean trouve=false;
    while (!trouve && (nbEssais < maxEssais)){
      //humain choisit une combinaison a tester
      combi2.creerCombi(niveauDifficulte);
      //compte comme un essai
      nbEssais++;

      //resultat du code
  		for (int j=1; j <= nbp; j++)
  		{
  			System.out.println("#");
  		}
  		for (int j=1; j <= nmp; j++)
  		{
  			System.out.println("o");
  		}
  		System.out.println(" (reste " + (maxEssais - nbEssais) + " coups)");
  		}
    	//affiche le score
    	if (trouve)
    	{
    		System.out.println("GAGNE en "+ nbEssais + " coups");
    	}
    	else
    	{
    		System.out.print("PERDU ... voici la combinaison : ");
    		System.out.println(combi.toString());
    	}
    }

  public void arreterPartie(){
    //trouver bonne combi
    //trop d'essais
  }

  public void setNbEssais(int nbessais){
    this.nbEssais = nbessais;
  }

  public int getNbEssais(){
    return this.nbEssais;
  }


}
