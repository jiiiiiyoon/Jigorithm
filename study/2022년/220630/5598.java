import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = br.readLine();

            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == 'A') {
                    System.out.print('X');
                } else if (s.charAt(i) == 'B') {
                    System.out.print('Y');
                } else if (s.charAt(i) == 'C') {
                    System.out.print('Z');
                } else {
                    System.out.print((char)(s.charAt(i)-3));
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