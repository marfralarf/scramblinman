import java.util.*;

public class Controls {
    public Controls() {
    }

    public char moveInput() {
        Scanner directions = new Scanner(System.in);
        System.out.println("Pick your direction of movement. Press n, e, s, or w to move and x to dig a hole!");
        String input = directions.nextLine();
        return input.charAt(0);
    }

    public int[] charVector(ArrayList<Entity> guys, char news) {
        int[] move = { 0, 0 };
        Character hero = (Character)guys.get(0);
        switch (news) {
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
            case 'x':
                guys.add(hero.digHole());
                Game currentGame = (Game)guys.get(1);
                if (currentGame.checkTreasure(guys))
                    currentGame.gameWin(guys);
                break;
            default:
                break;
        }
        return move;
    }
}
