public class Room{
        char[][] points;
        static int length;
        static int width;
    
        public Room(char[][] initPoints){
            points = initPoints;
        }
       
        public static char[][] buildMap(int x, int y){
            length = x;
            width = y;
            char[][] points = new char [length][width];
            
            for (int i = 0; i < length; i++){
                for (int j = 0; j < width; j++){
                    points[i][j] = '.';
                }
            }
            return points;
        }

        public void render(int x, int y){
            for (int i = 0; i < x; i++){
                for (int j = 0; j < y; j++){
                    System.out.print(points[i][j] + " ");
                }
                System.out.println(" ");
            }
        }
    
        public char[][] spawnChar(int x, int y){
            points = buildMap(length, width);
            points[x][y] = 'O';
            return points;
        }
        public int[] loopMap(int[] roomSize, Character hero){
            if (hero.pos[0] <= 0)
                hero.pos[0] = 9;
            if (hero.pos[0] >= length)
                hero.pos[0] = 0;
            if (hero.pos[1] <= 0)
                hero.pos[1] = 9;
            if (hero.pos[1] >= width)
                hero.pos[1] = 0;
                
            return hero.pos;
        }

}

