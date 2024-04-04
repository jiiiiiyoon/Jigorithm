import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public int solution(int[][] sizes) {
        int min = Integer.MAX_VALUE;

        int widthMax = -1;
        int heightMax = -1;

        for (int i = 0; i < sizes.length; ++i) {
            if (widthMax < sizes[i][0]) {
                widthMax = sizes[i][0];
            }

            if (heightMax < sizes[i][1]) {
                heightMax = sizes[i][1];
            }
        }


        for (int i = widthMax; i >= 0; --i) {
            boolean flag = true;

            for (int j = heightMax; j >= 0; --j) {

                for (int k = 0; k < sizes.length; ++k) {
                    if (!((sizes[k][0] <= i && sizes[k][1] <= j) || (sizes[k][0] <= j && sizes[k][1] <= i))) {
                        flag = false;
                        break;
                    }
                }

                if (!flag) {
                    break;
                }
                if (min > i * j) {
                    min = i * j;
                }
            }
        }


        return min;
    }

    public static void main(String[] args) {
        int[][] sizes = {{20, 10}, {12, 18}};
        new Main().solution(sizes);
    }
}