import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[][] map = new int[5][5];
            HashMap<String, int[]> hashMap = new HashMap<>();
            int count = 0;
            int bingo = 0;
            for (int i = 0; i < 5; ++i) {
                String[] str = br.readLine().split(" ");

                for (int j = 0; j < 5; ++j) {
                    map[i][j] = Integer.parseInt(str[j]);
                    hashMap.put(str[j], new int[]{i, j});
                }
            }

            for (int i = 0; i < 5; ++i) {
                String[] str = br.readLine().split(" ");

                for (int j = 0; j < 5; ++j) {
                    int[] xy = hashMap.get(str[j]);
                    map[xy[0]][xy[1]] = -1;
                    count++;

                    if (count < 5) {
                        continue;
                    }

                    if (map[0][0] == -1 && map[1][1] == -1 && map[2][2] == -1 && map[3][3] == -1 && map[4][4] == -1) {
                        bingo++;
                    }
                    if (map[0][4] == -1 && map[1][3] == -1 && map[2][2] == -1 && map[3][1] == -1 && map[4][0] == -1) {
                        bingo++;
                    }

                    for (int k = 0; k < 5; ++k) {
                        if (map[k][0] == -1 && map[k][1] == -1 && map[k][2] == -1 && map[k][3] == -1 && map[k][4] == -1) {
                            bingo++;
                        }
                        if (map[0][k] == -1 && map[1][k] == -1 && map[2][k] == -1 && map[3][k] == -1 && map[4][k] == -1) {
                            bingo++;
                        }
                    }

                    if (bingo >= 3) {
                        break;
                    }

                    bingo = 0;
                }

                if (bingo >= 3) {
                    System.out.println(count);
                    break;
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