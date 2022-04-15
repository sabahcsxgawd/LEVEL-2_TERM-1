import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int testcases = 0;
        SnakeLadderBoard[] boards = null;
        try {
            File myObj = new File("input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                testcases = Integer.parseInt(data);
                boards = new SnakeLadderBoard[testcases];
                for (int i = 0; i < testcases; i++) {
                    int n, X, l, s;
                    int[] ladders_snakes;
                    data = myReader.nextLine();
                    String[] vals = data.split(" ");
                    n = Integer.parseInt(vals[0]);
                    X = Integer.parseInt(vals[1]);
                    ladders_snakes = new int[X + 1];
                    for (int g = 0; g <= X; g++) {
                        ladders_snakes[g] = -1;
                    }
                    l = Integer.parseInt(myReader.nextLine());
                    for (int j = 0; j < l; j++) {
                        data = myReader.nextLine();
                        vals = data.split(" ");
                        int g,gg;
                        g = Integer.parseInt(vals[0]);
                        gg = Integer.parseInt(vals[1]);
                        ladders_snakes[g] = gg;
                    }
                    s = Integer.parseInt(myReader.nextLine());
                    for (int j = 0; j < s; j++) {
                        data = myReader.nextLine();
                        vals = data.split(" ");
                        int g,gg;
                        g = Integer.parseInt(vals[0]);
                        gg = Integer.parseInt(vals[1]);
                        ladders_snakes[g] = gg;
                    }
                    boards[i] = new SnakeLadderBoard(n, X, ladders_snakes);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("output.txt");
            for (int i = 0; i < testcases; i++) {
                myWriter.write(String.valueOf(boards[i].getLeastRollsToX()) + "\n");
                myWriter.write(boards[i].getLeastPath());
                myWriter.write(boards[i].getUnreachableSquares());
                if (i != testcases - 1) {
                    myWriter.write("\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
