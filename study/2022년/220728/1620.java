import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str = br.readLine().split(" ");

            int N = Integer.parseInt(str[0]);
            int T = Integer.parseInt(str[1]);

            String[] pokemon = new String[N];
            HashMap<String, Integer> pokemonIndex = new HashMap<>();

            for (int i = 0; i < N; ++i) {
                String s = br.readLine();
                pokemon[i] = s;
                pokemonIndex.put(s, i + 1);
            }

            for (int t = 0; t < T; ++t) {
                String problem = br.readLine();

                if (problem.charAt(0) <= 57) {
                    System.out.println(pokemon[Integer.parseInt(problem) - 1]);
                } else {
                    System.out.println(pokemonIndex.get(problem));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}