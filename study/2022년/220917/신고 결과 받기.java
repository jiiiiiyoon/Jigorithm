import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String[] id_list = {"muzi", "frodo", "apeach", "neo"};
            String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
            int k = 2;
            ArrayList<String> id_index = new ArrayList<>(Arrays.asList(id_list));   //인덱스를 알기위한 ArrayList

            int[] answer = new int[id_list.length];                                //메일을 받은 횟수

            ArrayList<String>[] reportList = new ArrayList[id_list.length];

            for (int i = 0; i < id_list.length; ++i) {
                reportList[i] = new ArrayList<String>();
            }

            //신고 리스트
            //index는 id_list와 같고
            //값은 신고한 유저를 넣어준다
            //ex muzi가 frodo를 신고하면 reportList[1]에 muzi 추가됨


            for (int i = 0; i < report.length; ++i) {
                String[] str = report[i].split(" ");
                int index = id_index.indexOf(str[1]);

                if (!reportList[index].contains(str[0])) {
                    reportList[index].add(str[0]);
                }
            }

            for (int i = 0; i < id_list.length; ++i) {
                if (reportList[i].size() >= k) {
                    for (int j = 0; j < reportList[i].size(); ++j) {
                        answer[id_index.indexOf(reportList[i].get(j))]++;
                    }
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