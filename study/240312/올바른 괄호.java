import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = "(()(";

            Stack<Character> stack = new Stack<>();
            boolean answer = true;

            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    stack.push(s.charAt(i));
                } else {
                    if (stack.isEmpty()) {
                        answer = false;
                        break;
                    }

                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                answer = false;
            }

            System.out.print(answer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}