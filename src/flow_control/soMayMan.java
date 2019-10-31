package flow_control;

import java.util.Scanner;

public class soMayMan {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        int m = Integer.parseInt(numScanner.next());
        int n = Integer.parseInt(numScanner.next());
        int count = 0;
        for (int k = m - n ; k < m + 1 ; k++) {
            int[] numbersListOfNUmber = getNumbersListOfNumber(k);
            boolean isLucky = true;
            if(numbersListOfNUmber.length > 1){
                for (int i = 1; i < numbersListOfNUmber.length ; i++) {
                    if (numbersListOfNUmber[i] != numbersListOfNUmber[0]) {
                        isLucky = false;
                        break;
                    }
                }
            }
            if (isLucky) count++;
        }
        System.out.println(count);
    }
    public static int[] getNumbersListOfNumber(double number){
        int numberOfNumber = getNumberofNumber(number);
        int[] numbersListOfNumber = new int[numberOfNumber];
        for (int i = 0; i < numberOfNumber; i++) {
            numbersListOfNumber[i] = (int)(number % 10);
            number = Math.floor(number/10);
        }
        return numbersListOfNumber;
    }
    public static int getNumberofNumber(double number){
        int numberOfNumber = 0;
        for (;number > 0;) {
            number = Math.floor(number/10);
            numberOfNumber++;
        }
        return numberOfNumber;
    }
}
