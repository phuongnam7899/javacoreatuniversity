package array;

import java.util.Scanner;

public class sort {
    public static void main(String[] args) {
        Scanner nummScanner = new Scanner(System.in);
        int n = Integer.parseInt(nummScanner.nextLine());
        int[] numberList = new int[n];
        for (int i = 0; i < n ; i++) {
            numberList[i] = Integer.parseInt(nummScanner.next());
        }
        quickSort(numberList,0,numberList.length -1);
        for (int i = 0; i < n ; i++) {
            System.out.print(numberList[i] + " ");
        }
    }
    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
        return i+1;
    }
}
