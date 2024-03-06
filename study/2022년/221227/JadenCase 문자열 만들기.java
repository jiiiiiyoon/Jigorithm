import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = "hello world";
            String answer = "";
            s = s.toLowerCase();

            String[] newS = s.split(" ");

            for (int i = 0; i < newS.length; ++i) {

                if (newS[i].length() == 0) {
                    if (i == newS.length - 1) {
                        break;
                    }
                    answer+= newS[i] + " ";
                    continue;
                }

                String s1 = newS[i].substring(0, 1).toUpperCase();
                String s2 = newS[i].substring(1, newS[i].length());

                newS[i] = s1 + s2;

                if (i == newS.length - 1) {
                    answer += newS[i];
                } else {
                    answer += newS[i] + " ";
                }
            }

            if (s.length() != answer.length()) {
                for (int i = 0; i < s.length() - answer.length(); ++i) {
                    answer += " ";
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