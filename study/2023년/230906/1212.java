import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String octal = br.readLine();

            for (int i = 0; i < octal.length(); ++i) {
                int target = octal.charAt(i) - '0';

                String s = Integer.toBinaryString(target);

                if (s.length() == 3) {
                    System.out.print(s);
                } else if (s.length() == 2 && i != 0) {
                    System.out.print("0" + s);
                } else if (s.length() == 1 && i != 0) {
                    System.out.print("00" + s);
                } else {
                    System.out.print(s);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}