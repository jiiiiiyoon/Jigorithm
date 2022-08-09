import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private void solve() {
        class Node {
            int location;
            int priorities;

            Node (int location, int priorities) {
                this.location = location;
                this.priorities = priorities;
            }
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] priorities = {1, 1, 9, 1, 1, 1};
            int location = 0;
            int answer = 0;

            Queue<Node> queue = new LinkedList<>();

            for (int i = 0; i < priorities.length; ++i) {
                queue.offer(new Node(i, priorities[i]));
            }

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int size = queue.size();
                boolean flag = false;

                for (int i = 0; i < size; ++i) {
                   Node n = queue.poll();

                   if (node.priorities < n.priorities) {
                       flag = true;
                   }

                   queue.offer(n);
                }

                if (flag) {
                    queue.offer(node);
                } else if (node.location == location){
                    answer++;
                    break;
                } else {
                    answer++;
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

/*1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.*/