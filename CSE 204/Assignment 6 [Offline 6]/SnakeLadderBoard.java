import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadderBoard {

    private int n; //dice
    private int X; //squares
    private int[] ladders_snakes;
    private boolean simulated;
    private int[][] parent_rolls;

    private String getParentStylePath(int i) {
        if (this.parent_rolls[i][0] == -1) {
            return "" + i;
        }
        return getParentStylePath(this.parent_rolls[i][0]) + " -> " + i;
    }

    public SnakeLadderBoard(int n, int X, int[] ladders_snakes) {
        this.n = n;
        this.X = X;
        this.ladders_snakes = ladders_snakes;
        this.simulated = false;
        this.parent_rolls = new int[X + 1][2];
        for (int i = 1; i <= X; i++) {
            this.parent_rolls[i][0] = -1;
            this.parent_rolls[i][1] = 0;
        }
    }

    public int getLeastRollsToX() {
        this.simulated = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            boolean flag = false;
            int temp = queue.poll();
            if (this.ladders_snakes[temp] != -1) {
                flag = true;
                if(this.parent_rolls[this.ladders_snakes[temp]][0] == -1 || this.parent_rolls[this.ladders_snakes[temp]][1] >= this.parent_rolls[temp][1]) {
                    queue.add(this.ladders_snakes[temp]);
                    this.parent_rolls[this.ladders_snakes[temp]][0] = temp;
                    this.parent_rolls[this.ladders_snakes[temp]][1] = this.parent_rolls[temp][1];
                }
            }
            if (!flag) {
                for (int i = temp + 1; i <= temp + this.n && i <= this.X; i++) {
                    if (this.parent_rolls[i][0] == -1) {
                        queue.add(i);
                        this.parent_rolls[i][0] = temp;
                        this.parent_rolls[i][1] = this.parent_rolls[temp][1] + 1;
                    }

                }
            }
        }
        if(this.parent_rolls[this.X][0] != -1) {
            return this.parent_rolls[this.X][1];
        }
        return -1;
    }

    public String getLeastPath() {
        int temp = -1;
        if (!this.simulated) {
            temp = this.getLeastRollsToX();
        }
        if (this.parent_rolls[this.X][0] == -1) {
            return "No solution\n";
        } else {
            return this.getParentStylePath(this.X) + "\n";
        }
    }

    public String getUnreachableSquares() {
        String s = new String();
        if (!this.simulated) {
            int temp = this.getLeastRollsToX();
        }
        boolean space = false;
        boolean flag = false;
        for (int i = 2; i <= this.X; i++) {
            if (this.parent_rolls[i][0] == -1) {
                flag = true;
                if (!space) {
                    space = true;
                    s += i + "";
                } else {
                    s += " " + i;
                }
            }
        }
        if (!flag) {
            s = "All reachable";
        }
        s += "\n";
        return s;
    }

//    public void deb() {
//        for(int i=1;i<=X;i++) {
//            System.out.print(i + "\t");
//        }
//        System.out.println("");
//        for(int i=1;i<=X;i++) {
//            System.out.print(this.parent_rolls[i][0] + "\t");
//        }
//        System.out.println("");
//        for(int i=1;i<=X;i++) {
//            System.out.print(this.parent_rolls[i][1] + "\t");
//        }
//    }
//	if (this.ladders_snakes[temp] != -1) {
//                flag = true;
//                if(this.parent_rolls[this.ladders_snakes[temp]][0] == -1 || this.parent_rolls[this.ladders_snakes[temp]][1] >= this.parent_rolls[temp][1]) {
//                    queue.add(this.ladders_snakes[temp]);
//                    this.parent_rolls[this.ladders_snakes[temp]][0] = temp;
//                    this.parent_rolls[this.ladders_snakes[temp]][1] = this.parent_rolls[temp][1];
//                }
//            }
}