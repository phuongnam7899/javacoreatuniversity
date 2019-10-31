package demo;

import java.util.Scanner;

public class scamble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = Integer.parseInt(scanner.next());
        int targetMoney = Integer.parseInt((scanner.next()));
        double win = 0;
        double lose = 0;
        for (int i = 0; i < 1000 ; i++) {
            int moneyPerTurn = money;
            while (moneyPerTurn > 0 && moneyPerTurn < targetMoney){
                moneyPerTurn = Math.random() < 0.5 ? moneyPerTurn + 1 : moneyPerTurn - 1;
            }
            if (moneyPerTurn <= 0) lose++;
            else win++;
        }
        System.out.println("Win rate: " + ((win/(win +lose) * 100)) + " %");
    }
}
