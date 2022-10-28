import java.util.Arrays;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int towerNum = sc.nextInt();
            int[] towers = new int[towerNum];
            int viewSum = 0;

            for (int i = 0; i < towerNum; ++i) {
                towers[i] = sc.nextInt();
            }

            for (int i = 2; i < towerNum - 2; ++i) {
                int[] sideTowers = new int[4];

                sideTowers[0] = towers[i - 2];
                sideTowers[1] = towers[i - 1];
                sideTowers[2] = towers[i + 1];
                sideTowers[3] = towers[i + 2];

                Arrays.sort(sideTowers);

                if (towers[i] > sideTowers[3]) {
                    viewSum += towers[i] - sideTowers[3];
                }
            }

            System.out.println("#" + test_case + " " + viewSum);
        }
    }
}