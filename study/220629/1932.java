import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];

            for (int i = 0; i < n; ++i) {
                String[] s = br.readLine().split(" ");

                for (int j = 0; j < i+1; ++j) {
                    map[i][j] = Integer.parseInt(s[j]);
                }
            }

            for (int i = 0; i < n; ++i) {
                if (i != 0) {
                    for (int j = 0; j < i+1; ++j) {
                        if (j == 0) {
                            map[i][j] = map[i][j] + map[i-1][j];
                        } else if (j == i) {
                            map[i][j] = map[i][j] + map[i-1][j-1];
                        } else {
                            int num1 = map[i][j] + map[i-1][j-1];
                            int num2 = map[i][j] + map[i-1][j];
                            if (num1 > num2) {
                                map[i][j] = num1;
                            } else {
                                map[i][j] = num2;
                            }
                        }
                    }
                }
            }
            Arrays.sort(map[n-1]);

            System.out.println(map[n-1][n-1]);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}