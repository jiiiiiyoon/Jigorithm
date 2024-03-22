import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        boolean[] flag = new boolean[n];
        Arrays.sort(reserve);
        Arrays.sort(lost);

        ArrayList<Integer> lostList = new ArrayList<>();
        ArrayList<Integer> reserveList = new ArrayList<>();

        for (int i : lost) {
            lostList.add(i);
        }

        for (int i : reserve) {
            reserveList.add(i);
        }

        for (int i = 0; i < lost.length; ++i) {
            if (reserveList.contains(lost[i])) {
                lostList.remove((Integer) lost[i]);
                reserveList.remove((Integer) lost[i]);
                answer++;
            }
        }

        if (lostList.isEmpty()) {
            return n;
        }

        answer = n - lostList.size();

        for (int i = 0; i < reserveList.size(); ++i) {
            flag[reserveList.get(i) - 1] = true;
        }

        for (int i = 0; i < lostList.size(); ++i) {
            if (lostList.get(i) == 1) {
                if (flag[lostList.get(i)]) {
                    answer++;
                    flag[lostList.get(i)] = false;
                }
            } else if (lostList.get(i) == n) {
                if (flag[lostList.get(i) - 2]) {
                    answer++;
                    flag[lostList.get(i) - 2] = false;
                }
            } else {
                if (flag[lostList.get(i) - 2]) {
                    answer++;
                    flag[lostList.get(i) - 2] = false;
                } else if (flag[lostList.get(i)]) {
                    answer++;
                    flag[lostList.get(i)] = false;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] lost = {4, 5};
        int[] reserve = {3, 4};
        System.out.println(new Main().solution(5, lost, reserve));
    }
}