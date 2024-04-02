public class Main {
    public int solution(int balls, int share) {
        long ballsMul = 1;
        int n_m = balls - share;
        long n_mMul = 1;

        for (int i = share + 1; i <= balls; ++i) {
            ballsMul *= i;

            ballsMul /= n_mMul;
            n_mMul++;
        }


        return (int)ballsMul;
    }

    public static void main(String[] args) {

        new Main().solution(5, 3);
    }
}