

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public int solution(String[][] clothes) {

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> clotheName = new ArrayList<>();

        for (int i = 0; i < clothes.length; ++i) {
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                map.put(clothes[i][1], 1);
                clotheName.add(clothes[i][1]);
            }
        }

        int combination = 1;

        for (int i = 0; i < clotheName.size(); ++i) {
            combination *= map.get(clotheName.get(i)) + 1;
        }

        return combination - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        new Main().solution(clothes);
    }
}