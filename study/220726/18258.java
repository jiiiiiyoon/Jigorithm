import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int last = 0;
            StringBuilder printStr = new StringBuilder();

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < N; ++i) {
                String[] str = br.readLine().split(" ");

                if (str[0].equals("push")) {
                    queue.offer(Integer.parseInt(str[1]));
                    last = Integer.parseInt(str[1]);
                } else if (str[0].equals("pop")) {
                    if (queue.isEmpty()) {
                        printStr.append(-1 + "\n");
                    } else {
                        printStr.append(queue.poll() + "\n");
                    }
                } else if (str[0].equals("size")) {
                    printStr.append(queue.size() + "\n");
                } else if (str[0].equals("empty")) {
                    if (queue.isEmpty()) {
                        printStr.append(1 + "\n");
                    } else {
                        printStr.append(0 + "\n");
                    }
                } else if (str[0].equals("front")) {
                    if (queue.isEmpty()) {
                        printStr.append(-1 + "\n");
                    } else {
                        printStr.append(queue.peek() + "\n");
                    }
                } else if (str[0].equals("back")) {
                    if (queue.isEmpty()) {
                        printStr.append(-1 + "\n");
                    } else {
                        printStr.append(last + "\n");
                    }
                }
            }

            System.out.print(printStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}