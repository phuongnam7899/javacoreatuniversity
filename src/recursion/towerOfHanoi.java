package recursion;
import libs.StdAudio;
import libs.StdDraw;
import java.awt.*;
import java.util.Scanner;

// NOTE:
// Nhập số vòng sau khi chạy chương trình
// Giữ phím Space để tăng tốc độ sắp xếp


public class towerOfHanoi {
    private static double columnY = 0.35;
    private static double columnX = 0.2;
    private static double columnWidth = 0.02;
    private static double columnHeight = 0.5;
    private static double baseWidth = 0.24;
    private static double baseHeight = 0.012;
    private static int count;
    private static int ringNumber;
    private static int[][] columns;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ringNumber = scanner.nextInt();
        columns = new int[3][ringNumber];
        initColumns(columns);
        draw();
        move(ringNumber,columns[0],columns[2],columns[1]);
    }
    private static void draw() {
        StdDraw.clear();
        drawTitle();
        drawInfo();
        drawStep();
        drawColumns();
        drawRings();
    }

    //Vẽ lên thông tin sinh viên
    private static void drawInfo() {
        StdDraw.setPenColor(Color.BLACK);
        Font nameFont = new Font("Arial", Font.ITALIC, 20);
        StdDraw.setFont(nameFont);
        StdDraw.text(0.2, 0.95, "Nguyen Phuong Nam");
        StdDraw.text(0.6, 0.95, "IT-LTU 17A");
        StdDraw.text(0.9, 0.95, "20187266");
    }

    //Vẽ lên tiêu đề
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

    //Vẽ lên số bước đã thực hiện
    private static void drawStep(){
        Font font = new Font("Arial", Font.PLAIN, 26);
        StdDraw.setFont(font);
        StdDraw.setPenColor(Color.DARK_GRAY);
        String displayStep = "Step : " + Integer.toString(count) ;
        StdDraw.text(0.5,0.66,displayStep);
    }

    //Vẽ lên 3 cột và các chân cột
    private static void drawColumns(){
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 1; i < 4;i++){
            StdDraw.filledRectangle(columnX,columnY,columnWidth/2,columnHeight/2);
            StdDraw.filledRectangle(columnX,columnY - 0.25,baseWidth/2,baseHeight/2);
            columnX += 0.3;
        }
        columnX -= 0.3 * 3;
    }

    //Vẽ lên các vòng ở mỗi cột, kích thước vòng được tự điều chỉnh dựa trên số vòng để không bị tràn ra ngoài
    private static void drawRings() {
        double minWidth = columnWidth + 0.02;
        double maxWidth = baseWidth + 0.1;
        double maxHeight = 0.05;
        double ringHeight = Math.min((columnHeight / ringNumber), maxHeight);
        double ringX = 0.2;
        double widthStep = (maxWidth - minWidth)/ringNumber;
        for (int i = 0; i < columns.length ; i++) {
            double ringY = 0.1 + 0.03;
            for (int j = 0; j < columns[i].length ; j++) {
                if(columns[i][j] != 0) {
                    StdDraw.setPenColor(StdDraw.CYAN);
                    StdDraw.filledRectangle(ringX, ringY,(minWidth + (columns[i][j] - 1) * widthStep)/2, ringHeight/2);
                    //vẽ viền cho vòng
                    StdDraw.setPenColor(StdDraw.BOOK_BLUE);
                    double penRadius = Math.min((0.008 * ((columnHeight / ringNumber) / maxHeight)), 0.008);
                    StdDraw.setPenRadius(penRadius);
                    StdDraw.rectangle(ringX, ringY,(minWidth + (columns[i][j] - 1) * widthStep)/2, ringHeight/2);
                    StdDraw.setPenRadius();
                    ringY += ringHeight;
                }

            }
            ringX += 0.3;

        }
        //Xử lí việc tăng tốc độ thực hiện khi giữ phím Space
        if(StdDraw.isKeyPressed(32)){
            StdDraw.show(100);
        }
        else StdDraw.show(500);

    }

    //Khởi tạo giá trị các cột ban đầu
    private static void initColumns(int[][] columns) {
        for (int i = 0; i < columns[0].length ; i++) {
            columns[0][i] = columns[0].length - i;
        }
    }

    //Thực hiện việc xếp các vòng
    private static void move(int ringNumber, int[] startColumn, int[] endColumn, int[] tempColumn) {
        if(ringNumber == 1){
            move(startColumn,endColumn);
            return;
        }
        move(ringNumber - 1,startColumn,tempColumn,endColumn);
        move(startColumn,endColumn);
        move(ringNumber - 1,tempColumn,endColumn,startColumn);
    }

    //Chuyển vòng trên cùng của cột cần chuyển về cột đích khi số vòng cần chuyển chỉ là 1
    private  static  void  move(int[] startColumn,int[] endColumn) {
        int[] startTop = findTop(startColumn);
        int[] endTop = findTop(endColumn);
        if (endTop[1] == 0) endTop[0]--;
        endColumn[endTop[0] + 1] = startTop[1];
        startColumn[startTop[0]] = 0;
        count++;
        draw();
    }

    //Tìm giá trị và vị trí của vòng trên cùng của cột
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
