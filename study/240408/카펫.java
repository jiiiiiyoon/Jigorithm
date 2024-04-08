public class Main {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 1;; ++i) {
            int sum = 0;

            if (yellow % i == 0) {
                sum += (i + 2) * 2;
                sum += (yellow / i) * 2;

                if (sum == brown) {
                    answer[0] = yellow / i + 2;
                    answer[1] = i + 2;
                    return answer;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Main().solution(10, 2);
    }
}