public class Combinaison {

  public enum couleur{rouge, bleu, vert, jaune, orange, blanc, noir, rose};
  public int taille;
  public couleur[] combi;

  public Combinaison(){
    this.taille=4;
    int i=0;
    this.combi = new couleur[this.taille];
    for(i=0;i<taille;i++) {
      this.combi[i]=couleur.rouge;
    }
  }

  public Combinaison(int taille1, couleur[] combi1){
    this.taille=taille1;
    int i=0;
    this.combi = new couleur[this.taille];
    for(i=0;i<taille;i++) {
      try{
          this.combi[i]=combi1[i];
  			}
  		catch(ArrayIndexOutOfBoundsException e){
  			System.out.println("Attention, la taille est trop grande. Prévoir des erreurs");
      }
    }
  }

  public void setCombi(couleur[] combi1){
    int i=0;
    for(i=0;i<taille;i++) {
      this.combi[i]=combi1[i];
    }
  }

  public String toString(){
    int i=0;
    String res="";
    for(i=0;i<taille;i++) {
      res=res+this.combi[i]+" ";
    }
    return res;
  }

//test
  public static void main(String[] args) {
    Combinaison combi=new Combinaison();
    couleur[] combitab2=new couleur[]{couleur.bleu, couleur.rouge, couleur.vert};
    couleur[] combitab3=new couleur[]{couleur.bleu, couleur.rouge, couleur.vert,couleur.rouge};
    Combinaison combi2=new Combinaison(4, combitab2);
    System.out.println(combi.toString());
    combi.setCombi(combitab3);
    System.out.println(combi.toString());
    System.out.println(combi2.toString());
  }

}
