package in_out;

import libs.StdDraw;

import java.awt.*;
import java.util.Scanner;

public class robot2D4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] robotsStep = new int[n][2];
        double mapWidth = n;
        double r = mapWidth/n;
        drawMap(mapWidth);
        double initPositionX = mapWidth;
        double initPositionY = mapWidth;
        Color[] robotsColor = new Color[n];
        for (int i = 0; i < n ; i++) {
            int R = (int)(Math.random() * 256);
            int G = (int)(Math.random() * 256);
            int B = (int)(Math.random() * 256);
            robotsColor[i] = new Color(R, G, B);
        }
        boolean[][] map = new boolean[n][n];
            initPosition(robotsStep);
            initMap(map);
            while (countTouched(map) < map.length * map[0].length){
                for (int i = 0; i < robotsStep.length ; i++) {
                    StdDraw.setPenColor(Color.BLACK);
                    StdDraw.filledSquare(initPositionX + robotsStep[i][0] * 2 * r + r,initPositionY + robotsStep[i][1] * 2 * r + r,r);
                    int robotStepX = robotsStep[i][0];
                    int robotStepY = robotsStep[i][1];
                    move(robotsStep[i],n);
                    System.out.println((robotStepX + n/2) + " - " + (robotStepY + n/2));
                    map[robotStepX + n/2][robotStepY + n/2] = true;
                    StdDraw.setPenColor(robotsColor[i]);
                    StdDraw.filledSquare(initPositionX + robotsStep[i][0] * 2 * r + r,initPositionY + robotsStep[i][1] * 2 * r + r,r);
                }
            }
        }
    private static void drawMap(double w){
        StdDraw.setYscale(0,2*w);
        StdDraw.setXscale(0,2*w);
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.filledSquare(w,w,w);
    }
    private static void move(int[] robotPosition,int width){
        double direction = Math.random();
        if (direction < 0.25 && robotPosition[0] < width/2 - 1) robotPosition[0]++;
        else if(direction < 0.5 && robotPosition[0] > -width/2) robotPosition[0]--;
        else if(direction < 0.75 && robotPosition[1] > -width/2) robotPosition[1]--;
        else if(direction < 1 && robotPosition[1] < width/2 - 1) robotPosition[1]++;
    }
    private static void initPosition(int[][] robotsPosition){
        for (int i = 0; i < robotsPosition.length ; i++) {
            robotsPosition[i][0] = 0;
            robotsPosition[i][1] = 0;
        }
    }
    private static void initMap(boolean[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length ; j++) {
                map[i][j] = false;
            }
        }
        map[map.length/2][map.length/2] = true;
    }
    private static int countTouched(boolean[][] map){
        int count = 0;
        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map[0].length ; j++) {
                if(map[i][j]) count++;
            }
        }
        return count;
    }
}
