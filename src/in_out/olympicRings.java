package in_out;
import libs.StdDraw;

import java.awt.*;

public class olympicRings {
    public static void main(String[] args) {
        Color[] colorList = {new Color(38, 60, 158),
                new Color(240, 230, 48),
                new Color(0, 0, 0),
                new Color(24, 158, 69),
                new Color(201, 23, 14),
        };
        double positionX = 0.2;
        double positionY = 0.6;
        double r = 0.1;
        double vY = 0.75*r;
        double vX = 1.25*r;
        StdDraw.setPenRadius(0.2*r);
        for (int i = 0; i < 5 ; i++) {
            StdDraw.setPenColor(colorList[i]);
            StdDraw.circle(positionX,positionY,r);
            positionX += vX;
            positionY -= vY;
            vY = -vY;
        }
    }
}
