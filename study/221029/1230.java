import java.util.ArrayList;
import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            ArrayList<String> strList = new ArrayList<>();

            for (int i = 0; i < N; ++i) {
                strList.add(sc.next());
            }

            int orderN = sc.nextInt();

            for (int i = 0; i < orderN; ++i) {
                String c = sc.next();

                switch (c) {
                    case "I" :          //삽입 x, y, s --> x위치 다음에 y개의 숫자 삽입
                    {
                        int x = sc.nextInt();
                        int y = sc.nextInt();

                        for (int j = 0; j < y; ++j) {
                            String s = sc.next();

                            strList.add(x++, s);
                        }
                        break;
                    }
                    case "D" :
                    {
                        int x = sc.nextInt();
                        int y = sc.nextInt();

                        for (int j = 0; j < y; ++j) {
                            strList.remove(x);
                        }
                        break;
                    }
                    case "A" :
                    {
                        int y = sc.nextInt();

                        for (int j = 0; j < y; ++j) {
                            String s = sc.next();
                            strList.add(s);
                        }
                        break;
                    }
                }
            }

            System.out.print("#" + test_case + " ");

            for (int i = 0; i < 10; ++i) {
                System.out.print(strList.get(i) + " ");
            }

            System.out.println();
        }
    }
}