import java.util.Arrays;
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
            System.out.println(sc.next());
            int N = sc.nextInt();
            int[] number = new int[N];

            for (int i = 0; i < N; ++i) {
                String num = sc.next();

                switch (num) {
                    case "ZRO":
                        number[i] = 0;
                        break;
                    case "ONE":
                        number[i] = 1;
                        break;
                    case "TWO":
                        number[i] = 2;
                        break;
                    case "THR":
                        number[i] = 3;
                        break;
                    case "FOR":
                        number[i] = 4;
                        break;
                    case "FIV":
                        number[i] = 5;
                        break;
                    case "SIX":
                        number[i] = 6;
                        break;
                    case "SVN":
                        number[i] = 7;
                        break;
                    case "EGT":
                        number[i] = 8;
                        break;
                    case "NIN":
                        number[i] = 9;
                        break;
                }
            }

            Arrays.sort(number);

            for (int i = 0; i < N; ++i) {
                switch (number[i]) {
                    case 0:
                        System.out.print("ZRO ");
                        break;
                    case 1:
                        System.out.print("ONE ");
                        break;
                    case 2:
                        System.out.print("TWO ");
                        break;
                    case 3:
                        System.out.print("THR ");
                        break;
                    case 4:
                        System.out.print("FOR ");
                        break;
                    case 5:
                        System.out.print("FIV ");
                        break;
                    case 6:
                        System.out.print("SIX ");
                        break;
                    case 7:
                        System.out.print("SVN ");
                        break;
                    case 8:
                        System.out.print("EGT ");
                        break;
                    case 9:
                        System.out.print("NIN ");
                        break;
                }
            }
            System.out.println();
        }
    }
}