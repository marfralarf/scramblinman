import java.util.*;

public class Controls {
    public Controls() {
    }

    public String[] moveInput() {
        Scanner directions = new Scanner(System.in);
        System.out.println("Pick your direction of movement. Press n, e, s, or w to move and x to dig a hole!");
        String input = directions.nextLine();
        return input.split("");
    }

    public int[] charVector(ArrayList<Entity> guys, String[] news) {
        int[] move = { 0, 0 };
        Character hero = (Character)guys.get(0);
        String[] newsMatch = {"n", "e", "s", "w", "x"};
        for (String letter : news){
        switch (letter) {
            case "n":
                move[1] += -1;
                break;
            case "e":
                move[0] += 1;
                break;
            case "s":
                move[1] += 1;
                break;
            case "w":
                move[0] += -1;
                break;
            case "x":
                guys.add(hero.digHole());
                Game currentGame = (Game)guys.get(1);
                if (currentGame.checkTreasure(guys))
                    guys = currentGame.gameWin(guys);
                break;
            default:
                break;
        }}
        return move;
    }
}
