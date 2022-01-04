import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str = br.readLine().split(" ");

            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int R = Integer.parseInt(str[2]);
            int cNum = 0;
            int[][] map = new int[N][M];
            int[][] newMap = new int[N][M];

            if (N < M) {
                cNum = N/2;
            } else {
                cNum = M/2;
            }

            for (int i = 0; i < N; ++i) {
                str = br.readLine().split(" ");

                for (int j = 0; j < M; ++j) {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }

            for (int r = 0; r < R; ++r) {
                for (int i = 0; i < cNum; ++i) {
                    for (int j = M-1-i; j > i; --j) {
                        newMap[i][j-1] = map[i][j];
                    }
                    for (int j = i; j < M-1-i; ++j) {
                        newMap[N-i-1][j+1] = map[N-i-1][j];
                    }
                    for (int j = i; j < N-i-1; ++j) {
                        newMap[j+1][i] = map[j][i];
                    }
                    for (int j = i; j < N-i-1; ++j) {
                        newMap[j][M-i-1] = map[j+1][M-i-1];
                    }
                }
                for (int i = 0; i < N; ++i) {
                    for (int j = 0; j < M; ++j) {
                        map[i][j] = newMap[i][j];
                    }
                }
            }

            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    System.out.print(newMap[i][j] + " ");
                }
                System.out.println();
            }



        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}