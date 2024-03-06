import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int cacheSize = 3;
            String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
            int answer = 0;

            Queue<String> queue = new LinkedList<>();

            if (cacheSize == 0) {
                answer = cities.length * 5;
            } else {
                for (int i = 0; i < cities.length; ++i) {
                    if (!queue.contains(cities[i].toLowerCase())) {
                        answer += 5;

                        if (queue.size() >= cacheSize) {
                            queue.poll();
                        }

                        queue.add(cities[i].toLowerCase());
                    } else {
                        queue.remove(cities[i].toLowerCase());
                        queue.add(cities[i].toLowerCase());
                        answer++;
                    }
                }
            }

            System.out.print(answer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}