import java.util.*;
import javax.swing.*;

public class Main {
  static int[] roomSize = { 10, 10 };

  public static void main(String[] args) {
    JFrame frame = new JFrame("My app");
    frame.setSize(300, 300);
    GUI newGUI = new GUI();
    System.out.println("COOL TIP: You can string multiple movement commands in one input like ne, nn, nneee, etc");
    ArrayList<Entity> guys = gameStart();
    Character hero = (Character)guys.get(0);

    char[][] points = Room.buildMap(roomSize[0], roomSize[1]);
    Room mainMap = new Room(points);
    Controls user = new Controls();

    mainMap.spawnChar(guys);
    //newGUI.makeButtons(frame);
    //newGUI.fillPanels(frame, mainMap);
    System.out.println(" ");
    mainMap.render(roomSize[0], roomSize[1]);
    frame.setVisible(true);

    while (hero.pos[0] < 20) {
      String[] move = user.moveInput();
      int[] movement = user.charVector(guys, move);
      hero.moveChar(mainMap, guys, movement);
    }
  }
  public static ArrayList<Entity> gameStart(){
    Game newGame = new Game(roomSize[0], roomSize[1]);
    Character hero = new Character();
    ArrayList<Entity> guys = new ArrayList<Entity>();
    newGame.findWrapDistance(newGame.pos, hero.pos);
    guys.add(hero);
    guys.add(newGame);

    return guys;
  }
}
