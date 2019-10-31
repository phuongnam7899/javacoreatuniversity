package array;
import java.util.Scanner;
public class robot2D2 {
    public static int moveCounter = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] robotsPosition = new int[n][2];
        int times = 1000;
        boolean[][] map = new boolean[n][n];
        for (int k = 0; k < times ; k++) {
            initPosition(robotsPosition);
            initMap(map);
            while (countTouched(map) < map.length * map[0].length){
                for (int i = 0; i < robotsPosition.length ; i++) {
                    int robotPositionX = robotsPosition[i][0];
                    int robotPositionY = robotsPosition[i][1];
                    move(robotsPosition[i],n);
                    map[robotPositionX][robotPositionY] = true;
                }
            }
        }
        System.out.println(moveCounter/times);
    }
    private static void move(int[] robotPosition,int width){
        double direction = Math.random();
        int previousX = robotPosition[0];
        int previousY = robotPosition[1];
        if (direction < 0.25 && robotPosition[0] < width - 1) robotPosition[0]++;
        else if(direction < 0.5 && robotPosition[0] > 0) robotPosition[0]--;
        else if(direction < 0.75 && robotPosition[1] > 0) robotPosition[1]--;
        else if(direction < 1 && robotPosition[1] < width - 1) robotPosition[1]++;
        if(previousX != robotPosition[0] || previousY != robotPosition[1]) {moveCounter++;
           }
    }
    private static void initPosition(int[][] robotsPosition){
        for (int i = 0; i < robotsPosition.length ; i++) {
            robotsPosition[i][0] = robotsPosition.length/2;
            robotsPosition[i][1] = robotsPosition.length/2;
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
