package flow_control;

import java.util.Scanner;

public class tongChan {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        int number = Integer.parseInt(numScanner.nextLine());
        int soDau = 2;
        int soCuoi = 0;
        if(number % 2 == 0){
            soCuoi = number;
        }
        else {
            soCuoi = number - 1;
        }
        int soSoHang = (soCuoi - soDau)/2 + 1;
        int tong = (soCuoi + soDau) * soSoHang / 2;
        System.out.println(tong);
    }
}
