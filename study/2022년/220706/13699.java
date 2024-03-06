import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            long[] t = new long[n+1];
            t[0] = 1;

            for (int i = 1; i <= n; ++i) {
                for (int j = 0; j < i; ++j) {
                    long num = t[j] * t[i-j-1];
                    t[i] = t[i] + num;
                }
            }

            System.out.print(t[n]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}