import java.io.*;
import java.sql.Struct;
import java.util.*;

public class Main {
    private void solve() {
        class Student {
            int recommend;
            int time;

            Student (int recommend, int time) {
                this.recommend = recommend;
                this.time = time;
            }
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int T = Integer.parseInt(br.readLine());

            String[] str = br.readLine().split(" ");
            ArrayList<Integer> picture = new ArrayList<>();
            HashMap<Integer, Student> student = new HashMap<>();

            for (int i = 0; i < T; ++i) {
                int index =  Integer.parseInt(str[i]);
                int removeIndex = 0;
                int oldTime = 0;

                if (student.containsKey(index)) {           //추천받은적이 있다면
                    student.replace(index, new Student(student.get(index).recommend + 1, student.get(index).time));
                } else {                                    //추천받은적이 없거나 삭제되었다면
                    student.put(index ,new Student(1, 0));
                }

                if (picture.size() < N) {   // 비어있는 사진틀이 있는 경우
                    if (picture.contains(index)) {
                        student.replace(index, new Student(student.get(index).recommend + 1, student.get(index).time));
                    } else {
                        picture.add(index);
                    }
                } else {                    // 비어있는 사진틀이 없는 경우
                    if (picture.contains(index)) {
                        student.replace(index, new Student(student.get(index).recommend + 1, student.get(index).time));
                    } else {
                        for (int j = 1; j < T; ++j) {
                            boolean flag = false;

                            for (int k = 0; k < picture.size(); ++k) {
                                if (student.get(picture.get(k)).recommend == j) {

                                    if (!flag) {
                                        flag = true;
                                    }

                                    if (oldTime < student.get(picture.get(k)).time) {
                                        oldTime = student.get(picture.get(k)).time;
                                        removeIndex = picture.get(k);
                                    }
                                }
                            }
                            if (flag) {
                                break;
                            }
                        }

                        picture.set(picture.indexOf(removeIndex), index);
                        student.remove(removeIndex);
                    }
                }

                for (int j = 0; j < picture.size(); ++j) {
                    student.replace(picture.get(j), new Student(student.get(picture.get(j)).recommend, student.get(picture.get(j)).time + 1));
                }
            }

            Collections.sort(picture);

            for (int i = 0; i < picture.size(); ++i) {
                System.out.print(picture.get(i) + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}