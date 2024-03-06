import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private void solve() {
        //A - 65
        //a - 97
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String str = br.readLine();
            Integer [][] alpha = new Integer[26][2];

            for (int i = 0; i < 26; ++i) {
                alpha[i][0] = 0;
                alpha[i][1] = i+65;
            }

            for (int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);

                if (c >= 65 && c <= 90) {
                    alpha[c-65][0]++;
                } else {
                    alpha[c-97][0]++;
                }
            }

            Arrays.sort(alpha, (o1, o2) -> {
                if (o1 == o2) {
                    return o2[1] - o1[1];
                } else {
                    return o2[0] - o1[0];
                }
            });

            if (alpha[0][0].equals(alpha[1][0])) {
                System.out.println("?");
            } else {
                int a = alpha[0][1];
                System.out.println((char)a);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}