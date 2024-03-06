import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            ArrayList deque = new ArrayList<Integer>();

            for (int i = 0; i < N; ++i) {
                String[] s = br.readLine().split(" ");

                switch (s[0]) {
                    case "push_front":
                        deque.add(0, Integer.parseInt(s[1]));
                        break;
                    case "push_back":
                        deque.add(Integer.parseInt(s[1]));
                        break;
                    case "pop_front":
                        if (deque.isEmpty()) {
                            System.out.println(-1);
                        } else {
                            System.out.println(deque.get(0));
                            deque.remove(0);
                        }
                        break;
                    case "pop_back":
                        if (deque.isEmpty()) {
                            System.out.println(-1);
                        } else {
                            System.out.println(deque.get(deque.size() - 1));
                            deque.remove(deque.size() - 1);
                        }
                        break;
                    case "size":
                        System.out.println(deque.size());
                        break;
                    case "empty":
                        if (deque.isEmpty()) {
                            System.out.println(1);
                        } else {
                            System.out.println(0);
                        }
                        break;
                    case "front":
                        if (deque.isEmpty()) {
                            System.out.println(-1);
                        } else {
                            System.out.println(deque.get(0));
                        }
                        break;
                    case "back":
                        if (deque.isEmpty()) {
                            System.out.println(-1);
                        } else {
                            System.out.println(deque.get(deque.size() - 1));
                            break;
                        }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}