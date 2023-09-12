import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());            // n개의 줄은 지뢰의 위치

            Character[][] landMind = new Character[n][n];
            int[][] map = new int[n][n];
            int[][] direct = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
            boolean flag = false;

            for (int i = 0; i < n; ++i) {
                String str = br.readLine();

                for (int j = 0; j < n; ++j) {
                    landMind[i][j] = str.charAt(j);
                }
            }

            for (int i = 0; i < n; ++i) {
                String str = br.readLine();

                for (int j = 0; j < n; ++j) {
                    if (str.charAt(j) == 'x') {
                        map[i][j] = 0;
                    } else {
                        map[i][j] = -1;
                    }
                }
            }

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (map[i][j] != -1) {
                        if (landMind[i][j] == '*') {
                            map[i][j] = -2;
                            flag = true;
                            continue;
                        }
                        int count = 0;

                        for (int k = 0; k < 8; ++k) {
                            int newY = i + direct[k][0];
                            int newX = j + direct[k][1];

                            if (newY < 0 || newY >= n || newX < 0 || newX >= n) {
                                continue;
                            }
                            if (landMind[newY][newX] == '*') {
                                count++;
                            }
                        }

                        map[i][j] = count;
                    }

                }
            }

            if (flag) {
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        if (landMind[i][j] == '*') {
                            map[i][j] = -2;
                        }
                    }
                }
            }


            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (map[i][j] == -1) {
                        System.out.print(".");
                    } else if (map[i][j] == -2) {
                        System.out.print("*");
                    } else {
                        System.out.print(map[i][j]);
                    }
                }
                System.out.println();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}