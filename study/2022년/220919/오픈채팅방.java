import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private void solve() {
        class Record {
            boolean isEnter;
            String uid;

            Record (boolean isEnter, String uid) {
                this.isEnter = isEnter;
                this.uid = uid;
            }
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
            HashMap<String, String> userNick = new HashMap<>();
            ArrayList<Record> records = new ArrayList<>();

            for (int i = 0; i < record.length; ++i) {
                String[] str = record[i].split(" ");

                if (str[0].equals("Enter")) {
                    userNick.put(str[1], str[2]);
                    records.add(new Record(true, str[1]));
                } else if (str[0].equals("Leave")){
                    records.add(new Record(false, str[1]));
                } else if (str[0].equals("Change")) {
                    userNick.put(str[1], str[2]);
                }
            }

            String[] answer = new String[records.size()];

            for (int i = 0; i < records.size(); ++i) {
                if (records.get(i).isEnter) {
                    answer[i] = userNick.get(records.get(i).uid) + "님이 들어왔습니다.";
                } else {
                    answer[i] = userNick.get(records.get(i).uid) + "님이 나갔습니다.";
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