import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private void solve() {
        class Node{
            int number;
            int turn;

            Node(int number, int turn) {
                this.number = number;
                this.turn = turn;
            }
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);             //LED로 표현된 수
            int T = Integer.parseInt(s[1]);             //버튼을 누를 수 있는 최대 횟수
            int G = Integer.parseInt(s[2]);             //탈출을 위해 똑같이 만들어야 하는 수
            Queue<Node> queue = new LinkedList<>();
            boolean flag = false;
            Node number = new Node(N, 0);
            boolean[] visit = new boolean[100000];

            queue.offer(number);
            visit[number.number] = true;

            while (!queue.isEmpty() && queue.peek().turn + 1 <= T) {
                Node node = queue.poll();

                for (int i = 0; i < 2; ++i) {
                    if(i == 0) {                // 버튼 A
                        int newN = node.number;
                        newN = newN + 1;

                        if (newN > 99999) {
                            continue;
                        }
                        if (visit[newN]) {
                            continue;
                        }
                        if (newN == G) {            //T번 안에 탈출 가능하면
                            System.out.println(node.turn + 1);
                            flag = true;
                            break; 
                        }
                        
                        queue.offer(new Node(newN, node.turn + 1));
                        visit[newN] = true;

                    } else {                    // 버튼 B
                        int newN = node.number;
                        newN = newN * 2;

                        if (newN > 99999) {
                            continue;
                        } else if (newN == 0) {
                            continue;
                        }

                        if (newN < 10) {
                            newN = newN - 1;
                        } else if (newN < 100) {
                            newN = newN - 10;
                        } else if (newN < 1000) {
                            newN = newN - 100;
                        } else if (newN < 10000) {
                            newN = newN - 1000;
                        } else {
                            newN = newN - 10000;
                        }
                        
                        if (visit[newN]) {
                            continue;
                        }
                        if (newN == G) {            //T번 안에 탈출 가능하면
                            System.out.println(node.turn + 1);
                            flag = true;
                            break; 
                        }
                        queue.offer(new Node(newN, node.turn + 1));
                        visit[newN] = true;
                    }

                    if (flag) {
                        queue.clear();
                        break;
                    }
                }             
            }
            if (!flag) {
                System.out.println("ANG");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Main().solve();
    }
}