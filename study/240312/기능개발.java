import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    class Node {
        int progress;
        int speed;

        Node(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }

    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] progresses = {95, 90, 99, 99, 80, 99};
            int[] speeds = {1, 1, 1, 1, 1, 1};

            Queue<Node> queue = new LinkedList<>();
            ArrayList<Integer> answerList = new ArrayList<>();

            for (int i = 0; i < progresses.length; ++i) {
                queue.offer(new Node(progresses[i], speeds[i]));
            }

            for (int t = 1; t <= 100; ++t) {
                int release = 0;

                while (!queue.isEmpty()) {
                    Node node = queue.peek();

                    if (node.progress + (node.speed * t) >= 100) {
                        release++;
                        queue.poll();
                    } else {
                        break;
                    }
                }

                if (release != 0) {
                    answerList.add(release);
                }

                if (queue.isEmpty()) {
                    break;
                }
            }

            int[] answer = new int[answerList.size()];

            for (int i = 0; i < answerList.size(); ++i) {
                answer[i] = answerList.get(i);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}