import java.util.Scanner;
public class Controls{
  public static char moveInput(){
    Scanner directions = new Scanner(System.in);
    System.out.println("Pick your direction of movement");
    String input = directions.nextLine();
    return input.charAt(0);
  }
  public static int[] charVector(char nesw){
    int[] move = {0,0};
    switch (nesw){
        case 'n':
            move[1] = -1;
        break;
        case 'e':
            move[0] = 1;
        break;
        case 's':
            move[1] = 1;
        break;
        case 'w':
            move[0] = -1;
        break;
    }
    return move;
  }
}
