import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            long num1 = 0;
            long num2 = 0;

            String[] s = br.readLine().split(" ");

            for (int i = 0; i < n; ++i) {
                long num = Integer.parseInt(s[i]);
                num1 += num;
                num2 += num * num;
            }

            System.out.println((num1 * num1 - num2) / 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}