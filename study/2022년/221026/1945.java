import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            System.out.print("#" + test_case + " ");
            int num = sc.nextInt();
            int twoCount = 0;
            int threeCount = 0;
            int fiveCount = 0;
            int sevenCount = 0;
            int elvCount = 0;

            while (num % 2 == 0) {
                num /= 2;
                twoCount++;
            }

            while (num % 3 == 0) {
                num /= 3;
                threeCount++;
            }

            while (num % 5 == 0) {
                num /= 5;
                fiveCount++;
            }

            while (num % 7 == 0) {
                num /= 7;
                sevenCount++;
            }

            while (num % 11 == 0) {
                num /= 11;
                elvCount++;
            }

            System.out.println(twoCount + " " + threeCount + " " + fiveCount + " " + sevenCount + " " + elvCount);
        }
    }
}