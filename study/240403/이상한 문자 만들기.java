public class Main {
    public String solution(String s) {
        String answer = "";
        s = s.toUpperCase();

        int index = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                index = 0;
                answer += " ";
                continue;
            } else {
                if (index % 2 == 0) {
                    answer += s.charAt(i);
                } else {
                    answer += (char)(s.charAt(i) + 32);
                }

                index++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Main().solution("try hello world"));
    }
}