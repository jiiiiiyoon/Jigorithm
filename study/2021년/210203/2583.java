import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
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
            int M = Integer.parseInt(s[0]);             //세로 크기
            int N = Integer.parseInt(s[1]);             //가로 크기
            int K = Integer.parseInt(s[2]);             //직사각형 개수
            int[][] map = new int[M][N];
            int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int[] quad;
            int quadNum = 0;
            boolean[][] visit = new boolean[M][N];
            Queue<Node> queue1 = new LinkedList<>();
            Queue<Integer> queue2 = new LinkedList<>();


            for (int i = 0; i < K; ++i) {
                s = br.readLine().split(" ");
                int leftX = Integer.parseInt(s[0]);
                int leftY = M - Integer.parseInt(s[1]);
                int rightX = Integer.parseInt(s[2]);
                int rightY = M - Integer.parseInt(s[3]);

                for (int k = rightY; k < leftY; ++k) {
                    for (int j = leftX; j < rightX; ++j) {
                        map[k][j] = 1;
                    }
                }
            }

            for (int i = 0; i < M; ++i) {
                for (int j = 0; j < N; ++j) {
                     if (map[i][j] != 1 && !visit[i][j]) {
                        int num = 1;
                        queue1.offer(new Node(i, j));
                        visit[i][j] = true;

                        while (!queue1.isEmpty()) {
                            Node node = queue1.poll();

                            for (int k = 0; k < 4; ++k) {
                                int newY = node.y + direct[k][0];
                                int newX = node.x + direct[k][1];

                                if (newY < 0 || newY >= M || newX < 0 || newX >= N) {
                                    continue;
                                }
                                if (map[newY][newX] == 1) {
                                    continue;
                                }
                                if (visit[newY][newX]) {
                                    continue;
                                }
                                
                                queue1.offer(new Node(newY, newX));
                                visit[newY][newX] = true;
                                num++;
                            }
                        }
                        queue2.offer(num);
                     }
                }
            }

            quadNum = queue2.size();
            quad = new int[quadNum];
            
            for (int i = 0; !queue2.isEmpty(); ++i) {
                quad[i] = queue2.poll();
            }

            Arrays.sort(quad);

            
            System.out.println(quadNum);
            
            for (int i = 0; i < quadNum; ++i) {
                System.out.print(quad[i] + " ");
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Main().solve();
    }
    
}