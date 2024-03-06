import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");

            int N = Integer.parseInt(s[0]);
            int K = Integer.parseInt(s[1]);
            int[] temp = new int[N];
            int max = -999999999;

            s = br.readLine().split(" ");

            for (int i = 0; i < N; ++i) {
                temp[i] = Integer.parseInt(s[i]);
            }

            for (int i = 0; i <= N - K; ++i) {
                int sum = 0;

                for (int j = 0; j < K; ++j) {
                    sum += temp[i + j];
                }

                if (sum > max) {
                    max = sum;
                }
            }

            System.out.println(max);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}