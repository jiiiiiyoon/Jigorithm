import java.util.Arrays;

public class Main {
    public int[] solution(int n, int m) {
        int divisorMax = 0;
        int multipleMin = 0;

        if (n == m) {
            return new int[] {2, 2};
        } else if (n > m) {
            for (int i = m; i >= 1; --i) {
                if (n % i == 0 && m % i == 0) {
                    divisorMax = i;
                    break;
                }
            }

            for (int i = 1; i * n <= n * m; ++i) {
                if ((n * i) % m == 0) {
                    multipleMin = n * i;
                    break;
                }
            }

        } else {
            for (int i = n; i >= 1; --i) {
                if (m % i == 0 && n % i == 0) {
                    divisorMax = i;
                    break;
                }
            }

            for (int i = 1; i * m <= n * m; ++i) {
                if ((m * i) % n == 0) {
                    multipleMin = m * i;
                    break;
                }
            }
        }

        return new int[] {divisorMax, multipleMin};
    }

    public static void main(String[] args) {
        new Main().solution(6, 4);
    }
}