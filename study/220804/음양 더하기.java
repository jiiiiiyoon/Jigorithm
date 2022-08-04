import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] absolutes = {1, 2, 3};
            boolean[] signs = {false, false, true};
            int sum = 0;
            int answer = 123456789;

            for (int i = 0; i < absolutes.length; ++i) {
                if (signs[i]) {
                    sum += absolutes[i];
                } else {
                    sum -= absolutes[i];
                }
            }

            answer = sum;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}