import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int []arr = {1, 1, 3, 3, 0, 1, 1};

            ArrayList<Integer> result = new ArrayList<>();
            int preNum = -1;

            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int i = 0; i < arr.length; ++i) {
                if (preNum != arr[i]) {
                    preNum = arr[i];
                    result.add(preNum);
                }
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