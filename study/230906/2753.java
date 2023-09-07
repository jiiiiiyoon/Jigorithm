import java.io.*;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int year = Integer.parseInt(br.readLine());
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (year % 4 == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}