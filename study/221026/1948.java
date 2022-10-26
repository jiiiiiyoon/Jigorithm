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
            int month1, day1, month2, day2 = 0;
            month1 = sc.nextInt();
            day1 = sc.nextInt();
            month2 = sc.nextInt();
            day2 = sc.nextInt();

            int daySum = 0;

            if (month1 == month2) {
                System.out.println("#" + test_case + " " + (day2 - day1 + 1));
            } else {
                if (month1 == 4 || month1 == 6 || month1 == 9 || month1 == 11) {
                    daySum += 30 - day1 + day2;
                } else if (month1 == 2) {
                    daySum += 28 - day1 + day2;
                } else {
                    daySum += 31 - day1 + day2;
                }

                for (int i = month1 + 1; i < month2; ++i) {
                    if (i == 4 || i == 6 || i == 9 || i == 11) {
                        daySum += 30;
                    } else if (i == 2) {
                        daySum += 28;
                    } else {
                        daySum += 31;
                    }
                }

                System.out.println("#" + test_case + " " + (daySum + 1));
            }
        }
    }
}