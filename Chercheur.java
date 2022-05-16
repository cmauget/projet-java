public class Chercheur extends Joueur{

   public int score ;
   public String pseudo;
   public Combinaison combi;

   public Chercheur(){
     this.score=0;
     this.pseudo="NA";
     this.combi=new Combinaison();
   }

   public Chercheur(int points,String pseudo){
     this.score=points;
     this.pseudo=pseudo;
     this.combi=new Combinaison();
   }

   public int getScore(){
     return this.score;
   }

   public void setScore(int points){
     this.score=points;
   }

   public String toString(){
     String res="";
     String scr = String.valueOf(score);
     res = scr;
     res = res +" " + this.pseudo;
     res = res + " " + combi.toString();
     return res;
   }

   //test
     public static void main(String[] args) {
       Chercheur cherch1=new Chercheur();
       Chercheur cherch2=new Chercheur(5,"diane");
       System.out.println(cherch1.toString());
       int[] combi2=new int[]{1,2,6,5,3};
       Combinaison combi1=new Combinaison(5, combi2);
       cherch2.combi=combi1;
       System.out.println(cherch2.toString());
     }

}
