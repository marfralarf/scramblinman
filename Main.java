public class Main {
  static int[] roomSize = {10, 10};
  
  public static void main(String[] args){
      char[][] points = Room.buildMap(roomSize[0], roomSize[1]);
      Room mainMap = new Room(points);
      Character hero = new Character();

      mainMap.spawnChar(hero.pos[0], hero.pos[1]);
      System.out.println(" ");
      mainMap.render(roomSize[0], roomSize[1]);
    while (hero.pos[0] < 20){
      char move = Controls.moveInput();
      int[] movement = Controls.charVector(hero, move);
      moveChar(mainMap, hero, movement);
      }
  }
    public static void moveChar(Room mainMap, Character hero, int[] movement){
      hero.pos[0] += movement[1];
      hero.pos[1] += movement[0];
      
      mainMap.loopMap(roomSize, hero);
      mainMap.spawnChar(hero.pos[0], hero.pos[1]);
      mainMap.render(roomSize[0], roomSize[1]);
    }
  }
