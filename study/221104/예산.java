import java.util.Arrays;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        int[] d = {2,2,3,3};
        int budget = 10;
        int answer = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; ++i) {
            if (budget - d[i] < 0) {
                break;
            } else {
                answer++;
                budget -= d[i];
            }
        }

        System.out.print(answer);
    }
}