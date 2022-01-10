import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str = br.readLine().split(" ");
            if (str.length <= 0) {
                System.out.println(0);
            } else {
                if (str[0].equals("")) {
                    System.out.println(str.length-1);
                } else {
                    System.out.println(str.length);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}