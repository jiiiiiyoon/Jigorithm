import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < 8; ++i) {
                queue.offer(sc.nextInt());
            }

            boolean flag = false;

            while (true) {
                for (int i = 1; i <= 5; ++i) {
                    int num = queue.poll();
                    num -= i;

                    if (num <= 0) {
                        queue.offer(0);
                        flag = true;
                        break;
                    } else {
                        queue.offer(num);
                    }
                }

                if (flag) {
                    break;
                }
            }

            System.out.print("#" + test_case + " ");

            for (int i = 0; i < 8; ++i) {
                System.out.print(queue.poll() + " ");
            }

            System.out.println();
        }
    }
}