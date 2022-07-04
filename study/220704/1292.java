import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");

            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);

            ArrayList num = new ArrayList<Integer>();
            int sum = 0;
            for (int i = 1; num.size() != B; ++i) {
                for (int j = 1; j <= i; ++j) {
                    if (num.size() == B) {
                        break;
                    } else {
                        num.add(i);
                    }
                }
            }

            for (int i = A-1; i < B; ++i) {
                sum += (int) num.get(i);
            }

            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}