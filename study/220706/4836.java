import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String inputstr;
            while ((inputstr = br.readLine()) != null) {
                String[] str = inputstr.split(" ");
                String printStr = "";
                int incorrectNum = 0;
                boolean[] rule = new boolean[6];
                boolean dipFlag = false;            //반드시 dip을 춰야 한다.
                boolean twirlFlag = false;          //만약 twirl을 췄다면,hop도 춰야한다.
                boolean hopFlag = false;
                ArrayList index = new ArrayList<Integer>();

                if (str.length < 3) {        //입력된 문장이 2단어 이하일 때
                    rule[2] = true;

                    if (str[0].equals("jiggle")) {
                        rule[4] = true;
                    }

                    for (int i = 0; i < str.length; ++i) {
                        if (str[i].equals("dip")) {
                            dipFlag = true;

                            if (i == 0) {
                                if (str.length == 1) {          // 문장의 길이가 1일 때
                                    rule[1] = true;
                                    printStr += "DIP ";
                                } else {                        // 문장의 길이가 2일 때
                                    if (!str[i + 1].equals("twirl")) {
                                        rule[1] = true;
                                        printStr += "DIP ";
                                    } else {
                                        printStr += "dip ";
                                    }
                                }
                            } else if (i == 1) {
                                if (!str[i - 1].equals("jiggle")) {
                                    rule[1] = true;
                                    printStr += "DIP ";
                                } else {
                                    printStr += "dip ";
                                }
                            }
                        } else if (str[i].equals("twirl")) {
                            twirlFlag = true;
                            printStr += "twirl ";
                        } else if (str[i].equals("hop")) {
                            hopFlag = true;
                            printStr += "hop ";
                        } else if (str[i].equals("jiggle")) {
                            printStr += "jiggle ";
                        }
                    }

                } else {                            //입력된 문장이 3단어 이상일 때
                    for (int i = 0; i < str.length; ++i) {
                        if (i == str.length - 3) {
                            if (!(str[i].equals("clap") && str[i + 1].equals("stomp") && str[i + 2].equals("clap"))) {
                                rule[2] = true;
                            }
                        }

                        if (str[i].equals("dip")) {
                            dipFlag = true;

                            if (i == 0 && !str[i + 1].equals("twirl")) {
                                rule[1] = true;
                                printStr += "DIP ";
                            } else if (i == 1 && !str[i - 1].equals("jiggle")) {
                                rule[1] = true;
                                printStr += "DIP ";
                            } else if (i > 1 && i < str.length - 1){
                                if (!(str[i + 1].equals("twirl") || str[i - 1].equals("jiggle") || str[i - 2].equals("jiggle"))) {
                                    rule[1] = true;
                                    printStr += "DIP ";
                                } else {
                                    printStr += "dip ";
                                }
                            }
                        } else if (str[i].equals("jiggle")) {
                            if (i == 0) {
                                rule[4] = true;
                            }
                            printStr += "jiggle ";
                        } else if (str[i].equals("twirl")) {
                            twirlFlag = true;
                            printStr += "twirl ";
                        } else if (str[i].equals("hop")) {
                            hopFlag = true;
                            printStr += "hop ";
                        } else {
                            printStr += str[i];
                        }
                    }

                }
                if (!dipFlag) {
                    rule[5] = true;
                }
                if (twirlFlag && !hopFlag) {
                    rule[3] = true;
                }

                for (int i = 1; i < 6; ++i) {
                    if (rule[i]) {
                        index.add(i);
                        incorrectNum++;
                    }
                }

                if (incorrectNum == 0) {           //규칙을 모두 지켰다면
                    System.out.print("form ok: ");
                } else if (incorrectNum == 1) {
                    System.out.print("form error " + index.get(0) + ": ");
                } else if (incorrectNum == 2){
                    System.out.print("form errors " + index.get(0) + " and " + index.get(1) + ": ");
                } else {
                    System.out.print("form errors ");
                    for (int i = 0; i < incorrectNum; ++i) {
                        if (i == incorrectNum - 2) {
                            System.out.print(index.get(i) + " and ");
                        } else if (i == incorrectNum - 1) {
                            System.out.print(index.get(i) + ": ");
                        } else {
                            System.out.print(index.get(i) + ", ");
                        }
                    }
                }
                System.out.println(printStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}