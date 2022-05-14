public class Partie {

  public Cacheur cacheur;
  public Chercheur chercheur;
  public Combinaison combi;
  public int nbEssais;
  public enum etatJeu {jeuActuel, jeuGagne, jeuPerdu};
  public int maxEssais;

  public Partie(){
    cacheur=joueur();
    chercheur=joueur();
    combi=combinaison();
    nbEssais=0;
  }

  public Partie(Cacheur cach, Chercheur cherch, Combinaison comb, int essais){
    cacheur = cach;
    chercheur = cherch;
    combi = comb;
    nbEssais = essais;
  }

  public void lancerPartie(int maxEssais,int niveauDifficulte){
    Partie part = new Partie();
    genererCombi(int niveauDifficulte);
    //initialise les parametres du chercheur
    nbEssais = 0;
    //test proposition=solution
    boolean trouve=false;
    while (!trouve && (nbEssais < maxEssais)){
      //humain choisit une combinaison a tester
      saisirCombi();
      //compte comme un essai
      nbEssais++;

      int nbp = 0;
      int nmp = 0;

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
    		afficherCombi(combi.tab[],combi.taille);
    	}
    	}
      }
    }

  public void arreterPartie(){
    //trouver bonne combi
    //trop d'essais
  }

//  public int BIEN_PLACE = -1;
  //public int MAL_PLACE=0;

  public int trouverBienPlaces(Combinaison test){
    int nbp=0;
    int i=0;
    for (i=0;i<n;i++){
      if (test.tab[i]==combi.tab[i]){
        nbp++;
        test.tab[i]=BIEN_PLACE;
      }
    }
    return nbp;
  }

  public int position(int valeur){
    int i=0;
    while (i<combi.taille && combi.tab[i] != valeur){
      i++;
    }
    return (i<n ? i : -1);
  }

  public int trouverMalPlaces(Combinaison test){
    int nmp=0;
    int i=0;
    for (i=0;i<n;i++){
      if (test.tab[i] != BIEN_PLACE){
        int p = position (combi.tab[i],test)
        if (p != -1){
            nmp++;
            test.tab[i] = MAL_PLACE;
        }
      }
    }
    return nbp;
  }
  public boolean testCombi(Combinaison test){
    int i=0;
    var res = new Boolean(true);

    while ((res)&&(i<combi.taille)){
      if (test.tab[i] == combi.tab[i]) {
        res = true;
        i++;
      }
      else {
        res = false;
        i++;
        }
      }

    return (res);
  }

  public void setNbEssais(int nbessais){
    this.nbEssais = nbessais;
  }

  public int getNbEssais(){
    return this.nbEssais;
  }


}
