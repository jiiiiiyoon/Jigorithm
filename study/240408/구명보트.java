import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < people.length; ++i) {
            deque.add(people[i]);
        }

        int sum = 0;

        while (!deque.isEmpty()) {
            sum = 0;

            sum += deque.pollLast();

            if (!deque.isEmpty() && sum + deque.peekFirst() <= limit) {
                sum += deque.pollFirst();
            }

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        new Main().solution(new int[]{70, 80, 50}, 100);
    }
}