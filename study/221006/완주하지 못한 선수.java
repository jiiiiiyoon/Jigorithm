import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] participant = {"leo", "kiki", "eden"};
            String[] completion = {"eden", "kiki"};
            String answer = "";

            HashMap<String, Integer> NameHash = new HashMap<>();

            for (int i = 0; i < participant.length; ++i) {
                if (!NameHash.containsKey(participant[i])) {
                    NameHash.put(participant[i], 1);
                } else {
                    NameHash.put(participant[i], NameHash.get(participant[i]) + 1);
                }
            }

            for (int i = 0; i < completion.length; ++i) {
                NameHash.put(completion[i], NameHash.get(completion[i]) - 1);

                if (NameHash.get(completion[i]) == 0) {
                    NameHash.remove(completion[i]);
                }
            }

            String[] str = NameHash.toString().split("=");
            String[] str2 = str[0].split("\\{");
            answer = str2[1];



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}