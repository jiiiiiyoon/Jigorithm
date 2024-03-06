import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.Integer.*;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = parseInt(br.readLine());

            String[][] alpha = new String[2][N];
            boolean[] flag = new boolean[26];

            String str = br.readLine();
            int count = 0;

            for (int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                if (!(c == '+' || c == '-' || c == '*' || c == '/')) {
                    if (!flag[c - 65]) {
                        alpha[0][count] = String.valueOf(c);
                        alpha[1][count++] = br.readLine();
                        flag[c - 65] = true;

                        if (count == N) {
                            break;
                        }
                    }
                }
            }

            Stack<Double> stack = new Stack<>();

            for (int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);

                if (c == '+' || c == '-') {
                    if (c == '+') {
                        Double num = stack.pop() + stack.pop();
                        stack.push(num);
                    } else {
                        Double a = stack.pop();
                        Double b = stack.pop();
                        stack.push(b - a);
                    }
                } else if (c == '*' || c == '/'){
                    if (c == '*') {
                        Double num = stack.pop() * stack.pop();
                        stack.push(num);
                    } else {
                        Double a = stack.pop();
                        Double b = stack.pop();
                        stack.push(b / a);
                    }
                } else {
                    for (int j = 0; j < N; ++j) {
                        if (alpha[0][j].equals(String.valueOf(c))) {
                            stack.push((double) parseInt(String.valueOf(alpha[1][j])));
                        }
                    }
                }
            }

            System.out.println(String.format("%.2f", stack.pop()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}