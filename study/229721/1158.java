import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int K = Integer.parseInt(str[1]);

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < N; ++i) {
                queue.offer(i+1);
            }
            System.out.print("<");

            while (!queue.isEmpty()) {
                for (int i = 0; i < K - 1; ++i) {
                    int num = queue.poll();
                    queue.offer(num);
                }

                int num = queue.poll();

                if (!queue.isEmpty()) {
                    System.out.print(num + ", ");
                } else {
                    System.out.print(num + ">");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}