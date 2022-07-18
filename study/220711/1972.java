import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            while (true) {
                String str = br.readLine();

                if (str.equals("*")) {
                    break;
                }

                boolean flag = false;

                for (int i = 0; i <= str.length()-2; ++i) {
                    ArrayList wordList = new ArrayList<String>();

                    for (int j = 0; j < str.length() - (i + 1); ++j) {
                        String word = "";
                        word += str.charAt(j);
                        word += str.charAt(j + i + 1);

                        if (wordList.contains(word)) {
                            flag = true;
                            break;
                        }

                        wordList.add(word);
                    }

                    if (flag) {
                        break;
                    }
                }

                System.out.print(str);

                if (flag) {
                    System.out.println(" is NOT surprising.");
                } else {
                    System.out.println(" is surprising.");
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