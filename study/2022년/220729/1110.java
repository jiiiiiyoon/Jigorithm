import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
                int N = Integer.parseInt(br.readLine());
                int correct = N;
                int num = 0;
                int count = 0;

                if (N < 10) {
                    int a = N;
                    int b = N;
                    num = a * 10 + b;
                    N = num;
                    count++;
                }

                while (correct != num) {
                    int a = N % 10;
                    int b = ((N / 10) + (N % 10)) % 10;


                    num = a * 10 + b;
                    N = num;
                    count++;
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