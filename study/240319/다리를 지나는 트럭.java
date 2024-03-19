import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int bridge_length = 2;
            int weight = 10;
            int[] truck_weights = {7, 4, 5, 6};

            int answer = 0;

            Queue<Integer> queue = new LinkedList<>();

            // 비어있는 다리의 공간을 0으로 채움
            for (int i = 0; i < bridge_length; ++i) {
                queue.offer(0);
            }

            int index = 0;

            //다리에 있는 트럭의 무게
            int currentWeight = 0;

            //트럭이 더이상 남아있지 않을 때 탈출
            while (index < truck_weights.length) {
                currentWeight -= queue.poll();

                answer++;

                if (currentWeight + truck_weights[index] <= weight) {
                    queue.offer(truck_weights[index]);
                    currentWeight += truck_weights[index++];
                } else {
                    queue.offer(0);
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}