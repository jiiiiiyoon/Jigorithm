import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int max = 0;
            int maxIndex = 0;

            for (int i = 1; i <= 9; ++i) {
                int num = Integer.parseInt(br.readLine());
                if (num > max) {
                    max = num;
                    maxIndex = i;
                }
            }
            System.out.println(max);
            System.out.println(maxIndex);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}