import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int y;
    int x;

    Node (int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            Queue<Node> queue = new LinkedList<>();
            int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            boolean[][] visited = new boolean[N][N];
            int value = 0;

            for (int i = 0; i < N; ++i) {
                String str = sc.next();

                for (int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                }
            }

            queue.offer(new Node(N / 2, N / 2));
            visited[N / 2][N / 2] = true;
            value += map[N / 2][N / 2];

            int n = N / 2 + 1;
            int turn = (n * n) + ((n - 1) * (n - 1));
            int count = 1;

            while (count != turn) {
                Node node = queue.poll();

                for (int i = 0; i < 4; ++i) {
                    int newY = node.y + direct[i][0];
                    int newX = node.x + direct[i][1];

                    if (newY < 0 || newY >= N || newX < 0 || newX >= N) {
                        continue;
                    }

                    if (visited[newY][newX]) {
                        continue;
                    }

                    queue.offer(new Node(newY, newX));
                    value += map[newY][newX];
                    count++;
                    visited[newY][newX] = true;
                }
            }

            System.out.println("#" + test_case + " " + value);
        }
    }
}