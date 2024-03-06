import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
            int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
            int answer = 0;

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < moves.length; ++i) {
                for (int j = 0; j < board.length; ++j) {
                    int item = board[j][moves[i] - 1];

                    if (item != 0) {

                        board[j][moves[i] - 1] = 0;

                        if (stack.isEmpty()) {
                            stack.push(item);
                        } else if (stack.peek() == item) {
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(item);
                        }
                        break;
                    }
                }
            }

            System.out.print(answer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}