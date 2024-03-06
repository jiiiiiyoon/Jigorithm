import java.util.*;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int answer = 0;

        for (int i = 0; i < skill_trees.length; ++i) {
            boolean wordFlag = false;
            int skillIndex = 0;

            for (int j = 0; j < skill_trees[i].length(); ++j) {
                boolean flag = false;

                if (skill.contains(String.valueOf(skill_trees[i].charAt(j)))) {
                    if (skill.charAt(skillIndex) == skill_trees[i].charAt(j)) {
                        skillIndex++;
                    } else {
                        wordFlag = true;
                        break;
                    }
                }
            }

            if (!wordFlag) {
                answer++;
            }
        }

        System.out.print(answer);


    }
}