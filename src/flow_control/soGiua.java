package flow_control;
import java.util.Scanner;
public class soGiua {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        int n = Integer.parseInt(numScanner.nextLine());
        int[] numbers = new int[n];
        for (int i = 0; i < 5 ; i++) {
            numbers[i] = Integer.parseInt(numScanner.next());
        }
        for (int i = 0; i < numbers.length ; i++) {
            for (int j = 1; j < i ; j++) {
                if (numbers[j] > numbers[i]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.println(numbers[numbers.length/2]);
    }
}
