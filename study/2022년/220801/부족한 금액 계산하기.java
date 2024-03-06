import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int price = 3;
            int money = 20;
            int count = 4;

            long answer = -1;

            int sum = 0;

            for (int i = 1; i <= count; ++i) {
                sum += price * i;
            }

            if (sum > money) {
                answer = sum - money;
            } else {
                answer = 0;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}