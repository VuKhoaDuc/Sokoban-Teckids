import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        // * Create Map: *
        String[][] game = new String[10][10];


        // * Create Player Position: *
        int playerX = 1;
        int playerY = 1;
        String player = "P  ";

        // * Create random Enemy: *
        // EnemyVertical:

        int enemyVertMove = 1;
        int enemyVertX = random.nextInt(game.length - 2) + 1;
        int enemyVertY = random.nextInt(game.length - 2) + 1;
        String enemyVertical = "EV ";

        // EnemyHorizontal:
        int enemyHoriMove = 1;
        int enemyHoriX = random.nextInt(game.length - 2) + 1;
        int enemyHoriY = random.nextInt(game.length - 2) + 1;
        String enemyHorizontal = "EH ";

        // * Create Gift: *
        int giftX = random.nextInt(game.length - 2) + 1;
        int giftY = random.nextInt(game.length - 2) + 1;
        String giftForHeros = "♚  ";

        // * Wall *:

        String wall = "✘  ";

        while (true) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {

                    game[i][j] = "⎕  ";
                    game[playerX][playerY] = player;
                    game[enemyVertX][enemyVertY] = enemyVertical;
                    game[enemyHoriX][enemyHoriY] = enemyHorizontal;
                    game[giftX][giftY] = giftForHeros;
                    if (i == 0 || i == game.length - 1 || j == 0 || j == game.length - 1) {
                        game[i][j] = wall;
                    }
                    System.out.print(game[i][j]);
                }

                System.out.println();
            }

            System.out.println("Your move: ");
            String moveButton = scanner.next();

            switch (moveButton) {
                case "a":
                    if (playerY == 1) {
                        playerY = 1;
                    } else {
                        playerY -= 1;
                    }
                    System.out.println("Player is Moving Left");
                    break;
                case "s":
                    if (playerX == game.length - 2) {
                        playerX = game.length - 2;
                    } else {
                        playerX += 1;
                    }
                    System.out.println("Player is Moving Down");
                    break;
                case "d":

                    if (playerY == game.length - 2) {
                        playerY = game.length - 2;
                    } else {
                        playerY += 1;
                    }
                    System.out.println("Player is Moving Right");
                    break;
                case "w":
                    if (playerX == 1) {
                        playerX = 1;
                    } else {
                        playerX -= 1;
                    }
                    System.out.println("Player is Moving Up");
                    break;
            }

            if (enemyVertX == game.length - 2) {
                enemyVertMove = -1;
            } else if (enemyVertX == 1) {
                enemyVertMove = 1;
            }
            enemyVertX += enemyVertMove;
            if (enemyHoriY == game.length - 2) {
                enemyHoriMove = -1;
            } else if (enemyHoriY == 1){
                enemyHoriMove = 1;
            }
            enemyHoriY += enemyHoriMove;
            if (playerX == giftX && playerY == giftY) {
                System.out.println("Hero Come To King!");
                break;
            } else if (playerX == enemyHoriX && playerY == enemyHoriY) {
                System.out.println("Hero Is Defeat!");
                break;
            } else if (playerX == enemyVertX && playerY == enemyVertY) {
                System.out.println("Hero Is Defeat!");
                break;
            }

        }
    }
}
