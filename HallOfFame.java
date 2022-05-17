import java.io.*;
import java.util.Objects;

public class HallOfFame {

  public int[] tabScore; //tableau de 5
  public String[] tabNom; //tableau de 5

  public HallOfFame(){
    int i;
    this.tabScore = new int[5];
    this.tabNom = new String[5];
    for(i=0;i<5;i++) {
      this.tabScore[i]=-1;
      this.tabNom[i]="Default";
    }
  }

  public HallOfFame(int[] tabScore1, String[] tabNom1){
    int i;
    this.tabScore=new int[5];
    this.tabNom = new String[5];
    for(i=0;i<5;i++) {
      this.tabScore[i]=tabScore1[i];
      this.tabNom[i]=tabNom1[i];
    }
  }

  public int getScore(int rang){
    return this.tabScore[rang+1];
  }

  public String getPseudo(int rang){
    return this.tabNom[rang+1];
  }

  public int getScore(String pseudo){ //prend forcèment le meilleur score ?
    int i=0;                          //renvoie -1 si il n'y est pas
    int test=0;
    while (i<5 && test==0) {
      if (this.tabNom[i]==pseudo){
        test=1;
      }
      i++;
    }
    if(test==1){
      return this.tabScore[i-1];
    } else {
      return -1;
    }
  }

  public void setScore(int score, String pseudo){
    if (score>this.tabScore[4]){
      int i=4;
      while(i>0 && this.tabScore[i]<=score){
        this.tabScore[i]=this.tabScore[i-1];
        this.tabNom[i]=this.tabNom[i-1];
        i--;
      }
      if (score>=this.tabScore[0]){
        this.tabScore[0]=score;
        this.tabNom[0]=pseudo;
      } else {
        this.tabScore[i+1]=score;
        this.tabNom[i+1]=pseudo;
      }
    }
  }

  public String toString(){
    String res;
    int i;
    res="";
    for(i=0;i<5;i++) {
      res=res+" |"+(i+1)+" "+this.tabScore[i]+" "+this.tabNom[i];
    }
    return res;
  }

  public void enregisterHall(){
    int i;
    PrintWriter printWriter = null;
    //String textToBeWritten = "Hello";
        {
            try {
                printWriter = new PrintWriter("HallOfFame.txt");
            } catch (FileNotFoundException e) {
                System.out.println("Unable to locate the fileName: " + e.getMessage());
            }
            for(i=0;i<5;i++) {
              Objects.requireNonNull(printWriter).println(this.tabNom[i]);
              Objects.requireNonNull(printWriter).println(this.tabScore[i]);
            }
            printWriter.close();
        }
  }

  public void chargerHall(){
    int i;
    File fichier;

    fichier=new File("HallOfFame.txt");
    if(fichier.exists()){
      try(BufferedReader br = new BufferedReader(new FileReader("HallOfFame.txt")))
      {
          for(i=0;i<5;i++) {
            this.tabNom[i]=br.readLine();
            this.tabScore[i]=Integer.valueOf(br.readLine());
          }
      }
      catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
      }
    }
  }

  //test
    public static void main(String[] args) {
      int[] tabscoretest=new int[]{500,400,300,200,100};
      String[] tabnomtest=new String[]{"Diane","MC","Clement","Nom2","Nom1"};
      HallOfFame h1 = new HallOfFame(tabscoretest,tabnomtest);
      HallOfFame h2= new HallOfFame();
      h1.enregisterHall();
      h2.chargerHall();
    /*  h1.tabNom[2]="diane";
      h1.tabNom[1]="clement";
      h1.tabNom[4]="mc";
      h1.tabScore[2]=3;*/
      h1.setScore(550, "IHB");
      System.out.println(h1.toString());
      System.out.println(h2.toString());
    }

}
