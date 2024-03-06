import java.util.Arrays;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            System.out.print("#" + sc.nextInt() + " ");
            int rowMax = 0;
            int[] colMax = new int[100];
            int digMax1 = 0;
            int digMax2 = 0;

            int[] Max = new int[4];

            for (int i = 0; i < 100; ++i) {
                int rowSum = 0;

                for (int j = 0; j < 100; ++j) {
                    int num = sc.nextInt();
                    rowSum += num;
                    colMax[j] += num;

                    if (i == j) {
                        digMax1 += num;
                    } else if (99 - i == j) {
                        digMax2 += num;
                    }
                }

                if (rowMax < rowSum) {
                    rowMax = rowSum;
                }
            }

            Arrays.sort(colMax);

            Max[0] = rowMax;
            Max[1] = colMax[99];
            Max[2] = digMax1;
            Max[3] = digMax2;

            Arrays.sort(Max);

            System.out.println(Max[3]);
        }
    }
}