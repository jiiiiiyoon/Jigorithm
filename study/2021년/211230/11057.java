import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
           int N = Integer.parseInt(br.readLine());
           long [][]dp = new long[1001][10];

           for (int i = 0; i < 10; ++i) {
               dp[1][i] = 1;
           }

           for (int i = 2; i < 1001; ++i) {
               long num = 0;
               for (int j = 9; j >= 0; --j) {
                   if (j == 9) {
                       dp[i][j] = 1;
                       num += dp[i-1][j];
                   } else {
                       num += dp[i-1][j];
                       dp[i][j] = num % 10007;
                   }
               }
           }

           long sum = 0;

           for (int i = 0; i < 10; ++i) {
               sum += dp[N][i];
           }

           System.out.println(sum%10007);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}