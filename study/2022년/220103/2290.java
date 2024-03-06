import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str = br.readLine().split(" ");

            int s = Integer.parseInt(str[0]);

            Character[][] n0 = new Character[(2 * s) + 3][s + 2];
            Character[][] n1 = new Character[(2*s)+ 3][s+2];
            Character[][] n2 = new Character[(2*s)+ 3][s+2];
            Character[][] n3 = new Character[(2*s)+ 3][s+2];
            Character[][] n4 = new Character[(2*s)+ 3][s+2];
            Character[][] n5 = new Character[(2*s)+ 3][s+2];
            Character[][] n6 = new Character[(2*s)+ 3][s+2];
            Character[][] n7 = new Character[(2*s)+ 3][s+2];
            Character[][] n8 = new Character[(2*s)+ 3][s+2];
            Character[][] n9 = new Character[(2*s)+ 3][s+2];

            for (int i = 0; i < (2*s) + 3; ++i) {
                if (i == 0) {
                    for (int j = 1; j < s + 1; ++j) {
                        n2[i][j] = '-';
                        n3[i][j] = '-';
                        n5[i][j] = '-';
                        n6[i][j] = '-';
                        n7[i][j] = '-';
                        n8[i][j] = '-';
                        n9[i][j] = '-';
                        n0[i][j] = '-';
                    }
                } else if (i == ((2*s)+3)/2){
                    for (int j = 1; j < s + 1; ++j) {
                        n2[i][j] = '-';
                        n3[i][j] = '-';
                        n4[i][j] = '-';
                        n5[i][j] = '-';
                        n6[i][j] = '-';
                        n8[i][j] = '-';
                        n9[i][j] = '-';
                    }
                } else if (i == (2*s)+2) {
                    for (int j = 1; j < s + 1; ++j) {
                        n2[i][j] = '-';
                        n3[i][j] = '-';
                        n5[i][j] = '-';
                        n6[i][j] = '-';
                        n8[i][j] = '-';
                        n9[i][j] = '-';
                        n0[i][j] = '-';
                    }
                } else if (i < ((2*s)+3)/2) {
                    n1[i][s+1] = '|';
                    n2[i][s+1] = '|';
                    n3[i][s+1] = '|';
                    n4[i][0] = '|';
                    n4[i][s+1] = '|';
                    n5[i][0] = '|';
                    n6[i][0] = '|';
                    n7[i][s+1] = '|';
                    n8[i][0] = '|';
                    n8[i][s+1] = '|';
                    n9[i][0] = '|';
                    n9[i][s+1] = '|';
                    n0[i][0] = '|';
                    n0[i][s+1] = '|';
                } else {
                    n1[i][s+1] = '|';
                    n2[i][0] = '|';
                    n3[i][s+1] = '|';
                    n4[i][s+1] = '|';
                    n5[i][s+1] = '|';
                    n6[i][0] = '|';
                    n6[i][s+1] = '|';
                    n7[i][s+1] = '|';
                    n8[i][0] = '|';
                    n8[i][s+1] = '|';
                    n9[i][s+1] = '|';
                    n0[i][0] = '|';
                    n0[i][s+1] = '|';
                }
            }

            for (int i = 0; i < 2*s+3; ++i) {
                for (int j = 0; j < str[1].length(); ++j) {
                    if (str[1].charAt(j) == '1') {
                        for (int z = 0; z < s + 2; ++z) {
                            if (n1[i][z] == null) {
                                System.out.print(" ");
                            } else {
                                System.out.print(n1[i][z]);
                            }
                        }
                        System.out.print(" ");

                    } else if (str[1].charAt(j) == '2'){
                        for (int z = 0; z < s + 2; ++z) {
                            if (n2[i][z] == null) {
                                System.out.print(" ");
                            } else {
                                System.out.print(n2[i][z]);
                            }
                        }
                        System.out.print(" ");

                    } else if (str[1].charAt(j) == '3'){
                        for (int z = 0; z < s + 2; ++z) {
                            if (n3[i][z] == null) {
                                System.out.print(" ");
                            } else {
                                System.out.print(n3[i][z]);
                            }
                        }
                        System.out.print(" ");

                    } else if (str[1].charAt(j) == '4'){
                        for (int z = 0; z < s + 2; ++z) {
                            if (n4[i][z] == null) {
                                System.out.print(" ");
                            } else {
                                System.out.print(n4[i][z]);
                            }
                        }
                        System.out.print(" ");

                    } else if (str[1].charAt(j) == '5'){
                        for (int z = 0; z < s + 2; ++z) {
                            if (n5[i][z] == null) {
                                System.out.print(" ");
                            } else {
                                System.out.print(n5[i][z]);
                            }
                        }
                        System.out.print(" ");

                    } else if (str[1].charAt(j) == '6'){
                        for (int z = 0; z < s + 2; ++z) {
                            if (n6[i][z] == null) {
                                System.out.print(" ");
                            } else {
                                System.out.print(n6[i][z]);
                            }
                        }
                        System.out.print(" ");

                    } else if (str[1].charAt(j) == '7'){
                        for (int z = 0; z < s + 2; ++z) {
                            if (n7[i][z] == null) {
                                System.out.print(" ");
                            } else {
                                System.out.print(n7[i][z]);
                            }
                        }
                        System.out.print(" ");

                    } else if (str[1].charAt(j) == '8'){
                        for (int z = 0; z < s + 2; ++z) {
                            if (n8[i][z] == null) {
                                System.out.print(" ");
                            } else {
                                System.out.print(n8[i][z]);
                            }
                        }
                        System.out.print(" ");

                    } else if (str[1].charAt(j) == '9'){
                        for (int z = 0; z < s + 2; ++z) {
                            if (n9[i][z] == null) {
                                System.out.print(" ");
                            } else {
                                System.out.print(n9[i][z]);
                            }
                        }
                        System.out.print(" ");

                    } else if (str[1].charAt(j) == '0'){
                        for (int z = 0; z < s + 2; ++z) {
                            if (n0[i][z] == null) {
                                System.out.print(" ");
                            } else {
                                System.out.print(n0[i][z]);
                            }
                        }
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Main().solve();
    }
}