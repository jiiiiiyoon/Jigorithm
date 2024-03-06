import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String dartResult = "1D2S3T*";
            int answer = 0;

            int[] num = new int[3];
            int count = 0;

            for (int i = 0; i < dartResult.length(); ++i) {
                if (dartResult.charAt(i) == 'S') {
                    continue;
                } else if (dartResult.charAt(i) == 'D') {
                    num[count-1] = num[count-1] * num[count-1];
                } else if (dartResult.charAt(i) == 'T') {
                    num[count-1] = num[count-1] * num[count-1] * num[count-1];
                } else if (dartResult.charAt(i) == '*') {
                    if (count == 1) {
                        num[count-1] = num[count-1] * 2;
                     } else if (count > 1){
                        num[count-1] = num[count-1] * 2;
                        num[count-2] = num[count-2] * 2;
                    }
                } else if (dartResult.charAt(i) == '#') {
                    num[count-1] = -num[count-1];
                } else {
                    if (dartResult.charAt(i+1) == '0') {
                        num[count] = 10;
                        i++;
                    } else {
                        num[count] = Integer.parseInt(String.valueOf(dartResult.charAt(i)));
                    }

                    count++;
                }
            }
            answer = num[0] + num[1] + num[2];

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}