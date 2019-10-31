package flow_control;

import java.util.Scanner;

public class robot2D {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        int n = Integer.parseInt(numScanner.next());
        int moveSum = 0;
        for (int i = 0; i < 1000 ; i++) {
            int positionX = n;
            int positionY = n;
            int moveCounter = 0;
            while (positionX != 2*n && positionX != 1 && positionY != 2*n && positionY != 1){
                double randomDirection = Math.random();
                if(randomDirection < 0.25) positionX++;
                else if(randomDirection < 0.5) positionX--;
                else if(randomDirection < 0.75) positionY++;
                else positionY--;
                moveCounter++;
            }
            moveSum += moveCounter;
        }
        System.out.println(moveSum/1000);
    }
}
