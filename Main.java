import java.util.*;
public class Main {
  static int[] roomSize = { 10, 10 };

  public static void main(String[] args) {
    Game newGame = new Game(roomSize[0], roomSize[1]);
    char[][] points = Room.buildMap(roomSize[0], roomSize[1]);
    Room mainMap = new Room(points);
    Character hero = new Character();
    ArrayList<Entity> guys = new ArrayList<Entity>();
    guys.add(hero);
    guys.add(newGame);
    Controls user = new Controls();

    mainMap.spawnChar(guys);
    System.out.println(" ");
    mainMap.render(roomSize[0], roomSize[1]);
    
    while (hero.pos[0] < 20) {
      char move = user.moveInput();
      int[] movement = user.charVector(guys, move);
      hero.moveChar(mainMap, guys, movement);
    }
  }
  public static int addScore(int attempts, int score){
    score += attempts;
    return score;
  }

}
