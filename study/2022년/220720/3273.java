import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] number = new int[n];
            int count = 0;
            int first = 0;
            int last = n - 1;

            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; ++i) {
                number[i] = Integer.parseInt(str[i]);
            }

            Arrays.sort(number);

            while (first < last) {
                int num = number[first] + number[last];

                if (num == x) {
                    count++;
                    first += 1;
                    last -= 1;
                } else if (num > x) {
                    last -= 1;
                } else {
                    first += 1;
                }
            }

            System.out.print(count);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}