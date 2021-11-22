import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        run();

    }

    public static void run() {

        // Initialize Variables
        boolean flag;
        String replay = null;

        String move = null;

        Scanner keyboard = new Scanner(System.in);

        // Loop Game
        do {

            Board board = new Board();
            board.randomize(board);

            do {

                // Draw Board
                System.out.println("   A  B  C  D  E");
                for (int i = 0 ; i < 4 ; i++) {

                    System.out.print(i + 1);
                    System.out.print("  ");

                    for (char tile : board.getRow(i)) {

                        System.out.print(tile);
                        System.out.print("  ");

                    }

                    System.out.println();

                }


                // Prompt Move
                System.out.println();
                flag = true;
                do {

                    try {

                        System.out.print("Move: ");
                        move = keyboard.nextLine();
                        if (!((move.charAt(0) >= 65 && move.charAt(0) <= 69) && (move.charAt(1) - '0' >= 1 && move.charAt(1) - '0' <= 4) && move.length() == 2)) {

                            System.out.println("Invalid Input.");

                        } else {

                            flag = false;

                        }

                    } catch (Exception e) {

                        System.out.println("Invalid Input.");

                    }

                } while (flag);
                System.out.println();


                //Produce Move
                board.makeMove(move.charAt(0) - 65, move.charAt(1) - '1');

            } while (!board.isWon());

            // Draw Board
            System.out.println("   A  B  C  D  E");
            for (int i = 0 ; i < 4 ; i++) {

                System.out.print(i + 1);
                System.out.print("  ");

                for (char tile : board.getRow(i)) {

                    System.out.print(tile);
                    System.out.print("  ");

                }

                System.out.println();

            }

            // Display Win Text
            System.out.println();
            System.out.println("You win!");

            // Prompt Replay
            flag = true;
            do {

                try {

                    System.out.print("Play Again?: ");
                    replay = keyboard.nextLine();
                    if (!(replay.toLowerCase().charAt(0) == 'y' || replay.toLowerCase().charAt(0) == 'n')) {

                        System.out.println("Invalid Input.");

                    } else {

                        flag = false;

                    }

                } catch (Exception e) {

                    System.out.println("Invalid Input.");

                }

            } while (flag);

        } while (replay.toLowerCase().charAt(0) == 'y');

    }

}
