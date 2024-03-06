import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);               // 칭호의 개수
            int M = Integer.parseInt(str[1]);               // 캐릭터들의 개수

            String[][] title = new String[2][N];
            StringBuilder sb =  new StringBuilder();

            for (int i = 0; i < N; ++i) {
                str = br.readLine().split(" ");

                title[0][i] = str[0];
                title[1][i] = str[1];
            }

            for (int i = 0; i < M; ++i) {
                int num = Integer.parseInt(br.readLine());

                int left = 0;
                int right = N - 1;

                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (num <= Integer.parseInt(title[1][mid])) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

                sb.append(title[0][right + 1] + "\n");
            }

            System.out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}