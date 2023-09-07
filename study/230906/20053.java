import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());

            for (int t = 0; t < T; ++t) {
                int N = Integer.parseInt(br.readLine());
                int min = 1000001;
                int max = -1000001;

                String[] numbers = br.readLine().split(" ");

                for (int n = 0; n < N; ++n) {
                    if (min > Integer.parseInt(numbers[n])) {
                        min = Integer.parseInt(numbers[n]);
                    }
                    if (max < Integer.parseInt(numbers[n])) {
                        max = Integer.parseInt(numbers[n]);
                    }
                }

                System.out.println(min + " " + max);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}