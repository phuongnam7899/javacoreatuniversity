package array;

import java.util.Scanner;

public class elementCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = Double.parseDouble(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        double[] numberList = new double[n];
        for (int i = 0; i < n ; i++) {
            numberList[i] = Integer.parseInt(scanner.next());
        }
        for (int i = 0; i < n ; i++) {
            if(numberList[i] == x) counter++;
        }
        System.out.println(counter);
    }
}
