import java.util.Arrays;
import java.util.Comparator;

public class Main {
    class Node {
        int index;
        int[] answer;
        int result;

        Node(int index, int[] answer, int result) {
            this.index = index;
            this.answer = answer;
            this.result = result;
        }
    }
    public int[] solution(int[] answers) {
        int[] answer;
        Node[] person = new Node[3];

        person[0] = new Node(1, new int[] {1, 2, 3, 4, 5}, 0);
        person[1] = new Node(2, new int[] {2, 1, 2, 3, 2, 4, 2, 5}, 0);
        person[2] = new Node(3, new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}, 0);

        for (int i = 0; i < answers.length; ++i) {
            if (answers[i] == person[0].answer[i % person[0].answer.length]) {
                person[0].result++;
            }

            if (answers[i] == person[1].answer[i % person[1].answer.length]) {
                person[1].result++;
            }

            if (answers[i] == person[2].answer[i % person[2].answer.length]) {
                person[2].result++;
            }
        }

        Arrays.sort(person, new Comparator<Node>() {
            @Override
            public int compare(Node p1, Node p2) {
                if (p1.result < p2.result) return 1;
                else if (p1.result == p2.result) {
                    if (p1.index > p2.index) return 1;
                }
                return -1;
            }
        });

        if (person[0].result != person[1].result) {
            answer = new int[] {person[0].index};
        } else {
            if (person[1].result != person[2].result) {
                answer = new int[] {person[0].index, person[1].index};
            } else {
                answer = new int[] {person[0].index, person[1].index, person[2].index};
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2, 1, 1, 1, 1, 1,1 , 1};
        System.out.println(new Main().solution(answers));
    }
}