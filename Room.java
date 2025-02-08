import java.util.*;
public class Room{
        char[][] points;
    
        public Room(char[][] initPoints){
            points = initPoints;
        }
       
        public static char[][] buildMap(int x, int y){
            int length = x;
            int width = y;
            char[][] points = new char [length][width];
            
            for (int i = 0; i < length; i++){
                for (int j = 0; j < width; j++){
                    points[i][j] = '.';
                }
            }
            return points;
        }
        public int[] getSize(){
            int[] roomSize = {points.length, points[0].length};
            return roomSize;
        }
    
        public void render(int x, int y){
            for (int i = 0; i < x; i++){
                for (int j = 0; j < y; j++){
                    System.out.print(points[i][j] + " ");
                }
                System.out.println(" ");
            }
        }
    
        public char[][] spawnChar(ArrayList<Entity> guys){
            int x;
            int y;
            points = buildMap(points.length, points[0].length);
            for (int i = guys.size() - 1; i >= 0; i--){
                Entity guy = guys.get(i);
                x = guy.pos[0];
                y = guy.pos[1];
                points[x][y] = guy.symbol;
            }
            return points;
        }
    
        public int[] loopMap(int[] roomSize, Character hero){
            if (hero.pos[0] < 0)
                hero.pos[0] = points.length-1;
            if (hero.pos[0] >= points.length)
                hero.pos[0] = 0;
            if (hero.pos[1] < 0)
                hero.pos[1] = points[0].length-1;
            if (hero.pos[1] >= points[0].length)
                hero.pos[1] = 0;
                
            return hero.pos;
        }

}

