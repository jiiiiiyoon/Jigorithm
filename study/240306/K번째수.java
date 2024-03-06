import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] array = {1, 5, 2, 6, 3, 7, 4};
            int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

            ArrayList<Integer> answerList = new ArrayList<>();

            for (int t = 0; t < commands.length; ++t) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                int i = commands[t][0];
                int j = commands[t][1];
                int k = commands[t][2];

                for (int a = i - 1; a < j; ++a) {
                    arrayList.add(array[a]);
                }

                Collections.sort(arrayList);

                answerList.add(arrayList.get(k - 1));
            }

            int[] answer = new int[answerList.size()];
            int size = 0;
            for (int tmp : answerList) {
                answer[size++] = tmp;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}