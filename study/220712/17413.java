import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String str = br.readLine();
            boolean flag = false;

            Queue<Character> queue = new LinkedList<>();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) == '<') {
                    if (!stack.isEmpty()) {
                        for (int j = 0; !stack.isEmpty(); ++j) {
                            System.out.print(stack.pop());
                        }
                    }
                    flag = true;
                    queue.offer(str.charAt(i));
                    continue;
                } else if (str.charAt(i) == '>') {
                    flag = false;
                    queue.offer(str.charAt(i));

                    for (int j = 0; !queue.isEmpty(); ++j) {
                        System.out.print(queue.poll());
                    }
                    continue;
                }

                if (flag) {
                    queue.offer(str.charAt(i));
                } else {
                    if (str.charAt(i) == ' ') {
                        for (int j = 0; !stack.isEmpty(); ++j) {
                            System.out.print(stack.pop());
                        }
                        System.out.print(" ");
                    } else {
                        stack.push(str.charAt(i));
                    }
                }
            }

            while(!stack.isEmpty()) {
                System.out.print(stack.pop());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}