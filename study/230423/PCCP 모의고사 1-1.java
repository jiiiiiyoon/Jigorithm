import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input_string = "zbzbz";
            String result = "";
            String answer;
            boolean[] visited = new boolean[26];
            //97~112
            char alpha = input_string.charAt(0);
            visited[(int) alpha - 97] = true;

            for (int i = 1; i < input_string.length(); ++i) {
                char c = input_string.charAt(i);

                if (alpha != c) {
                    alpha = c;

                    if (visited[(int) c - 97] && !result.contains(String.valueOf(c))) {
                        result += c;
                    } else {
                        visited[(int) c - 97] = true;
                    }
                }
            }

            char[] tmp = result.toCharArray();
            Arrays.sort(tmp);
            answer = new String(tmp);

            System.out.println(answer);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}