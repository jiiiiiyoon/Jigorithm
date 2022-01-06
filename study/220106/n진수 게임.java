import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.IntBinaryOperator;

public class Main {


    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = 16;      // 진법
            int t = 16;      // 미리 구할 숫자의 갯수
            int m = 2;      // 게임에 참가하는 인원
            int p = 1;      // 튜브의 순서

            StringBuilder str = new StringBuilder();
            String answer = "";

            str.append(0);

            for (int i = 1; t > 0; ++i) {
                str.append(Integer.toString(i, n).toUpperCase());
                if (str.length() >= m) {
                    answer += str.toString().charAt(p-1);
                    t--;
                    str.delete(0, m);
                }
            }

            System.out.println(answer);


        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}