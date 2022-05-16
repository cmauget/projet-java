public class Cacheur extends Joueur{

  public Boolean humain ;
  public String pseudo;
  public Combinaison combi;


  public Cacheur(){
    this.humain=false;
    this.pseudo="NA";
    this.combi=new Combinaison();
  }

  public Cacheur(Boolean human,String pseudo){
    this.humain=human;
    this.pseudo=pseudo;
    this.combi=new Combinaison();
  }

  public String toString(){
    String res="";
    String scr = String.valueOf(humain);
    res = scr;
    res = res +" " + this.pseudo;
    res = res + " " + combi.toString();
    return res;
  }

  //test
    public static void main(String[] args) {
      Cacheur cach1=new Cacheur();
      Cacheur cach2=new Cacheur(true,"mc");
      System.out.println(cach1.toString());
      int[] combi2=new int[]{1,7,3,5,2};
      Combinaison combi1=new Combinaison(3, combi2);
      cach2.combi=combi1;
      System.out.println(cach2.toString());
    }

}
