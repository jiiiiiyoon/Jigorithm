import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] lottos = {44, 1, 0, 0, 31, 25};
            int[] win_nums = {31, 10, 45, 1, 6, 19};

            int[] answer = new int[2];
            int zeroCount = 0;
            int result = 0;

            ArrayList<Integer> lottoNumList = new ArrayList<>();
            ArrayList<Integer> winNumList = new ArrayList<>();

            for (int i = 0; i < lottos.length; ++i) {
                if (lottos[i] == 0) {
                    zeroCount++;
                } else {
                    lottoNumList.add(lottos[i]);
                }

                winNumList.add(win_nums[i]);
            }

            for (int i = 0; i < lottoNumList.size(); ++i) {
                if (winNumList.contains(lottoNumList.get(i))) {
                    result++;
                }
            }

            int max = 7 - (result + zeroCount);
            int min = 7 - result;

            if (result < 2) {
                if (result + zeroCount < 2) {
                    answer[0] = 6;
                } else {
                    answer[0] = max;
                }

                answer[1] = 6;
            } else {
                answer[0] = max;
                answer[1] = min;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}