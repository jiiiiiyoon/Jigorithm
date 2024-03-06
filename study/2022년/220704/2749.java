import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            long n = Long.parseLong(br.readLine());

            int pisano = 1500000;

            long[] fibonacci = new long[pisano];

            fibonacci[0] = 0;
            fibonacci[1] = 1;

            for (int i = 2; i <= n && i < pisano; ++i) {
                fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 1000000;
            }

            System.out.println(fibonacci[(int)(n % pisano)]);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}