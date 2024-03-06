import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            float[] score = new float[N];
            float max = 0;
            float avg = 0;
            String[] s = br.readLine().split(" ");

            for (int i = 0; i < N; ++i) {
                score[i] = Integer.parseInt(s[i]);

                if (max < Integer.parseInt(s[i])) {
                    max = Integer.parseInt(s[i]);
                }
            }

            for (int i = 0; i < N; ++i) {
                score[i] = score[i] / max * 100;
                avg += score[i];
            }

            System.out.println(avg/N);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}