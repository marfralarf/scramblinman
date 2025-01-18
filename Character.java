public class Character{
  int[] pos = {0, 0};
  public Character(){
    pos[0] += 5;
    pos[1] += 5;
  }
  public Character(int[] initPos){
    pos = initPos;
  }
}
