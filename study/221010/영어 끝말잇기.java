import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = 3;
            String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
            ArrayList<String> arrayList = new ArrayList<>();
            int[] answer = new int[2];
            int user = 0;

            for (int i = 0; i < words.length; ++i) {
                user += 1;

                if (user == n + 1) {
                    user = 1;
                }

                if (!arrayList.isEmpty()) {
                    String str = arrayList.get(i - 1);

                    if (arrayList.contains(words[i])) {
                        answer[0] = user;
                        answer[1] = i / n + 1;
                        break;
                    }

                    if (str.charAt(str.length() - 1) != words[i].charAt(0)) {
                        answer[0] = user;
                        answer[1] = (i / n) + 1;
                        break;
                    }
                }

                arrayList.add(words[i]);

            }

            System.out.println(answer[0] + " " + answer[1]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}