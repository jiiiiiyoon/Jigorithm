import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            //NUM X: X를 스택의 가장 위에 저장한다. (0 ≤ X ≤ 109)
            //POP: 스택 가장 위의 숫자를 제거한다.
            //INV: 첫 번째 수의 부호를 바꾼다. (42 -> -42)
            //DUP: 첫 번째 숫자를 하나 더 스택의 가장 위에 저장한다.
            //SWP: 첫 번째 숫자와 두 번째 숫자의 위치를 서로 바꾼다.
            //ADD: 첫 번째 숫자와 두 번째 숫자를 더한다.
            //SUB: 첫 번째 숫자와 두 번째 숫자를 뺀다. (두 번째 - 첫 번째)
            //MUL: 첫 번째 숫자와 두 번째 숫자를 곱한다.
            //DIV: 첫 번째 숫자로 두 번째 숫자를 나눈 몫을 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
            //MOD: 첫 번째 숫자로 두 번째 숫자를 나눈 나머지를 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.

            while (true) {
                String s = br.readLine();

                if (s.equals("QUIT")) {
                    break;
                }

                ArrayList<String> order = new ArrayList<>();
                order.add(s);

                if (!s.equals("END")) {
                    while (true) {
                        String o = br.readLine();

                        if (o.equals("END")) {
                            break;
                        }

                        order.add(o);

                    }
                }

                int T = Integer.parseInt(br.readLine());

                for (int t = 0; t < T; ++t) {
                    int num = Integer.parseInt(br.readLine());
                    boolean flag = false;

                    Stack<Integer> stack = new Stack<>();
                    stack.push(num);

                    for (int i = 0; i < order.size(); ++i) {
                        String[] orderStr = order.get(i).split(" ");

                        switch (orderStr[0]) {
                            case "NUM" : {
                                stack.push(Integer.parseInt(orderStr[1]));
                                break;
                            }
                            case "POP" : {
                                if (stack.isEmpty()) {
                                    flag = true;
                                } else {
                                    stack.pop();
                                }

                                break;
                            }
                            case "INV" : {
                                if (stack.isEmpty()) {
                                    flag = true;
                                } else {
                                    int n = stack.pop();
                                    stack.push(-n);
                                }

                                break;
                            }
                            case "DUP" : {
                                if (stack.isEmpty()) {
                                    flag = true;
                                } else {
                                    int n = stack.peek();
                                    stack.push(n);
                                }

                                break;
                            }
                            case "SWP" : {
                                if (stack.size() < 2) {
                                    flag = true;
                                } else {
                                    int n1 = stack.pop();
                                    int n2 = stack.pop();

                                    stack.push(n1);
                                    stack.push(n2);
                                }

                                break;
                            }
                            case "ADD" : {
                                if (stack.size() < 2) {
                                    flag = true;
                                } else {
                                    long n1 = stack.pop();
                                    long n2 = stack.pop();

                                    if (Math.abs(n1 + n2) <= 1000000000) {
                                        stack.push((int) n1 + (int) n2);
                                    } else {
                                        flag = true;
                                    }
                                }

                                break;
                            }
                            case "SUB" : {
                                if (stack.size() < 2) {
                                    flag = true;
                                } else {
                                    int n1 = stack.pop();
                                    int n2 = stack.pop();

                                    if (Math.abs(n2 - n1) <= 1000000000) {
                                        stack.push(n2 - n1);
                                    } else {
                                        flag = true;
                                    }
                                }

                                break;
                            }
                            case "MUL" : {
                                if (stack.size() < 2) {
                                    flag = true;
                                } else {
                                    long n1 = stack.pop();
                                    long n2 = stack.pop();

                                    if (Math.abs(n1 * n2) <= 1000000000) {
                                        stack.push((int) n1 * (int) n2);
                                    } else {
                                        flag = true;
                                    }
                                }

                                break;
                            }
                            case "DIV" : {
                                if (stack.size() < 2) {
                                    flag = true;
                                } else {
                                    long n1 = stack.pop();
                                    long n2 = stack.pop();

                                    if (n1 == 0) {
                                        flag = true;
                                        break;
                                    }

                                    if (Math.abs(n2 / n1) <= 1000000000) {
                                        stack.push((int) n2 / (int) n1);
                                    } else {
                                        flag = true;
                                    }
                                }

                                break;
                            }
                            case "MOD" : {
                                if (stack.size() < 2) {
                                    flag = true;
                                } else {
                                    long n1 = stack.pop();
                                    long n2 = stack.pop();

                                    if (n1 == 0) {
                                        flag = true;
                                        break;
                                    }

                                    if (Math.abs(n2 % n1) <= 1000000000) {
                                        stack.push((int) n2 % (int) n1);
                                    } else {
                                        flag = true;
                                    }
                                }

                                break;
                            }
                            case "END" : {
                                break;
                            }
                        }

                        if (flag) {
                            break;
                        }
                    }

                    if (stack.size() != 1 || flag) {
                        System.out.println("ERROR");
                    } else {
                        System.out.println(stack.pop());
                    }
                }

                System.out.println();
                br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().solve();
    }
}