import java.util.Arrays;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {

            int[] boxs = new int[100];

            int dump = sc.nextInt();

            for (int i = 0; i < 100; ++i) {
                boxs[i] = sc.nextInt();
            }

            Arrays.sort(boxs);

            for (int i = 0; i < dump; ++i) {
                boxs[99]--;
                boxs[0]++;

                if (boxs[0] > boxs[1]) {
                    Arrays.sort(boxs);
                }

                if (boxs[99] < boxs[98]) {
                    Arrays.sort(boxs);
                }

                if (boxs[99] - boxs[0] <= 1) {
                    break;
                }
            }
            System.out.print("#" + test_case + " ");
            System.out.println(boxs[99] - boxs[0]);
        }
    }
}