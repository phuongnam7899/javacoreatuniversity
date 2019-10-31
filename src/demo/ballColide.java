package demo;

import libs.StdDraw;

import java.awt.*;

public class ballColide {
    public static void main(String[] args) {
        double[] position1 = {0.2,0.2};
        double[] velocity1 = {0.01,0};
        double r1 = 0.02;
        double[] position2 = {0.8,0.2};
        double[] velocity2 = {-0.01,0};
        StdDraw.setPenColor(Color.GRAY);
        double r2 = 0.02;
        while (true){
            render(position1,r1,position2,r2);
            run(position1,velocity1,position2,velocity2);
            if (isColide(position1,r1,position2,r2)){
                System.out.println("bong");
            }
        }
    }
    private static void render(double[] position1,double r1,double[] position2,double r2){
        StdDraw.clear();
        StdDraw.circle(position1[0],position1[1],r1);
        StdDraw.circle(position2[0],position2[1],r2);
        StdDraw.show(500);
    }
    private static void run(double[] position1,double[] velocity1,double[] position2,double[] velocity2){
        position1[0] += velocity1[0];
        position1[1] += velocity1[1];
        position2[0] += velocity2[0];
        position2[0] += velocity2[1];
    }
    private static boolean isColide(double[] position1,double r1,double[] position2,double r2){
            return position1[0] + r1 > position2[0] - r2 && position1[0] - r1 < position2[0] + r2 && position1[1] + r1 > position2[1] - r2 && position1[1] + r1> position2[1] - r2;
    }
}
