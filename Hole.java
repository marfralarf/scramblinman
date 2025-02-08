public class Hole extends Entity {
  public Hole(int[] initHolePos) {
    pos = initHolePos;
    symbol = '*';
    score = -1;
  }
}
