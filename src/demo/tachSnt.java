package demo;

import java.util.Scanner;

public class tachSnt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.next());
        while (number  > 1){
            for (int i = 2; i < number + 1 ; i++) {
                if(number % i == 0){
                    System.out.print(i + " ");
                    number /= i;
                }
            }
        }
    }
}
