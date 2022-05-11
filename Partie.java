public class Partie {

  public Joueur cacheur;
  public Joueur chercheur;
  public Combinaison combi;
  public int nbEssais;

  public Partie(){
    cacheur=joueur();
    chercheur=joueur();
    combi=combinaison();
    nbEssais=0;
  }

  public Partie(Joueur cach, Joueur cherch, Combinaison comb, int essais){
    cacheur = cach;
    chercheur = cherch;
    combi = comb;
    nbEssais = essais;
  }

  public void lancerPartie(){
    Partie part = new Partie();
  }

  public void arreterPartie(){

  }

  public Boolean testCombi(Combinaison test){
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
