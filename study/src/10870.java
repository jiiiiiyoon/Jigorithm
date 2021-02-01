import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int Fibonacci(int n){
	  
    if(n==0) {
    return 0;
    }
    if(n==1) {
     return 1;
    }
    
    return  Fibonacci(n-1)+Fibonacci(n-2);
};
    private void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            
            int n = Integer.parseInt(br.readLine());

            System.out.println(Fibonacci(n));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Main().solve();
    }
    
}
