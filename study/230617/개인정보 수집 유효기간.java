import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String today = "2020.01.01";
            String[] terms = {"Z 3", "D 5"};
            String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

            List<Integer> list = new ArrayList<>();

            int todayInt = Integer.parseInt(today.replace(".", ""));

            System.out.print(todayInt);

            HashMap<String, Integer> hashMap = new HashMap<>();

            for (int i = 0; i < terms.length; ++i) {
                String[] str = terms[i].split(" ");

                hashMap.put(str[0], Integer.parseInt(str[1]));
            }

            for (int i = 0; i < privacies.length; ++i) {
                String[] str1 = privacies[i].split(" ");
                String[] str2 = str1[0].split("\\.");

                int year = Integer.parseInt(str2[0]);
                int month = Integer.parseInt(str2[1]);
                int date = Integer.parseInt(str2[2]);

                int term = hashMap.get(str1[1]);

                month += term;
                date -= 1;

                if (month > 12) {
                    year += month / 12;
                    month = month % 12;
                }

                if (month == 0) {
                    month = 12;
                    year -= 1;
                }

                if (date == 0) {
                    date = 28;
                    month -= 1;
                }

                int result = year * 10000 + month * 100 + date;

                if (result < todayInt) {
                    list.add(i + 1);
                }

            }

            int[] answer = new int[list.size()];

            for (int i = 0; i < list.size(); ++i) {
                answer[i] = list.get(i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}