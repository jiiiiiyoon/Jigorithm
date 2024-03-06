import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            int[] number = new int[N];
            int count = 0;

            String[] str = br.readLine().split(" ");

            for (int i = 0; i < N; ++i) {
                number[i] = Integer.parseInt(str[i]);
            }

            for (int i = 0; i < N; ++i) {
                int count2 = 0;
                if (number[count] != 0) {
                    count2 = count + number[count];
                    System.out.print(count + 1);

                    if (count2 < 0) {
                        count2 = count2 -1 + 10;
                    }

                    count = count2 % (N - 1);

                } else {

                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}