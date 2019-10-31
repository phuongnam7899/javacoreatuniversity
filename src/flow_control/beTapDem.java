package flow_control;

import java.util.Scanner;
public class beTapDem {
    public static void main(String[] args){
        Scanner numScanner = new Scanner(System.in);
        int num1 = Integer.parseInt(numScanner.next());
        int num2 = Integer.parseInt(numScanner.next());
        System.out.println(excessTimeCount(num1,num2));
    }
    public static int excessTimeCount(int num1,int num2){
        int[] numbersListOfNumber1 = getNumbersListOfNumber(num1);
        int[] numbersListOfNumber2 = getNumbersListOfNumber(num2);
        int excessTimesCounter = 0;
        int excess = 0;
        int[] evaluateList = numbersListOfNumber1.length < numbersListOfNumber2.length ? numbersListOfNumber1 : numbersListOfNumber2;
        for (int i = 0; i < evaluateList.length ; i++) {
            if (numbersListOfNumber1[i] + numbersListOfNumber2[i] + excess > 9) {
                excessTimesCounter++;
                if (excess < 1) excess++;
            }
        }
        return excessTimesCounter;
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
