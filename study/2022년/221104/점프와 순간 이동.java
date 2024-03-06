import java.util.*;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        int n = 5000;
        int ans = 0;

        while (n != 0) {
            if (n % 2 == 1) {
                ans++;
                n -= 1;
            } else {
                n /= 2;
            }
        }

        System.out.print(ans);

    }
}