import java.util.Arrays;

public class Main {
    public int solution(int []A, int []B)
    {
        int answer = 0;

        int[] reverseB = new int[B.length];

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < B.length; ++i) {
            reverseB[i] = B[B.length - 1 - i];
        }

        for (int i = 0; i < A.length; ++i) {
            answer += A[i] * reverseB[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 2};
        int[] b = {5, 4, 4};
        new Main().solution(a, b);
    }
}