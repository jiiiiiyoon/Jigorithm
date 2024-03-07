import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] arr = {1, 1, 3, 3, 0, 1, 1};


            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < arr.length; ++i) {
                if (!stack.isEmpty()) {
                    if (stack.peek() != arr[i]) {
                        stack.push(arr[i]);
                    }
                } else {
                    stack.push(arr[i]);
                }
            }

            int[] answer = new int[stack.size()];

            int index = stack.size() - 1;

            while(!stack.isEmpty()) {
                answer[index--] = stack.pop();
            }

            for (int i = 0; i < answer.length; ++i) {
                System.out.print(answer[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}