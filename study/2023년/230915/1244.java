import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            boolean[] state = new boolean[n + 1];
            String[] str = br.readLine().split(" ");
            int gCount = 0;

            for (int i = 1; i <= n; ++i) {
                if (str[i - 1].equals("1")) {
                    state[i] = true;
                } else {
                    state[i] = false;
                }
            }
            int studentN = Integer.parseInt(br.readLine());

            int[][] student = new int[studentN][2];

            for (int i = 0; i < studentN; ++i) {
                str = br.readLine().split(" ");

                student[i][0] = Integer.parseInt(str[0]);
                student[i][1] = Integer.parseInt(str[1]);
            }

            for (int i = 0; i < studentN; ++i) {
                switch (student[i][0]) {
                    case 1:
                        state[student[i][1]] = !state[student[i][1]];
                        for (int j = 2; j <= 100; ++j) {
                            if (student[i][1] * j <= n) {
                                state[student[i][1] * j] = !state[student[i][1] * j];
                            } else {
                                break;
                            }
                        }
                        break;
                    case 2:
                        state[student[i][1]] = !state[student[i][1]];
                        gCount = 0;
                        for (int j = 1; student[i][1] - j >= 1 && student[i][1] + j <= n; ++j) {
                            if (state[student[i][1] - j] == state[student[i][1] + j]) {
                                gCount++;
                            } else {
                                break;
                            }
                        }

                        for (int j = 1; j <= gCount; ++j) {
                            state[student[i][1] - j] = !state[student[i][1] - j];
                            state[student[i][1] + j] = !state[student[i][1] + j];
                        }
                }
            }

            int count = 0;

            for (int i = 1; i <= n; ++i) {
                if (state[i]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
                count++;

                if (count == 20) {
                    count = 0;
                    System.out.println();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}