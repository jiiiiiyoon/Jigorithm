import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = "1 2 3 4";
            String answer = "";

            String[] str = s.split(" ");
            int[] num = new int[str.length];

            for (int i = 0; i < num.length; ++i) {
                num[i] = Integer.parseInt(str[i]);
            }

            Arrays.sort(num);

            answer = num[0] + " " + num[num.length - 1];
            System.out.println(answer);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}