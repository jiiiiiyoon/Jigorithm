import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] num = new int[n];

            for (int i = 0; i < n; ++i) {
                num[i] = Integer.parseInt(br.readLine());
            }

            Stack<Integer> stack = new Stack<>();
            StringBuilder str = new StringBuilder();
            int count = 0;

            for (int i = 1; i <= n; ++i) {
                stack.push(i);
                str.append("+\n");


                while (stack.peek() == num[count]) {
                    count++;
                    stack.pop();
                    str.append("-\n");

                    if (stack.isEmpty()) {
                        break;
                    }
                }
            }

            if (count == n) {
                System.out.println(str);
            } else {
                System.out.println("NO");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}