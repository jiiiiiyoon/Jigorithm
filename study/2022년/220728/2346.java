import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int count = 0;
            Deque<int []> deque = new ArrayDeque<>();

            for (int i = 0; i < N; ++i) {
                deque.add(new int[] {i + 1, Integer.parseInt(str[i])});
            }

            int [] value = deque.pollFirst();
            count = value[1];
            System.out.print(value[0] + " ");

            while(!deque.isEmpty()) {
                if (count < 0) {
                    for (int j = 1; j < -count; ++j) {
                        deque.addFirst(deque.pollLast());
                    }

                    value = deque.pollLast();
                    count = value[1];
                    System.out.print(value[0] + " ");
                } else {
                    for (int j = 1; j < count; ++j) {
                        deque.add(deque.pollFirst());
                    }

                    value = deque.pollFirst();
                    count = value[1];
                    System.out.print(value[0] + " ");
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