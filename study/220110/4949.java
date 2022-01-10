import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String str = br.readLine();
                Stack<Character> stack = new Stack<>();
                boolean condition = true;

                if (str.equals(".")) {
                    break;
                }

                for (int i = 0; i < str.length(); ++i) {
                    if (str.charAt(i) == '[') {
                        stack.push(str.charAt(i));
                    } else if (str.charAt(i) == '(') {
                        stack.push(str.charAt(i));
                    } else if (str.charAt(i) == ']') {
                        if (!stack.empty()) {
                            if (stack.peek() == '[') {
                                stack.pop();
                            }else {
                                condition = false;
                            }
                        } else {
                            condition = false;
                        }
                    } else if (str.charAt(i) == ')') {
                        if (!stack.empty()) {
                            if (stack.peek() == '(') {
                                stack.pop();
                            }else {
                                condition = false;
                            }
                        }else {
                            condition = false;
                        }
                    }
                }

                if (stack.empty() && condition) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }

            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}