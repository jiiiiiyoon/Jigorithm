import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());

            for (int t = 0; t < T; ++t) {
                String[] str = br.readLine().split(" ");
                int[] num = new int[str.length-1];

                for (int i = 1; i < str.length; ++i) {
                    num[i - 1] = Integer.parseInt(str[i]);
                }

                long result = 0;

                for (int i = 0; i < num.length; ++i) {
                    int index = i + 1;

                    while (index < num.length) {
                        result += gcd(num[i], num[index]);
                        index++;
                    }
                }

                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}