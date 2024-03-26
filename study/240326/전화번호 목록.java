//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;

//    private void solve() {
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

import java.util.HashMap;

public class Main {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> prefix = new HashMap<>();

        for (int i = 0; i < phone_book.length; ++i) {
            prefix.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; ++i) {
            for (int j = 0; j < phone_book[i].length(); ++j) {
                if (prefix.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }

        return  answer;
    }

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        new Main().solution(phone_book);
    }
}