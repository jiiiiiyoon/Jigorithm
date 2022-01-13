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
            boolean water;
            int turn;

            Node(int y, int x, boolean water, int turn) {
                this.y = y;
                this.x = x;
                this.water = water;
                this.turn = turn;
            }
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");

            int R = Integer.parseInt(s[0]);
            int C = Integer.parseInt(s[1]);
            char[][] map = new char[R][C];
            Node S = null;                                             //고슴도치
            Node D = null;                                             //비버의 굴
            Queue<Node> queue = new LinkedList<>();
            int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            boolean[][] visit = new boolean[R][C];
            boolean[][] watervisit = new boolean[R][C];
            boolean flag = false;

            for (int i = 0; i < R; ++i) {
                String s1 = br.readLine();

                for (int j = 0; j < C; ++j) {
                    map[i][j] = s1.charAt(j);
                    
                    if (map[i][j] == 'S') {                     //고슴도치 위치 저장
                        S = new Node(i, j, false, 0);                     
                    }else if (map[i][j] == 'D') {               //비버의 굴 위치 저장
                        D = new Node(i, j, false, 0);
                    } else if (map[i][j] == '*') {
                        queue.offer(new Node(i, j, true, 0));            //물 위치 큐에 먼저 삽입
                        watervisit[i][j] = true;
                    }
                }
            }

            
            queue.offer(S);
            visit[S.y][S.x] = true;

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                if (node.water) {           
                    for (int i = 0; i < 4; ++i) {
                        int newY = node.y + direct[i][0];
                        int newX = node.x + direct[i][1];

                        if (newY < 0 || newY >= R || newX < 0 || newX >= C) {
                            continue;
                        }
                        if (map[newY][newX] == 'X') {
                            continue;
                        }
                        if (map[newY][newX] == 'D') {
                            continue;
                        }
                        if (watervisit[newY][newX]) {
                            continue;
                        }

                        queue.offer(new Node(newY, newX, true, 0));
                        map[newY][newX] = '*';
                        watervisit[newY][newX] = true;
                    }
                } else{
                    for (int i = 0; i < 4; ++i) {
                        int newY = node.y + direct[i][0];
                        int newX = node.x + direct[i][1];

                        if (newY < 0 || newY >= R || newX < 0 || newX >= C) {
                            continue;
                        }
                        if (map[newY][newX] == '*' || map[newY][newX] == 'X') {
                            continue;
                        }
                        if (visit[newY][newX]) {
                            continue;
                        }
                        if (newY == D.y && newX == D.x) {
                            flag = true;
                            System.out.println(node.turn + 1);
                            queue.clear();
                            break;
                        }

                        queue.offer(new Node(newY, newX ,false, node.turn + 1));
                        visit[newY][newX] = true;
                        map[newY][newX] = 'S';
                    }
                }
            }

            if(!flag) {        
              System.out.println("KAKTUS");
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Main().solve();
    }
    
}