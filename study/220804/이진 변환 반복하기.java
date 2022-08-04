import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = "1111111";
            int zeroCount = 0;
            int count = 0;

            do {
                StringBuilder str = new StringBuilder();

                for (int i = 0; i < s.length(); ++i) {
                    if (s.charAt(i) == '1') {
                        str.append(1);
                    } else {
                        zeroCount++;
                    }
                }

                s = String.valueOf(str.length());
                s = Integer.toBinaryString(Integer.parseInt(s));
                str.delete(0, str.length());
                count++;
            } while (!s.equals("1"));


            int[] answer = {count, zeroCount};

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}