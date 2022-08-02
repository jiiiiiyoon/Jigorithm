import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = 125;
            int answer = 0;
            StringBuilder str = new StringBuilder();

            while (n != 0) {
                str.append(n % 3);

                n /= 3;
            }

            answer = Integer.parseInt(Integer.toString(Integer.parseInt(String.valueOf(str), 3)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}