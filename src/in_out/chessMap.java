package in_out;
import libs.StdDraw;
import libs.StdIn;
import java.awt.*;
public class chessMap {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        double drawPositionX = 0.2;
        double drawPositionY = 0.8;
        double width = 0.6/((double)(n));
        int currentColorCode = 1;
        for (int i = 0; i < n ; i++) {
            int rate = i % 2 == 1 ? 1 : -1;
            for (int j = 0; j < n ; j++) {
                Color currentColor = currentColorCode % 2 == 0 ? Color.RED : Color.BLACK;
                currentColorCode++;
                StdDraw.setPenColor(currentColor);
                StdDraw.filledRectangle(drawPositionX,drawPositionY,width/2,width/2);
                drawPositionX -= (width * rate);
            }
            drawPositionX += (width * rate);
            drawPositionY -= width;

        }
    }
}
