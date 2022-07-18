import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            long[] dp = new long[n + 1];

            for (int i = 0; i <= n; ++i) {
                if (i == 0) {
                    dp[0] = 1;
                } else if (i == 1) {
                    dp[1] = 1;
                } else {
                    dp[i] = (1 + dp[i - 1] + dp[i - 2]) % 1000000007;
                }
            }

            System.out.println(dp[n]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}