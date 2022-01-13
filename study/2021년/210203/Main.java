import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private void solve() {
        class Node{
            int y;
            int x;

            Node(int y, int x) {
                this.y = y;
                this.x = x;
            }
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);             //통로의 세로 길이
            int M = Integer.parseInt(s[1]);             //통로의 가로 길이
            int K = Integer.parseInt(s[2]);             // 음식물 쓰레기의 개수
            int[][] map = new int[N][M];
            int max = 0;
            int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            boolean[][] visit = new boolean[N][M];      
            Queue<Node> queue = new LinkedList<>();

            for (int i = 0; i < K; ++i) {
                s = br.readLine().split(" ");
                int r = Integer.parseInt(s[0]) - 1;
                int c = Integer.parseInt(s[1]) - 1;

                map[r][c] = 1;
            }

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        queue.offer(new Node(i, j));
                        visit[i][j] = true;
                        int num = 1;

                        while (!queue.isEmpty()) {
                            Node node = queue.poll();

                            for (int k = 0; k < 4; ++k) {
                                int newY = node.y + direct[k][0];
                                int newX = node.x + direct[k][1];

                                if (newY < 0 || newY >= N || newX < 0 || newX >= M){
                                    continue;
                                }
                                if (map[newY][newX] != 1) {
                                    continue;
                                }
                                if (visit[newY][newX]) {
                                    continue;
                                }

                                queue.offer(new Node(newY, newX));
                                visit[newY][newX] = true;
                                num++;
                            }
                        }

                        if (num > max) {
                            max = num;
                        }

                    }
                }
            }

            System.out.println(max);

            
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Main().solve();
    }
    
}