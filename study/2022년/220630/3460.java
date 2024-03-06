import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());

            for (int t = 0; t < T; ++t) {
                String binary = Integer.toBinaryString(Integer.parseInt(br.readLine()));

                for (int i = binary.length()-1; i >= 0; --i) {
                    if (binary.charAt(i) == '1') {
                        System.out.print(binary.length() - i - 1 + " ");
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}