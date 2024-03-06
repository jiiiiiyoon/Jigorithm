import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution
{
    static class Node {
        String alpha;
        int count;

        Node (String alpha, int count) {
            this.alpha = alpha;
            this.count = count;
        }
    }
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            System.out.println("#" + test_case);
            int N = sc.nextInt();

            Queue<Node> queue = new LinkedList<>();

            for (int i = 0; i < N; ++i) {
                String a = sc.next();
                int c = sc.nextInt();

                queue.offer(new Node(a, c));
            }
            Node node = null;
            boolean flag = false;
            while (true) {
                if (node == null || node.count == 0) {
                    node = queue.poll();
                }

                for (int i = 0; i < 10; ++i) {
                    System.out.print(node.alpha);
                    node.count--;

                    if (node.count == 0) {
                        if (queue.isEmpty()) {
                            flag = true;
                            break;
                        }
                        node = queue.poll();
                    }
                }
                System.out.println();
                if (flag) {
                    break;
                }
            }
        }
    }
}