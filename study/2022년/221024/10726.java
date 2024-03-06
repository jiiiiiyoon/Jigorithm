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
            int M = sc.nextInt();
            boolean flag = false;

            String str = Integer.toString(M, 2);

            if (str.length() < N) {
                System.out.println("#" + test_case + " OFF");
            } else {
                for (int i = str.length() - 1; i > str.length() - 1 - N; --i) {
                    if (str.charAt(i) == '0') {
                        flag = true;
                        System.out.println("#" + test_case + " OFF");
                        break;
                    }
                }

                if (!flag) {
                    System.out.println("#" + test_case + " ON");
                }
            }
        }
    }
}