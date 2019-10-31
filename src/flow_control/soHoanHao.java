package flow_control;

import java.util.Scanner;

public class soHoanHao {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        int numbers = Integer.parseInt(numScanner.nextLine());
        String soHoanHaoString = "";
        for (int i = 0; i < numbers  ; i++) {
            int aNUmber = i;
            int sum = 0;
            for (int j = 0; j < i ; j++) {
                if(j != 0 && aNUmber % j == 0){
                    sum += j;
                }
            }
            if(i != 0 && sum == aNUmber){
                soHoanHaoString += aNUmber;
                soHoanHaoString += " ";
            }
        }
        System.out.println(soHoanHaoString);
    }
}
