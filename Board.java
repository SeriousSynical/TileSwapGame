import java.util.ArrayList;
import java.util.Random;

public class Board {

    // Initialize Values
    private ArrayList<Character> row1;
    private ArrayList<Character> row2;
    private ArrayList<Character> row3;
    private ArrayList<Character> row4;
    ArrayList<ArrayList<Character>> board;

    Random random = new Random();


    // Construct Board
    public Board() {

        row1 = new ArrayList<>();
        row1.add('█');
        row1.add('█');
        row1.add('█');
        row1.add('█');
        row1.add('█');

        row2 = new ArrayList<>();
        row2.add('█');
        row2.add('█');
        row2.add('█');
        row2.add('█');
        row2.add('█');

        row3 = new ArrayList<>();
        row3.add('█');
        row3.add('█');
        row3.add('█');
        row3.add('█');
        row3.add('█');

        row4 = new ArrayList<>();
        row4.add('█');
        row4.add('█');
        row4.add('█');
        row4.add('█');
        row4.add('█');

        board = new ArrayList<>();
        board.add(row1);
        board.add(row2);
        board.add(row3);
        board.add(row4);

    }


    // Get Values
    public ArrayList<Character> getRow(int chosenRow) {

        if (chosenRow == 0) {

            return row1;

        } else if (chosenRow == 1) {

            return row2;

        } else if (chosenRow == 2) {

            return row3;

        } else {

            return row4;

        }

    }

    public ArrayList<ArrayList<Character>> getBoard() {

        return board;

    }


    // Randomize Board
    public void randomize(Board board) {

        int min = 1;
        int max = 100;

        int scatters = (random.nextInt((max - min) + 1) + min);

        for (int i = 0; i < scatters; i++) {

            board.makeMove(random.nextInt(5), random.nextInt(4));

        }

    }

    public void randomize(Board board, int min, int max) {

        int scatters = (random.nextInt((max - min) + 1) + min);

        for (int i = 0; i < scatters; i++) {

            board.makeMove(random.nextInt(5), random.nextInt(4));

        }

    }


    // Make Move
    public void makeMove(int chosenColumn, int chosenRow) {

        if (chosenRow != 0) {

            if (board.get(chosenRow - 1).get(chosenColumn).equals('█')) {

                board.get(chosenRow - 1).set(chosenColumn, '░');

            } else {

                board.get(chosenRow - 1).set(chosenColumn, '█');

            }

        }

        if (chosenColumn != 0) {

            if (board.get(chosenRow).get(chosenColumn - 1).equals('█')) {

                board.get(chosenRow).set(chosenColumn - 1, '░');

            } else {

                board.get(chosenRow).set(chosenColumn - 1, '█');

            }

        }

        if (board.get(chosenRow).get(chosenColumn).equals('█')) {

            board.get(chosenRow).set(chosenColumn, '░');

        } else {

            board.get(chosenRow).set(chosenColumn, '█');

        }


        if (chosenColumn != 4) {

            if (board.get(chosenRow).get(chosenColumn + 1).equals('█')) {

                board.get(chosenRow).set(chosenColumn + 1, '░');

            } else {

                board.get(chosenRow).set(chosenColumn + 1, '█');

            }

        }

        if (chosenRow != 3) {

            if (board.get(chosenRow + 1).get(chosenColumn).equals('█')) {

                board.get(chosenRow + 1).set(chosenColumn, '░');

            } else {

                board.get(chosenRow + 1).set(chosenColumn, '█');

            }

        }

    }


    // Check For Win
    public boolean isWon() {

        boolean win = true;

        for (ArrayList<Character> row : board) {

            for (char tile : row) {

                if (tile == '░') {

                    win = false;

                }

            }

        }

        return win;

    }

}
