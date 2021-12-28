import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[1001];

            dp[1] = 1;
            dp[2] = 3;

            for (int i = 3; i < 1001; ++i) {
                dp[i] = (dp[i-1]+(2 * dp[i-2])) % 10007;
            }

            System.out.println(dp[n]);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}