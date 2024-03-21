import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static boolean[] check = new boolean[7];
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int answer = 0;
            String numbers = "011";

            for (int i = 0; i < numbers.length(); ++i) {
                dfs(numbers, "", i + 1);
            }

            for (int i = 0; i < arrayList.size(); ++i) {
                int num = arrayList.get(i);

                boolean flag = false;
                if (num >= 2) {
                    flag = true;

                    for (int j = 2; j * j <= arrayList.get(i); ++j) {
                        if (arrayList.get(i) % j == 0) {
                            flag = false;
                            break;
                        }
                    }
                }

                if (flag) {
                    answer++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void dfs(String str, String tmp, int m) {
        if (tmp.length() == m) {
            int num = Integer.parseInt(tmp);

            if (!arrayList.contains(num)) {
                arrayList.add(num);
            }
        }

        for (int i = 0; i < str.length(); ++i) {
            if (!check[i]) {
                check[i] = true;
                tmp += str.charAt(i);
                dfs (str, tmp, m);

                check[i] = false;
                tmp = tmp.substring(0, tmp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}