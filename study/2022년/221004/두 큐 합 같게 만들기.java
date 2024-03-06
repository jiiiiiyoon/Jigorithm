import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] queue1 = {1, 1};
            int[] queue2 = {1, 5};
            int answer = -2;
            long sum = 0;
            int count = 0;
            long sum1 = 0;
            long sum2 = 0;
            boolean flag = false;
            Queue<Integer> que1 = new LinkedList<>();
            Queue<Integer> que2 = new LinkedList<>();

            for (int i = 0; i < queue1.length; ++i) {
                que1.offer(queue1[i]);
                que2.offer(queue2[i]);
                sum += queue1[i] + queue2[i];
                sum1 += queue1[i];
                sum2 += queue2[i];
            }

            sum /= 2;

            for (int i = 0; i < queue1.length * 3; ++i) {
                if (sum1 == sum2) {
                    flag = true;
                    break;
                } else if (sum1 > sum2){
                    sum1 -= que1.peek();
                    sum2 += que1.peek();
                    que2.offer(que1.poll());
                    count++;
                } else {
                    sum2 -= que2.peek();
                    sum1 += que2.peek();
                    que1.offer(que2.poll());
                    count++;
                }
            }

            if (flag) {
                answer = count;
            } else {
                answer = -1;
            }

            System.out.print(answer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}