package demo;

import libs.StdDraw;

import java.awt.*;
import java.util.Scanner;

public class stupidDog {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        int n = Integer.parseInt(numScanner.next());
        double mapWidth = 2*n;
        StdDraw.setCanvasSize(600,600);
        drawMap(mapWidth);
        double initPositionX = mapWidth;
        double initPositionY = mapWidth;
        int stepX = 0;
        int stepY = 0;
        boolean isDead = false;
        int delayTime = 100;
        double r = mapWidth/n/2;
        while (stepX <= n && stepX >= -n && stepY <= n && stepY >= -n && !isDead){
//            if()
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.filledSquare(initPositionX + stepX * 2 * r,initPositionY + stepY * 2 * r,r);
            int[] newStep = getNewStep(stepX,stepY);
            stepX = newStep[0];
            stepY = newStep[1];
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.filledSquare(initPositionX + stepX * 2 * r,initPositionY + stepY * 2 * r,r);
//            StdDraw.show(delayTime);
        }
    }
    private static void drawMap(double w){
        StdDraw.setYscale(0,2*w);

        StdDraw.setXscale(0,2*w);
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.filledSquare(w,w,w);
    }
    private static int[] getNewStep(int stepX,int stepY){
        double randomDirection = Math.random();
        if(randomDirection < 0.25) stepX++;
        else if(randomDirection < 0.5) stepX--;
        else if(randomDirection < 0.75) stepY++;
        else stepY--;
        int[] newStep = {stepX,stepY};
        return newStep;
    }
}
