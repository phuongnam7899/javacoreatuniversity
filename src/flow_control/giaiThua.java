package flow_control;

import java.util.Scanner;

public class giaiThua {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        int number = Integer.parseInt(numScanner.nextLine());
        int giaiThua = 1;
        if(number != 0){
            for (int i = 2; i < number + 1 ; i++) {
                giaiThua *= i;
            }
        }
        System.out.println(giaiThua);
    }
}
