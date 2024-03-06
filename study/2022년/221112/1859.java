import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();

            int[] price = new int[N];
            long totalPrice = 0;
            int maxPrice = 0;
            int[] dp = new int[N];

            for (int i = 0; i < N; ++i) {
                price[i] = sc.nextInt();
            }

            maxPrice = price[N - 1];

            for (int i = N - 2; i >= 0; --i) {
                if (maxPrice > price[i]) {
                    totalPrice += (maxPrice - price[i]);
                } else {
                    maxPrice = price[i];
                }
            }

            System.out.println("#" + test_case+ " " + totalPrice);
        }
    }
}