import java.util.*;
public class Game extends Entity {
  static int[] treasurePos = new int[2];

  public Game(int length, int width) {
    int x = (int) (length * Math.random());
    int y = (int) (width * Math.random());
    pos[0] = x;
    pos[1] = y;
    symbol = '.';
    score = 6;
  }
  
    public void gameWin(ArrayList<Entity> guys){
    Character hero = (Character)guys.get(0);
    Game currentGame = (Game)guys.get(1);
    hero.score += currentGame.score;
    String[] treasures = {"3 gold dubloons", "true love", "The One Piece", "Jimmy Hoffa's body", 
                          "Lindbergh Baby", "The Ark of the Covenant", "Amelia Earhart",
                          "Jon-Benet Ramsey", "The Higgs Boson", "A Map To The Lost City of Atlantis",
                          "A Map To Shangrila", "A Map To El Dorado"};
    String treasure = treasures[(int)(11 * Math.random() + 1)];
    System.out.println("You Found A Treasure! You got " + treasure + "\n Current Points: " + hero.score);
    currentGame.pos[0] = (int) (Main.roomSize[0] * Math.random());
    currentGame.pos[1] = (int) (Main.roomSize[1] * Math.random());
    currentGame.score = 6;
  }
  
  public boolean checkTreasure(ArrayList<Entity> guys) {
    int holeNum = guys.size() - 1;
    Hole newHole = (Hole)guys.get(holeNum);
    Game currentGame = (Game)guys.get(1);
    int[] distance = {Math.abs(newHole.pos[0] - this.pos[0]), Math.abs(newHole.pos[1] - this.pos[1])};
    int[] wrapDistance = findWrapDistance(newHole.pos, this.pos);
    int totalDistance = wrapDistance[0] + wrapDistance[1];
    System.out.println("You are " + totalDistance + " steps away from the treasure)");
    if (currentGame.score > 0)
      currentGame.score += newHole.score;
    return (distance[0] == 0 && distance[1] == 0);
  }

  public int[] findWrapDistance(int[] pointA, int[] pointB){
    int[] distanceVector = {findDistance(pointA[0], pointB[0]), findDistance(pointA[1], pointB[1])};
    int[] wrapDistance = {5 - Math.abs(5 - distanceVector[0]), 5 - Math.abs(5 - distanceVector[1])};
    return wrapDistance;
  }
  public int findDistance(int x1, int x2){
    return Math.abs(x1 - x2);
  }

}
