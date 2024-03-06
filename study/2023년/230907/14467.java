import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[] map = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            int count = 0;

            for (int n = 0; n < N; ++n) {
                String[] str = br.readLine().split(" ");
                int cow = Integer.parseInt(str[0]) - 1;
                int state = Integer.parseInt(str[1]);

                if (map[cow] == -1) {
                    map[cow] = state;
                    continue;
                }

                if (map[cow] != state) {
                    map[cow] = state;
                    count++;
                }
            }

            System.out.println(count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}