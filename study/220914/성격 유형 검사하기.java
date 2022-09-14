import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] survey = {"TR", "RT", "TR"};
            int[] choices = {7, 1, 3};
            String answer = "";
            Character[] category = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};    //성격 유형
                                                                                //라이언형(R), 튜브형(T)
                                                                                //콘형(C), 프로토형(F)
                                                                                //제이지형(J), 무지형(M)
                                                                                //어피치형(A), 네오형(N)
            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < category.length; ++i) {
                map.put(category[i], 0);
            }

            for (int i = 0; i < survey.length; ++i) {
                switch (choices[i]) {
                    case 1:
                        map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 3);
                        break;
                    case 2:
                        map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 2);
                        break;
                    case 3:
                        map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + 1);
                        break;
                    case 5:
                        map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + 1);
                        break;
                    case 6:
                        map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + 2);
                        break;
                    case 7:
                        map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + 3);
                        break;
                }
            }

            for (int i = 0; i < 8; i += 2) {
                if (map.get(category[i]) > map.get(category[i + 1])) {
                    answer = answer + category[i];
                } else if (map.get(category[i]) == map.get(category[i + 1])) {
                    if (category[i] < category[i + 1]) {
                        answer = answer + category[i];
                    } else {
                        answer = answer + category[i + 1];
                    }
                } else {
                    answer = answer + category[i + 1];
                }
            }

            for (int i = 0; i < 3; ++i) {

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}
