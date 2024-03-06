import java.io.*;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;

            for (int i = 1; i <= N; ++i) {
                if (i > 99) {        //100 ~ 999
                    int h = i / 100;
                    int t = (i % 100) / 10;
                    int o = i % 10;

                    if ((h < t && t < o) || (h > t && t > o) || (h == t && t == o)) {
                        if (t - h == o - t) {
                            count++;
                        }
                    }
                } else {
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