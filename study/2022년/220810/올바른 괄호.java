import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String s = "()()";
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (int i = 0; i < s.length(); ++i) {
                if (stack.isEmpty() && s.charAt(i) == ')') {
                    flag = false;
                    break;
                }

                if (s.charAt(i) == '(') {
                    stack.push('(');
                } else {
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                flag = false;
            }

            System.out.print(flag);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}