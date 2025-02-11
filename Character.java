import java.util.ArrayList;

public class Character extends Entity {
  public Character() {
    pos[0] += (int)(Main.roomSize[0] / 2);
    pos[1] += (int)(Main.roomSize[1] / 2);
    symbol = '0';
    score = 0;
  }

  public Character(int[] initPos) {
    pos = initPos;
    symbol = '0';
  }

  public int[] getPos(Character guy) {
    return pos;
  }

  public void moveChar(Room mainMap, ArrayList<Entity> guys, int[] movement) {
    Character hero = (Character) guys.get(0);
    hero.pos[0] += movement[1];
    hero.pos[1] += movement[0];
    int[] roomSize = mainMap.getSize();
    mainMap.loopMap(hero);
    mainMap.spawnChar(guys);
  }
  public Hole digHole() {
    int[] holePos = pos.clone();
    Hole hole = new Hole(holePos);
    return hole;
  }
}
