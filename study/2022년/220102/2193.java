import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            long []dp = new long[91];

            dp[1] = 1;
            dp[2] = 1;

            for (int i = 3; i < 91; ++i) {
                dp[i] = dp[i-1] + dp[i - 2];
            }

            System.out.println(dp[N]);


        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}