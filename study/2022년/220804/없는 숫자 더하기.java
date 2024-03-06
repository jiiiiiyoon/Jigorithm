import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
            int answer = -1;
            int sum = 0;
            boolean[] numberFlag = new boolean[10];

            for (int i = 0; i < numbers.length; ++i) {
                numberFlag[numbers[i]] = true;
            }

            for (int i = 0; i < 10; ++i) {
                if (!numberFlag[i]) {
                    sum += i;
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