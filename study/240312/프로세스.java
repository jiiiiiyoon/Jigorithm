import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    class Node {
        int turn;
        int priority;

        Node(int turn, int priority) {
            this.turn = turn;
            this.priority = priority;
        }
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] priorities = {1, 1, 9, 1, 1, 1};
            int location = 0;
            int answer = 0;
            int priorities_index = priorities.length - 1;
            int pop = 0;
            Queue<Node> queue = new LinkedList<>();

            for (int i = 0; i < priorities.length; ++i) {
                queue.offer(new Node(i, priorities[i]));
            }

            Arrays.sort(priorities);

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                if (node.priority != priorities[priorities_index]) {
                    queue.offer(node);
                } else {
                    priorities_index--;
                    pop++;

                    if (node.turn == location) {
                        answer = pop;
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