import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private void solve() {
        class Node {
            int index;
            double rate;

            Node (int index, double rate) {
                this.index = index;
                this.rate = rate;
            }
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = 5;                                      //전체 스테이지의 개수
            int[] stages = {3, 3, 3, 3};        // 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
//            스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수 == 실패율
            double[] stagePlayer = new double[N + 1];
            double playerNum = stages.length;
            Node[] node = new Node[N];
            int[] answer = new int[N];

            for (int i = 0; i < stages.length; ++i) {
                stagePlayer[stages[i] - 1]++;
            }

            for (int i = 0; i < N; ++i) {
                node[i] = new Node(i + 1, stagePlayer[i] / playerNum);
                playerNum -= stagePlayer[i];

                if (playerNum <= 0) {
                    playerNum = 1;
                }


            }

            Arrays.sort(node, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return Double.compare(o2.rate,o1.rate);
                }
            });


            for (int i = 0; i < N; ++i) {
                answer[i] = node[i].index;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}