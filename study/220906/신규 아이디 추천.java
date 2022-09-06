import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String new_id = "abcdefghijklmn.p";
            StringBuilder id = new StringBuilder(new_id);
            String answer = "";

            for (int i = 0; i < id.length(); ++i) {
                if (id.charAt(i) >= 65 && id.charAt(i) <= 90) {         // 대문자일 때
                    id.setCharAt(i, (char) (id.charAt(i) + 32));
                    continue;
                }

                if (!(id.charAt(i) >= 97 && id.charAt(i) <= 122)) {        //소문자가 아닐 때
                    if (!(id.charAt(i) >= 48 && id.charAt(i) <= 57))
                    if (!(id.charAt(i) == '-' || id.charAt(i) == '_' || id.charAt(i) == '.')) {
                        id.deleteCharAt(i);
                        i--;
                        continue;
                    }
                }
            }

            for (int i = 0; i < id.length() - 1; ++i) {
                if (id.charAt(i) == '.') {
                    i++;
                    while (id.charAt(i) == '.') {
                        id.deleteCharAt(i);

                        if (id.length() - 1 < i) {
                            break;
                        }
                    }
                }
            }

            if (id.length() != 0 && id.charAt(0) == '.') {
                id.deleteCharAt(0);
            }

            if (id.length() != 0 && id.charAt(id.length() - 1) == '.') {
                id.deleteCharAt(id.length() - 1);
            }


            if (id.length() == 0) {
                id.append("a");
            } else if (id.length() >= 16) {
                id.setLength(15);

                if (id.charAt(14) == '.') {
                    id.deleteCharAt(14);
                }
            }

            if (id.length() <= 2) {
                while (id.length() <= 2) {
                    id.append(id.charAt(id.length()-1));
                }
            }

            answer = id.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}