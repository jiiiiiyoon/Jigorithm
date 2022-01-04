import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());

            for (int t = 0; t < T; ++t) {
                int n = Integer.parseInt(br.readLine());

                int [][] map = new int[2][n+1];
                int [][] dp = new int[2][n+1];
                for (int i = 0; i < 2; ++i) {
                    String[] str = br.readLine().split(" ");
                    for (int j = 1; j < n+1; ++j) {
                        map[i][j] = Integer.parseInt(str[j-1]);
                    }
                }

                dp[0][1] = map[0][1];
                dp[1][1] = map[1][1];

                for (int i = 2; i < n + 1; ++i) {
                    dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + map[0][i];
                    dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + map[1][i];
                }

                System.out.println(Math.max(dp[0][n], dp[1][n]));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}