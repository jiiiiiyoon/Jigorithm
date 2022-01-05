import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = 5;
            int[] arr1 = {9,20,28,18,11};
            int[] arr2 = {30,1,21,17,28};
            String[] answer = new String[n];

            String [][] map1 = new String[n][n];
            String [][] map2 = new String[n][n];

            for (int j = 0; j < n; ++j) {
                int count1 = n-1;
                int count2 = n-1;

                while (arr1[j] != 0) {

                    if (arr1[j] % 2 == 1) {
                        map1[j][count1] = "#";
                    } else {
                        map1[j][count1] = " ";
                    }
                    count1--;
                    arr1[j] /= 2;
                }
                if (count1 >= 0) {
                    for (int i = count1; i >= 0; --i) {
                        map1[j][i] = " ";
                    }
                }
                while (arr2[j] != 0) {

                    if (arr2[j] % 2 == 1) {
                        map2[j][count2] = "#";
                    } else {
                        map2[j][count2] = " ";
                    }
                    count2--;
                    arr2[j] /= 2;
                }

                if (count2 >= 0) {
                    for (int i = count2; i >= 0; --i) {
                        map2[j][i] = " ";
                    }
                }
            }

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (map1[i][j].equals("#") || map2[i][j] == "#") {
                        if (answer[i] == null) {
                            answer[i] = "#";
                        } else {
                            answer[i] += "#";
                        }
                    } else {
                        if (answer[i] == null){
                            answer[i] = " ";
                        } else {
                            answer[i] += " ";
                        }
                    }
                }
                System.out.println(answer[i]);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}