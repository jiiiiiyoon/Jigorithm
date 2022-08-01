import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] numbers = {2, 1, 3, 4, 1};

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < numbers.length - 1; ++i) {
                for (int j = i + 1; j < numbers.length; ++j) {
                    if (!list.contains(numbers[i] + numbers[j])) {
                        list.add(numbers[i] + numbers[j]);
                    }
                }
            }

            int[] answer = new int[list.size()];

            for (int i = 0; i < list.size(); ++i) {
                answer[i] = list.get(i);
            }

            Arrays.sort(answer);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}