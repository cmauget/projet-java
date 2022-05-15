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
      int i=1;
      while(i<4 && this.tabScore[i]>score){
        this.tabScore[i]=this.tabScore[i-1];
        this.tabNom[i]=this.tabNom[i-1];
        i++;
      }
      this.tabScore[i]=score;
      this.tabNom[i]=pseudo;
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

  //test
    public static void main(String[] args) {
      int[] tabscoretest=new int[]{500,400,300,200,100};
      String[] tabnomtest=new String[]{"Diane","MC","Clement","Nom2","Nom1"};
      HallOfFame h1 = new HallOfFame(tabscoretest,tabnomtest);
    /*  h1.tabNom[2]="diane";
      h1.tabNom[1]="clement";
      h1.tabNom[4]="mc";
      h1.tabScore[2]=3;*/
      h1.setScore(450, "IHB");
      System.out.println(h1.toString());
    }

}
