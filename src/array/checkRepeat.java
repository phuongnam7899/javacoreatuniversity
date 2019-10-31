package array;

import java.util.Scanner;

public class checkRepeat {
    public static void main(String[] args) {
        Scanner numberScanner = new Scanner(System.in);
        int n = Integer.parseInt(numberScanner.nextLine());
        int[] numbersList = new int[n];
        for (int i = 0; i < n ; i++) {
            numbersList[i] = Integer.parseInt(numberScanner.next());
        }
        int[] checked = new int[n];
        int[] repeatNumbers = new int[n];
        int countRepeatNumbers = 0;
        for (int i = 0; i < n; i++) {
            if(elementCount(checked, numbersList[i]) == 0){
                if(elementCount(numbersList,numbersList[i]) > 1){
                    repeatNumbers[countRepeatNumbers] = numbersList[i];
                    countRepeatNumbers++;
                }
            }
            checked[i] = numbersList[i];
        }
        for (int i = 0; i < countRepeatNumbers ; i++) {
            System.out.print(repeatNumbers[i] + " ");
        }
    }
    public static int elementCount (int[] numberList, int number){
        int count = 0;
        for (int i = 0; i < numberList.length ; i++) {
            if (numberList[i] == number) {
                count++;
            }
        }
        return count;
    }
}
