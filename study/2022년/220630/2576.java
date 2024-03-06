import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int min = 101;
            int sum = 0;

            for (int i = 0; i < 7; ++i) {
                int n = Integer.parseInt(br.readLine());

                if (n % 2 == 1) {

                    if (min > n) {
                        min = n;
                    }
                    sum += n;
                }
            }

            if (sum == 0) {
                System.out.println(-1);
            } else {
                System.out.println(sum);
                System.out.println(min);
            }


        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}