public class Chercheur {

   public int score ;

   public Chercheur(){
     this.score=0;
   }

   public Chercheur(int points){
     this.score=points;
   }

   public int getScore(){
     return this.score;
   }

   public void setScore(int points){
     this.score=points;
   }

   //test
     public static void main(String[] args) {
       Chercheur cherch1=new Chercheur();
       Chercheur cherch2=new Chercheur(5);
       System.out.println(cherch1.score);
       System.out.println(cherch2.score);
     }

}
