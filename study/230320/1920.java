import java.io.*;
import java.sql.Struct;
import java.util.*;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> numbers = new ArrayList<>();
            String[] str = br.readLine().split(" ");

            for (int i = 0; i < N; ++i) {
                numbers.add(Integer.parseInt(str[i]));
            }

            int M = Integer.parseInt(br.readLine());
            str = br.readLine().split(" ");

            Collections.sort(numbers);

            for (int i = 0; i < M; ++i) {
                if (Collections.binarySearch(numbers, Integer.parseInt(str[i])) >= 0) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}