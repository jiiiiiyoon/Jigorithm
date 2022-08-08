import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private void solve() {
        class Node {
            int progresses;
            int speeds;

            Node (int progresses, int speeds) {
                this.progresses = progresses;
                this.speeds = speeds;
            }
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] progresses = {95, 90, 99, 99, 80, 99};
            int[] speeds = {1, 1, 1, 1, 1, 1};
            ArrayList<Integer> result = new ArrayList<>();

            Queue<Node> queue = new LinkedList<>();

            for (int i = 0; i < progresses.length; ++i) {
                queue.offer(new Node(progresses[i], speeds[i]));
            }

            while (!queue.isEmpty()) {
                int count = 0;
                boolean flag = true;
                for (int i = 0; i < queue.size(); ++i) {
                    Node node = queue.poll();

                    queue.offer(new Node(node.progresses + node.speeds, node.speeds));
                }

                int size = queue.size();

                for (int i = 0; i < size; ++i) {
                    Node node = queue.peek();

                    if (node.progresses >= 100 && flag) {
                        queue.poll();
                        count++;
                    } else {
                        flag = false;
                    }
                }

                if (count != 0) {
                    result.add(count);

                }
            }
            int[] answer = new int[result.size()];

            for (int i = 0; i < result.size(); ++i) {
                answer[i] = result.get(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}