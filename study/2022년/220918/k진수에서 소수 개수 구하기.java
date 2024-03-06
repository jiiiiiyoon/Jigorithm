import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int n = 110011;
            int k = 10;

            String str = Integer.toString(n, k);
            String[] number = str.split("0+");

            int answer = 0;

            for (int i = 0; i < number.length; ++i) {
                Long num = Long.parseLong(number[i]);
                boolean flag = false;

                for (long j = 2; j <= Math.sqrt(num); ++j) {
                    if (num % j == 0) {
                        flag = true;
                    }
                }

                if (num != 1 && !flag) {
                    answer++;
                }
            }

            System.out.print(answer);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}