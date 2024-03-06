import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String[] str = br.readLine().split(" ");
                String[] printStr = str;
                int incorrectNum = 0;
                boolean[] rule = new boolean[6];
                boolean dipFlag = false;            //반드시 dip을 춰야 한다.
                boolean twirlFlag = false;          //만약 twirl을 췄다면,hop도 춰야한다.
                boolean hopFlag = false;
                ArrayList index = new ArrayList<Integer>();

                if (str == null) {
                    break;
                } else {
                    if (str[0].equals("jiggle")) {              // 4번째 규칙 jiggle로 춤을 시작할 수 없다
                        rule[4] = true;
                    }

                    if (str.length == 1) {
                        rule[2] = true;
                        if (str[0].equals("dip")) {
                            dipFlag = true;
                            rule[1] = true;
                            index.add(0);
                        } else if (str[0].equals("twirl")) {
                            rule[3] = true;
                        }

                    } else if (str.length == 2) {
                        rule[2] = true;

                        for (int i = 0; i < str.length; ++i) {
                            if (str[i].equals("dip")) {
                                dipFlag = true;

                                if (i == 0) {
                                    if (!str[1].equals("twirl")) {
                                        rule[1] = true;
                                        index.add(0);
                                    }
                                } else {
                                    if (!str[0].equals("jiggle")) {
                                        rule[1] = true;
                                        index.add(1);
                                    }
                                }

                                if (str[i].equals("twirl")) {
                                    twirlFlag = true;
                                } else if (str[i].equals("hop")) {
                                    hopFlag = true;
                                }
                            }
                        }
                    }

                    for (int i = 0; i < str.length - 2; ++i) {

                        if (i == str.length - 3) {              // 2번째 모든 춤은 clap stomp clap으로 끝나야 한다.
                            if (str[i].equals("clap")) {
                                if (str[i + 1].equals("stomp")) {
                                    if (!str[i + 2].equals("clap")) {
                                        rule[2] = true;
                                    }
                                } else {
                                    rule[2] = true;
                                }
                            } else {
                                rule[2] = true;
                            }
                        }

                        if (str[i].equals("dip")) {
                            dipFlag = true;

                            if (i == 0) {
                                if (!str[i + 1].equals("twirl")) {
                                    rule[1] = true;
                                    index.add(i);
                                }
                            } else if (i == 1) {
                                if (!str[i - 1].equals("jiggle") || !str[i + 1].equals("twirl")) {
                                    rule[1] = true;
                                    index.add(i);
                                }
                            } else {
                                if (!str[i - 1].equals("jiggle") || !str[i - 2].equals("jiggle") || !str[i + 1].equals("twirl")) {
                                    rule[1] = true;
                                    index.add(i);
                                }
                            }
                        } else if (str[i].equals("twirl")) {
                            twirlFlag = true;
                        } else if (str[i].equals("hop")) {
                            hopFlag = true;
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
                            incorrectNum++;
                        }
                    }

                    if (incorrectNum == 0) {                                // 규칙을 모두 지켰을 때
                        System.out.print("form ok: ");

                        for (int i = 0; i < printStr.length; ++i) {
                            System.out.print(printStr[i]+ " ");
                        }
                    } else if (incorrectNum == 1) {                         //규칙을 1개 어겼을 때
                        System.out.print("form error ");

                        if (rule[1]) {
                            System.out.print("1: ");

                            for (int i = 0; i < printStr.length; ++i) {
                                boolean flag = false;
                                for (int j = 0; j < index.size(); ++j) {
                                    if (index.get(j).equals(i)) {
                                        System.out.print("DIP ");
                                        flag = true;
                                    }
                                }
                                if (!flag) {
                                    System.out.print(printStr[i]+ " ");
                                }
                            }
                        } else {
                            for (int i = 2; i < 6; ++i) {
                                if (rule[i]) {
                                    System.out.print(i + ": ");
                                    break;
                                }
                            }

                            for (int i = 0; i < printStr.length; ++i) {
                                System.out.print(printStr[i]+ " ");
                            }
                        }
                    } else {                                                //규칙을 2개이상 어겼을 때
                        if (rule[1]) {                                      //첫번째 규칙을 어겼을 때
                            if (incorrectNum == 2) {
                                System.out.print("form errors 1 and ");
                            } else {
                                System.out.print("form errors 1, ");
                            }

                            incorrectNum--;

                            for (int i = 2; i < 6; ++i) {
                                if (rule[i]) {
                                    if (incorrectNum == 1) {
                                        System.out.print(i + ": ");
                                    } else if (incorrectNum == 2) {
                                        System.out.print(i + " and ");
                                    } else {
                                        System.out.print(i + ", ");
                                    }
                                    incorrectNum--;
                                }
                            }

                            for (int i = 0; i < printStr.length; ++i) {

                                boolean flag = false;
                                for (int j = 0; j < index.size(); ++j) {
                                    if (index.get(j).equals(i)) {
                                        System.out.print("DIP ");
                                        flag = true;
                                    }
                                }
                                if (!flag) {
                                    System.out.print(printStr[i]+ " ");
                                }
                            }

                        } else {
                            System.out.print("form errors ");

                            for (int i = 1; i < 6; ++i) {
                                if (rule[i]) {
                                    if (incorrectNum == 1) {
                                        System.out.print(i + ": ");
                                    } else if (incorrectNum == 2) {
                                        System.out.print(i + " and ");
                                    } else {
                                        System.out.print(i + ", ");
                                    }
                                    incorrectNum--;
                                }
                            }

                            for (int i = 0; i < printStr.length; ++i) {
                                System.out.print(printStr[i] + " ");
                            }
                        }
                    }

                    System.out.println();

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}