import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String p = "()))((()";
            String answer = "";

            answer = correct(p);

            System.out.print(answer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String correct (String w) {

        //1단계
        if (w.length() == 0) {
            return "";
        }

        String u = "";
        String v = "";
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        char c = w.charAt(0);

        //2단계

        int count = 1;
        u += c;

        for (int i = 1; i < w.length(); ++i) {
            if (w.charAt(i) == c) {
                u += w.charAt(i);
                count++;
            } else {
                u += w.charAt(i);
                count--;
            }

            if (count == 0) {
                v = w.substring(i + 1, w.length());
                break;
            }
        }

        //3단계
        for (int i = 0; i < u.length(); ++i) {
            if (u.charAt(i) == '(') {
                stack.push('(');
            } else if (u.charAt(i) == ')' && stack.isEmpty()) {
                flag = true;
                stack.clear();
                break;
            } else {
                stack.pop();
            }
        }

        if (!flag) {        //3-1 단계
            return u + correct(v);
        } else {
            String newStr = "(";
            newStr += correct(v);
            newStr += ")";

            String newU = u.substring(1, u.length() - 1);

            for (int i = 0; i < newU.length(); ++i) {
                if (newU.charAt(i) == '(') {
                    newStr += ")";
                } else {
                    newStr += "(";
                }
            }

            return newStr;
        }
    }

    public static void main(String[] args){
        new Main().solve();
    }
}