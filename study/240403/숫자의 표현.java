public class Main {
    public int solution(int n) {
        int answer = 1;

        if (n < 3) {
            return answer;
        }

        for (int i = n / 2 + 1; i >= 1; --i) {
            int sum = 0;

            for (int j = i; j > 0; --j) {
                sum += j;

                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Main().solution(5));
    }
}