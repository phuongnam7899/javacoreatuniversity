package array;
import java.util.Scanner;
public class maxSum {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        int n = Integer.parseInt(numScanner.nextLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n ; i++) {
            numbers[i] = Integer.parseInt(numScanner.next()); }
        int max = numbers[0];
        for (int i = 0; i < n ; i++) {
            for (int j = i; j < n ; j++) {
                int result = i == j ? numbers[i] : calcArraySum(numbers,i,j);
                max = result > max ? result : max; } }
        System.out.println(max); }
    private static int calcArraySum(int[] numbers, int start, int end) {
        int sum = 0;
        for (int k = start; k < end + 1  ; k++) {
            sum += numbers[k]; }
        return sum; }}
