import java.util.HashMap;

public class Main {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String, Integer> point = new HashMap<>();

        for (int i = 0; i < name.length; ++i) {
            point.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; ++i) {
            int score = 0;

            for (int j = 0; j < photo[i].length; ++j) {
                if (point.containsKey(photo[i][j])) {
                    score += point.get(photo[i][j]);
                }
            }
            answer[i] = score;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] name = {"muzi", "ryan", "frodo", "neo"};
        int[] yearing = {5, 10, 1, 3};
        String[][] photo = {{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}};

        new Main().solution(name, yearing, photo);
    }
}