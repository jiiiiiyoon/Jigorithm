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
            String str = sc.next();
            String str2 = "";
            boolean flag = false;
            int state = -1;
            int count = 0;

            for (int i = 0; i < str.length(); ++i) {
                str2 += "0";
            }

            for (int i = 0; i < str.length(); ++i) {

                if (!flag && str.charAt(i) == '1') {
                    state = 0;
                    flag = true;
                }

                if (str.charAt(i) == '1' && flag && state == 0) {
                    state = 1;
                    count++;
                    str2 = str2.substring(0, i);

                    for (int j = i; j < str.length(); ++j) {
                        str2 += "1";
                    }
                } else if (str.charAt(i) == '0' && flag && state == 1) {
                    state = 0;
                    count++;
                    str2 = str2.substring(0, i);

                    for (int j = i; j < str.length(); ++j) {
                        str2 += "0";
                    }
                }

                if (str.equals(str2)) {
                    System.out.println("#" + test_case + " " + count);
                    break;
                }
            }
        }
    }
}