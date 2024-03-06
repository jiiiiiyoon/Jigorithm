import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] person = new int[9];
            int sum = 0;
            boolean flag = false;

            for (int i = 0; i < 9; ++i) {
                person[i] = Integer.parseInt(br.readLine());
                sum += person[i];
            }
            int i = 0;
            int j = i + 1;

            for (; i < 8; ++i) {
                for (j = i + 1; j < 9; ++j) {
                    if (sum - person[i] - person[j] == 100) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    break;
                }
            }

            int[] real = new int[7];
            int realIndex = 0;

            for (int k = 0; k < 9; ++k) {
                if (k != i && k != j) {
                    real[realIndex++] = person[k];
                }
            }

            Arrays.sort(real);

            for (i = 0; i < 7; ++i) {
                System.out.println(real[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}