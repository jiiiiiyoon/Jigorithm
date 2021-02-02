import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private void solve() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);                 //정점의 개수
            int M = Integer.parseInt(s[1]);                 //간선의 개수
            int map[][] = new int[N + 1][N + 1];
            Queue<Integer> queue = new LinkedList<>();
            boolean[]visit = new boolean[N + 1];
            boolean flag = false;
            int compNum = 0;                              //연결 요소의 개수

            for (int i = 0; i < M; ++i) {
                s = br.readLine().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);

                map[u][v] = 1;
                map[v][u] = 1;
            }

            for(int i = 1; i < N + 1; ++i) {
                
                if (!visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                    compNum++;

                    while (!queue.isEmpty()) {
                        int node = queue.poll();

                        for (int j = 1; j < N + 1; ++j) {
                            if (map[node][j] != 1) {
                                continue;
                            } else if (visit[j]) {
                                continue;
                            } else {
                                visit[j] = true;
                                queue.offer(j);
                            }
                        }
                    }
                }               
            }
            
            System.out.println(compNum);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Main().solve();
    }
    
}
