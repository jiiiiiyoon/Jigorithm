import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str = br.readLine().split(" ");

            int N = Integer.parseInt(str[0]);
            int K = Integer.parseInt(str[1]);
            int max = 0;

            for (int i = 1; i <= K; ++i) {
                String numStr = "";
                String newStr = "";
                int num = N * i;
                numStr = String.valueOf(num);

                for (int j = numStr.length() - 1; j >= 0; --j) {
                    newStr += numStr.charAt(j);
                }

                if (max < Integer.parseInt(newStr)) {
                    max = Integer.parseInt(newStr);
                }
            }

            System.out.println(max);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}