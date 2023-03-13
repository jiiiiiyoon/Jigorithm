import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private void solve() {
        class Node {
            int y;
            int x;
            int time;
            Node (int y, int x, int time) {
                this.y = y;
                this.x = x;
                this.time = time;
            }
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // R행 C열
            // 비어있는 곳 .
            // 물이 차있는 지역 *
            // 돌 X
            // 비버의 굴 D, 고슴도치의 위치 S

            String[] s = br.readLine().split(" ");

            int R = Integer.parseInt(s[0]);
            int C = Integer.parseInt(s[1]);

            char[][] map = new char[R][C];
            int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            boolean[][] visited = new boolean[R][C];
            Queue<Node> water = new LinkedList<>();
            Queue<Node> queue = new LinkedList<>();
            boolean flag = false;

            for (int i = 0; i < R; ++i) {
                String str = br.readLine();

                for (int j = 0; j < C; ++j) {
                    map[i][j] = str.charAt(j);

                    if (map[i][j] == '*') {
                        water.offer(new Node(i, j, -1));
                    } else if (map[i][j] == 'S') {
                        queue.offer(new Node(i, j, 0));
                        map[i][j] = '.';
                        visited[i][j] = true;
                    }
                }
            }

            while (!flag) {
                int waterSize = water.size();
                int queueSize = queue.size();

                for (int t = 0; t < waterSize; ++t) {
                    Node waterNode = water.poll();

                    for (int i = 0; i < 4; ++i) {
                        int newY = waterNode.y + direct[i][0];
                        int newX = waterNode.x + direct[i][1];

                        if (newY < 0 || newY >= R || newX < 0 || newX >= C) {
                            continue;
                        }

                        if (map[newY][newX] == '.') {
                            water.offer(new Node(newY, newX, -1));
                            map[newY][newX] = '*';
                        }
                    }
                }

                for (int t = 0; t < queueSize; ++t) {
                    Node node = queue.poll();

                    for (int i = 0; i < 4; ++i) {
                        int newY = node.y + direct[i][0];
                        int newX = node.x + direct[i][1];

                        if (newY < 0 || newY >= R || newX < 0 || newX >= C) {
                            continue;
                        }

                        if (visited[newY][newX]) {
                            continue;
                        }

                        if (map[newY][newX] == '.') {
                            queue.offer(new Node(newY, newX, node.time + 1));
                            visited[newY][newX] = true;
                        } else if (map[newY][newX] == 'D') {
                            System.out.println(node.time + 1);
                            flag = true;
                            break;
                        }
                    }

                    if (queue.isEmpty() && !flag) {
                        flag = true;
                        System.out.println("KAKTUS");
                    } else if (flag) {
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}