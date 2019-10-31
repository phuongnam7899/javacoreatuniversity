package recursion;

import libs.StdAudio;
import libs.StdDraw;

import java.awt.*;
import java.util.Scanner;

public class towerOfHanoi {
    public static int count;
    public static int[][] columns;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        columns = new int[3][n];
        initColumns(columns);
        draw();
        move(n,columns[0],columns[2],columns[1]);
    }
    private static void draw() {
        StdDraw.clear();
        drawTitle();
        drawInfo();
        drawStep();
//        drawButton();
        drawColumns();
        drawRings();
    }

//    private static void drawButton() {
//        Color buttonColor = new Color(69, 212, 47);
//        StdDraw.setPenColor(buttonColor);
//        StdDraw.setPenRadius(0.006);
//        StdDraw.rectangle(0.6,0.6667,0.05,0.025);
//        StdDraw.setPenRadius();
//        StdDraw.setPenColor(Color.BLACK);
//        Font nameFont = new Font("Arial", Font.PLAIN, 14);
//        StdDraw.setFont(nameFont);
//        StdDraw.text(0.6,0.6667,"Pause");
//    }

    private static void drawInfo() {
        StdDraw.setPenColor(Color.BLACK);
        Font nameFont = new Font("Arial", Font.ITALIC, 20);
        StdDraw.setFont(nameFont);
        StdDraw.text(0.2, 0.95, "Nguyen Phuong Nam");
        StdDraw.text(0.6, 0.95, "IT-LTU 17A");
        StdDraw.text(0.9, 0.95, "20187266");
    }

    private static void drawTitle() {
        int R = (int)(Math.random() * 256);
        int G = (int)(Math.random() * 256);
        int B = (int)(Math.random() * 256);
        Color textColor = new Color(R, G, B);
        StdDraw.setPenColor(textColor);
        Font titleFont = new Font("Arial", Font.BOLD, 40);
        StdDraw.setFont(titleFont);
        StdDraw.text(0.5, 0.8, "TOWER OF HANOI");
    }

    private static void drawStep(){
        Font font = new Font("Arial", Font.PLAIN, 26);
        StdDraw.setFont(font);
        StdDraw.setPenColor(Color.DARK_GRAY);
        String displayStep = "Step : " + Integer.toString(count) ;
        StdDraw.text(0.4,0.66,displayStep);
    }
    private static void drawColumns(){
        double columnY = 0.35;
        double columnX = 0.2;
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 1; i < 4;i++){
            StdDraw.filledRectangle(columnX,columnY,0.01,0.25);
            StdDraw.filledRectangle(columnX,columnY - 0.25,0.12,0.006);
            columnX += 0.3;
        }
    }
    private static void drawRings() {
        double minWidth = 0.03;
        double maxWidth = 0.3;
        double ringX = 0.2;
        for (int i = 0; i < columns.length ; i++) {
            double ringY = 0.1 + 0.033;
            for (int j = 0; j < columns[i].length ; j++) {
                if(columns[i][j] != 0) {
                    StdDraw.setPenColor(StdDraw.CYAN);
                    StdDraw.filledRectangle(ringX, ringY, ((maxWidth - minWidth) / 2 / columns[i].length) * columns[i][j], 0.025);
                    StdDraw.setPenColor(StdDraw.BOOK_BLUE);
                    StdDraw.setPenRadius(0.008);
                    StdDraw.rectangle(ringX, ringY, ((maxWidth - minWidth) / 2 / columns[i].length) * columns[i][j], 0.025);
                    StdDraw.setPenRadius();
                    ringY += 0.055;
                }
            }
            ringX += 0.3;
        }
        if(StdDraw.isKeyPressed(32)){
            StdDraw.show(200);
        }
        else StdDraw.show(2000);

    }
    private static void initColumns(int[][] columns) {
        for (int i = 0; i < columns[0].length ; i++) {
            columns[0][i] = columns[0].length - i;
        }
    }
    private static void move(int ringNumber, int[] startColumn, int[] endColumn, int[] tempColumn) {
        if(ringNumber == 1){
            move(startColumn,endColumn);
            return;
        }
        move(ringNumber - 1,startColumn,tempColumn,endColumn);
        move(startColumn,endColumn);
        move(ringNumber - 1,tempColumn,endColumn,startColumn);
    }
    private  static  void  move(int[] startColumn,int[] endColumn) {
        int[] startTop = findTop(startColumn);
        int[] endTop = findTop(endColumn);
        if (endTop[1] == 0) endTop[0]--;
        endColumn[endTop[0] + 1] = startTop[1];
        startColumn[startTop[0]] = 0;
        count++;
        draw();
    }
    private static int[] findTop(int[] column) {
        int topValue = 0;
        int topIndex = 0;
        for (int i = 0; i < column.length ; i++) {
            if(i == column.length - 1){
                topValue = column[i];
                topIndex = i;
            }
            else if(column[i + 1] < 1){
                topValue = column[i];
                topIndex = i;
                break;
            }
        }
        int[] top = {topIndex,topValue};
        return top;
    }
}
