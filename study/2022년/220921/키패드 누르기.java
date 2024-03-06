import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    class Hand {
        int x;
        int y;

        Hand (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
            String hand = "right";
            String answer = "";

            Hand left = new Hand(0, 3);
            Hand right = new Hand(2, 3);

            for (int i = 0; i < numbers.length; ++i) {
                Character h;
                switch (numbers[i]) {
                    case 1:
                        answer += "L";
                        left.x = 0;
                        left.y = 0;
                        break;
                    case 2:
                        h = choiceHand(left, right, 1, 0, hand);
                        answer += h;

                        if (h == 'R') {
                            right.x = 1;
                            right.y = 0;
                        } else {
                            left.x = 1;
                            left.y = 0;
                        }
                        break;
                    case 3:
                        answer += "R";
                        right.x = 2;
                        right.y = 0;
                        break;
                    case 4:
                        answer += "L";
                        left.x = 0;
                        left.y = 1;
                        break;
                    case 5:
                        h = choiceHand(left, right, 1, 1, hand);
                        answer += h;

                        if (h == 'R') {
                            right.x = 1;
                            right.y = 1;
                        } else {
                            left.x = 1;
                            left.y = 1;
                        }
                        break;
                    case 6:
                        answer += "R";
                        right.x = 2;
                        right.y = 1;
                        break;
                    case 7:
                        answer += "L";
                        left.x = 0;
                        left.y = 2;
                        break;
                    case 8:
                        h = choiceHand(left, right, 1, 2, hand);
                        answer += h;

                        if (h == 'R') {
                            right.x = 1;
                            right.y = 2;
                        } else {
                            left.x = 1;
                            left.y = 2;
                        }
                        break;
                    case 9:
                        answer += "R";
                        right.x = 2;
                        right.y = 2;
                        break;
                    case 0:
                        h = choiceHand(left, right, 1, 3, hand);
                        answer += h;

                        if (h == 'R') {
                            right.x = 1;
                            right.y = 3;
                        } else {
                            left.x = 1;
                            left.y = 3;
                        }
                        break;
                }
            }



            System.out.println(answer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    Character choiceHand (Hand left, Hand right, int x, int y, String hand) {
        int leftX = left.x - x;
        int leftY = left.y - y;
        int rightX = right.x - x;
        int rightY = right.y - y;

        if (leftX < 0) {
            leftX = -leftX;
        }
        if (leftY < 0) {
            leftY = -leftY;
        }
        if (rightX < 0) {
            rightX = -rightX;
        }
        if (rightY < 0) {
            rightY = -rightY;
        }

        if (leftX + leftY < rightX + rightY) {
            return 'L';
        } else if (leftX + leftY > rightX + rightY) {
            return 'R';
        } else {
            if (hand.equals("right")) {
                return 'R';
            } else {
                return 'L';
            }
        }
    }

    public static void main(String[] args){
        new Main().solve();
    }
}