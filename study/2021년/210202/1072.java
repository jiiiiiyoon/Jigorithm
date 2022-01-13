import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] s = br.readLine().split(" ");
            double X = Integer.parseInt(s[0]);              //게임 횟수
            double Y = Integer.parseInt(s[1]);              //이긴 게임
            double win =  Y * 100 / X;                   
            long Z = (long) win;                            //승률
            boolean flag = false;
            long turn = 0;

            if (Z != 100 && Z != 99) {
                while(!flag) {
                    Y++;
                    X++;
                    turn++;
    
                    double newWin = Y * 100 / X;
                    long newZ = (long) newWin;
    
    
                    if (newZ != Z) {
                        flag = true;
                    }
                }
            }
           
            if(flag) {
                System.out.println(turn);
            } else{
                System.out.println(-1);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Main().solve();
    }
    
}
