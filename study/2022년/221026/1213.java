import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            sc.nextInt();
            String word = sc.next();
            String string = sc.next();
            String[] str = string.split(word);


            if (str[str.length -1].equals(string.substring(string.length() - str[str.length -1].length(), string.length()))) {
                System.out.println("#" + test_case + " " + (str.length-1));
            } else {
                System.out.println("#" + test_case + " " + str.length);
            }


        }
    }
}