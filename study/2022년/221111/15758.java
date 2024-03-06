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
            String strS = sc.next();
            String strT = sc.next();
            String funS = strS;
            String funT = strT;
            while (strS.length() <= 50 && strT.length() <= 50) {
                if (funS.equals(funT)) {
                    System.out.println("#" + test_case + " yes");
                    break;
                }

                if (funS.length() < funT.length()) {
                    funS += strS;
                } else if (funS.length() > funT.length()) {
                    funT += strT;
                } else {
                    System.out.println("#" + test_case + " no");
                    break;
                }
            }
        }
    }
}