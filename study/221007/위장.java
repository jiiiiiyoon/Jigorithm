import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
            int answer = 1;
            HashMap<String, Integer> clothesHash = new HashMap<>();

            for (int i = 0; i < clothes.length; ++i) {
                String[] str = clothes[i];
                clothesHash.put(str[1], clothesHash.getOrDefault(str[1], 1) + 1);
            }

            String[] keys = clothesHash.keySet().toArray(new String[0]);

            for (int i = 0; i < keys.length; ++i) {
                answer *= clothesHash.get(keys[i]);
            }

            answer -= 1;


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}