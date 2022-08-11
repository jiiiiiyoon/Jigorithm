import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int[] answers = {1,3,2,4,2};

            int[] person1 = {1, 2, 3, 4 ,5};
            int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            int[] result = new int[3];
            int max = 0;
            int maxCount = 0;
            int answerIndex = 0;
            for (int i = 0; i < answers.length; ++i) {
                if (person1[i % person1.length] == answers[i]) {
                    result[0]++;
                }
                if (person2[i % person2.length] == answers[i]) {
                    result[1]++;
                }
                if (person3[i % person3.length] == answers[i]) {
                    result[2]++;
                }
            }

            for(int i=0; i<3; i++){
                if(result[i] > max){
                    max = result[i];
                }
            }

            for(int i=0; i<3; i++){
                if(result[i] == max){
                    maxCount++;
                }
            }

            int[] answer = new int[maxCount];

            for(int i=0; i<3; i++){
                if(result[i] == max) {
                    answer[answerIndex++] = i+1;
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