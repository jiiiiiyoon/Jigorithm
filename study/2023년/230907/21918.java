import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str = br.readLine().split(" ");

            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);

            str = br.readLine().split(" ");
            int[] map = new int[N];

            for (int i = 0; i < N; ++i) {
                map[i] = Integer.parseInt(str[i]);
            }

            for (int m = 0; m < M; ++m) {
                str = br.readLine().split(" ");

                int a = Integer.parseInt(str[0]);

                if (a == 1) {
                    int i = Integer.parseInt(str[1]);
                    int x = Integer.parseInt(str[2]);

                    map[i - 1] = x;
                } else {
                    int l = Integer.parseInt(str[1]);
                    int r = Integer.parseInt(str[2]);

                    if (a == 2) {
                        for (int i = l -1; i < r; ++i) {
                            if (map[i] == 0) {
                                map[i] = 1;
                            } else {
                                map[i] = 0;
                            }
                        }
                    } else if (a == 3) {
                        for (int i = l -1; i < r; ++i) {
                            map[i] = 0;
                        }
                    } else {
                        for (int i = l -1; i < r; ++i) {
                            map[i] = 1;
                        }
                    }
                }
            }

            for (int i = 0; i < N; ++i) {
                System.out.print(map[i] + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}