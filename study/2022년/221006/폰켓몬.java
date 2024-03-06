import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] nums = {3,3,3,2,2,2};
            int answer = 0;

            HashMap<Integer, Integer> monster = new HashMap<>();
            int MaxN = nums.length / 2;

            for (int i = 0; i < nums.length; ++i) {
                if (!monster.containsKey(nums[i])) {
                    monster.put(nums[i], 1);
                } else {
                    monster.put(nums[i], monster.get(nums[i]) + 1);
                }
            }

            if (MaxN < monster.size()) {
                answer = MaxN;
            } else {
                answer = monster.size();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}