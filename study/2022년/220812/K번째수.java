import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int[] array = {1, 5, 2, 6, 3, 7, 4};
            int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
            ArrayList<Integer> result = new ArrayList<>();

            for (int t = 0; t < commands.length; ++t) {
                int i = commands[t][0];
                int j = commands[t][1];
                int k = commands[t][2];

                ArrayList<Integer> arrayList = new ArrayList<>();

                for (int a = i - 1; a < j; ++a) {
                    arrayList.add(array[a]);
                }

                int[] arrayNum = new int[arrayList.size()];

                for (int a = 0; a < arrayList.size(); ++a) {
                    arrayNum[a] = arrayList.get(a);
                }

                Arrays.sort(arrayNum);

                result.add(arrayNum[k - 1]);
            }

            int[] answer = new int[result.size()];

            for (int i = 0; i < result.size(); ++i) {
                answer[i] = result.get(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}