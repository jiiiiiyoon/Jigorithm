import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(br.readLine());
            int[] divisor = new int[num];
            String[] s = br.readLine().split(" ");

            for (int i = 0; i < num; ++i) {
                divisor[i] = Integer.parseInt(s[i]);
            }

            Arrays.sort(divisor);

            if (num == 1) {
                System.out.println(divisor[0]*divisor[0]);
            } else {
                System.out.println(divisor[0]*divisor[divisor.length-1]);
            }


        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}