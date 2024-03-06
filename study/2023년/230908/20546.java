import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int initMoney = Integer.parseInt(br.readLine());
            int jhMoney = initMoney;
            int jhStock = 0;
            int smMoney = initMoney;
            int smStock = 0;


            int increase = 0;
            int decrease = 0;

            String[] str = br.readLine().split(" ");

            for (int i = 0; i < str.length; ++i) {
                if (Integer.parseInt(str[i]) <= jhMoney) {
                    jhStock += jhMoney / Integer.parseInt(str[i]);
                    jhMoney = jhMoney % Integer.parseInt(str[i]);
                }
            }

            for (int i = 1; i < str.length - 2; ++i) {
                if (Integer.parseInt(str[i - 1]) < Integer.parseInt(str[i]) && Integer.parseInt(str[i]) < Integer.parseInt(str[i + 1]) && Integer.parseInt(str[i + 1]) < Integer.parseInt(str[i + 2])) {
                    if (smStock != 0) {
                        smMoney += smStock * Integer.parseInt(str[i + 2]);
                        i += 2;
                    }
                } else if (Integer.parseInt(str[i - 1]) > Integer.parseInt(str[i]) && Integer.parseInt(str[i]) > Integer.parseInt(str[i + 1]) && Integer.parseInt(str[i + 1]) > Integer.parseInt(str[i + 2])) {
                    if (Integer.parseInt(str[i + 2]) <= smMoney) {
                        smStock = smMoney / Integer.parseInt(str[i + 2]);
                        smMoney = smMoney % Integer.parseInt(str[i + 2]);
                        i += 2;
                    }
                }
            }

            jhMoney += jhStock * Integer.parseInt(str[str.length - 1]);
            smMoney += smStock * Integer.parseInt(str[str.length - 1]);

            if (jhMoney > smMoney) {
                System.out.println("BNP");
            } else if (smMoney > jhMoney) {
                System.out.println("TIMING");
            } else {
                System.out.println("SAMESAME");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}