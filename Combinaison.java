import java.util.Random;
import java.util.Scanner;

public class Combinaison {

//  public enum couleur{rouge, bleu, vert, jaune, orange, blanc, noir, rose};
  public int taille;
  public int[] combi;

  public Combinaison(){
    this.taille=4;
    int i=0;
    this.combi = new int[this.taille];
    for(i=0;i<taille;i++) {
      this.combi[i]=-1; //-1 par défaut
    }
  }

  public Combinaison(int taille1){
    this.taille=taille1;
    int i=0;
    this.combi = new int[this.taille];
    for(i=0;i<taille;i++) {
      this.combi[i]=-1; //-1 par défaut
    }
  }

  public Combinaison(int taille1, int[] combi1){
    this.taille=taille1;
    int i=0;
    this.combi = new int[this.taille];
    for(i=0;i<this.taille;i++) {
      try{
          this.combi[i]=combi1[i];
  			}
  		catch(ArrayIndexOutOfBoundsException e){
        this.taille=i;
  			System.out.println("Attention, la taille est trop grande. Nouvelle taille à "+this.taille);
      }
    }
  }

  public void setCombi(int[] combi1){
    int i=0;
    for(i=0;i<taille;i++) {
      this.combi[i]=combi1[i];
    }
  }

  public String toString(){
    int i=0;
    String res="| ";
    for(i=0;i<this.taille;i++) {
      res=res+this.combi[i]+" | ";
    }
    return res;
  }

  public int[] getCombi(){
    return this.combi;
  }

  public int getTaille(){
    return this.taille;
  }

  //pour ordinateur
  public void genererCombi(int niveauDifficulte){
    Random rnd = new Random();
    //nbr couleurs dispo;
    int m=7;
    this.taille=niveauDifficulte;
    for (int k=0;k<niveauDifficulte;++k){
      this.combi[k] = rnd.nextInt(m)+1;
      }
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

  public int[] testCombi(Combinaison combitest){
    int i,j,malplace=0;
    int bienplace=0;
    boolean test=false;
    //[0 pour faux, 1 pour vrai / nbre de bien place / nbre de mal place]
    for(i=0;i<this.taille;i++) {
      j=0;
      if (combitest.combi[i]==this.combi[i]){
        bienplace++;
      } else{
        while (!test && j<this.taille){
          if (combitest.combi[j]==this.combi[i] && j!=i){
            malplace++;
            test=true;
          }
          j++;
        }
      }
      test=false;
    }
    int[] res=new int[]{0,bienplace,malplace};
    return res;
  }

//test
  public static void main(String[] args) {
    Combinaison combi=new Combinaison();
    int[] resr=new int[3];
    int[] combitab2=new int[]{1,2,3};
    int[] combitab3=new int[]{3, 4, 1, 2};
    int[] combitabtest=new int[]{1, 2, 5, 5};
    int[] combitab4=new int[3];
    Combinaison combi2=new Combinaison(3, combitab2);
    Combinaison combitest=new Combinaison(4, combitabtest);
    combitab4=combi2.getCombi();
    Combinaison combi3=new Combinaison(5, combitab3);
    System.out.println(combi.toString());
    combi.setCombi(combitab3);
    System.out.println(combi.toString());
    System.out.println(combi2.toString());
    System.out.println(combi3.toString());
    resr=combi.testCombi(combitest);
    System.out.println("bien place : "+resr[1]+" mal place : "+resr[2]);
    combi.genererCombi(4);
    System.out.println(combi.toString());
  }

}
