import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] alphabet = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            String s = br.readLine();

            for (int i = 0; i < s.length(); ++i) {
                if (alphabet[s.charAt(i)-97] == -1) {
                    alphabet[s.charAt(i)-97] = i;
                }
            }

            for (int i = 0; i < 26; ++i) {
                System.out.print(alphabet[i] + " ");
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}