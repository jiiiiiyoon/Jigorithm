import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = sc.nextInt();
            String str = sc.next();
            StringBuilder word = new StringBuilder(str);

            for (int i = 0; i < str.length() - 1; ++i) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    word.replace(i, i + 2, "");
                    str = word.toString();
                    i -= 2;

                    if (i < -1) {
                        i = -1;
                    }
                }
            }

            System.out.println("#" + test_case + " " + str);
        }
    }
}