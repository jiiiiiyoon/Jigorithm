import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");

            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);
            int N = Integer.parseInt(s[2]);

            int num = A % B;

            for (int i = 1; i <= N; ++i) {
                num *= 10;

                if (i == N) {
                    System.out.println(num/B);
                } else {
                    num = num % B;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}