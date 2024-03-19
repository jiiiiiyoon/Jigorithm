import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] prices = {1, 2, 3, 2, 3};
            int[] answer = new int[prices.length];

            Queue<Integer> queue = new LinkedList<>();

            for (int i : prices) {
                queue.offer(i);
            }

            int index = 0;

            while (!queue.isEmpty()) {
                int price = queue.poll();

                for (int i = (prices.length - queue.size()); i < prices.length; ++i) {
                    answer[index]++;

                    if (price > prices[i]) {
                        break;
                    }
                }

                index++;
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}