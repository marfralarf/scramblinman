import java.util.ArrayList;
public class Character{
  int[] pos = {0, 0};
  public Character(){
    pos[0] += 5;
    pos[1] += 5;
  }
  public Character(int[] initPos){
    pos = initPos;
  }
  public int[] getPos(Character guy){
    return this.pos;
  }
  
  ArrayList<Character> holes = new ArrayList<Character>();

  public ArrayList<Character> digHole(){
    int[] holePos = this.getPos(this);
    Character hole = new Character(holePos);
    holes.add(hole);
    System.out.print(holes);
    return holes;
  }
}
