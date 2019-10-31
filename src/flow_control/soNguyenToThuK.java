package flow_control;

import java.util.Scanner;

public class soNguyenToThuK {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        int n = Integer.parseInt(numScanner.next());
        int k = Integer.parseInt(numScanner.next());
        boolean result = false;
        if(k <= n){
            int count = 0;
            int max = 0;
            for (int i = 2; i < n + 1; i++) {
                    boolean isSnt = true;
                    for (int j = 2; j < i - 1  ; j++) {
                        if(i % j == 0){
                            isSnt = false;
                            break;
                        }
                    }
                    if (isSnt == true) {
                        count++;
                        max = i;
                    }
            }
            if(count == k && max == n) result = true;
        }
        if(result == true) System.out.println("OK");
        else System.out.println("KO");
    }
}
