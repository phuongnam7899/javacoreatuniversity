package array;

import java.util.Scanner;

public class mineSweeper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.next());
        int n = Integer.parseInt(scanner.next());
        double p = Double.parseDouble(scanner.next());
        boolean[][] mapInited = initMap(m,n,p);
        String[][] createdMap1 = createMap1(mapInited);
        drawMap(createdMap1);
        System.out.println("--------------------");
        String[][] createdMap2 = createMap2(mapInited);
        drawMap(createdMap2);
        System.out.println("--------------------");
        runGame(mapInited);
    }
    private static void runGame(boolean[][] mapInited){
        String[][] map = creatBlankMap(mapInited.length,mapInited[0].length);
        String[][] createdMap2 = createMap2(mapInited);
        Scanner scanner = new Scanner(System.in);
        int mineNumber = countMine(mapInited);
        int mineLeft = mineNumber;
        boolean isWin = true;
        while (true){
            drawMap(map);
            System.out.println("Nhập lựa chọn theo cú pháp : [Option] [X] [Y] ( Trong đó [Option] = 0 để mở ô, = 1 để đánh dấu có mine, [X][Y] là tọa độ)");
            int option = Integer.parseInt(scanner.next());
            int y = Integer.parseInt(scanner.next());
            int x = Integer.parseInt(scanner.next());
            if (x > map.length || x < 1 || y > map[0].length || y < 1){
                System.out.println("Không có ô trên");
            }
            else if (option != 0 && option != 1){
                System.out.println("Option phải là 0 hoặc 1 ");
            }
            else {
                if(option == 0){
                    map[x - 1][y - 1] = createdMap2[x - 1][y -1];
                    if(mapInited[x - 1][y - 1 ]) {
                        System.out.println("Bạn thua do đạp phải mine");
                        break;
                    }
                }
                else if(option == 1){
                    if(map[x - 1][y - 1].compareTo("M") == 0 || map[x - 1][y - 1].compareTo("-") == 0) {
                        if(map[x - 1][y - 1].compareTo("M") != 0 && countElement(map,"M") >= mineNumber) {
                            System.out.println("Bạn đã đạt số lượng đánh dấu giới hạn");
                        }
                        else{
                            map[x - 1][y - 1] = map[x - 1][y - 1].compareTo("M") == 0 ? "-" : "M";
                            if(map[x - 1][y - 1].compareTo("M") == 0 && mapInited[x - 1][y - 1]){
                                mineLeft--;
                            }
                            if (map[x - 1][y - 1].compareTo("-") == 0 && mapInited[x - 1][y - 1]){
                                mineLeft++;
                            }
                            if (mineLeft <= 0){
                                System.out.println("Bạn đã thắng");
                                break;
                            }
                        }
                    }
                    else System.out.println("Ô đã được mở");
                }
            }
        }
    }
    private static boolean[][] initMap(int m,int n,double p){
        boolean[][] map = new boolean[n][m];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                map[i][j] = Math.random() < p ? true : false;
            }
        }
        return map;
    }
    private static int countMine(boolean[][] mapInited){
        int mineNumber = 0;
        for (int i = 0; i < mapInited.length ; i++) {
            for (int j = 0; j < mapInited[0].length ; j++) {
                if (mapInited[i][j]) mineNumber++;
            }
        }
        return mineNumber;
    }
    private static int countElement(String[][] map, String element){
        int count = 0;
        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map[0].length ; j++) {
                if (map[i][j].compareTo(element) == 0) count++;
            }
        }
        return count;
    }
    private static String[][] createMap1(boolean[][] mapInited){
        String[][] map = new String[mapInited[0].length][mapInited.length];
        for (int i = 0; i < mapInited.length ; i++) {
            for (int j = 0; j < mapInited[0].length ; j++) {
                map[i][j] = mapInited[i][j] == true ? "*" : ".";
            }
        }
        return map;
    }
    private static String[][] createMap2(boolean[][] mapInited){
        String[][] map = new String[mapInited[0].length][mapInited.length];
        for (int i = 0; i < mapInited.length ; i++) {
            for (int j = 0; j < mapInited[0].length ; j++) {
                map[i][j] = mapInited[i][j] == true ? "*" : Integer.toString(findNearby(mapInited,i,j));
            }
        }
        return map;
    }
    private static String[][] creatBlankMap(int m,int n){
        String[][] map = new String[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                map[i][j] = "-";
            }
        }
        return  map;
    }
    private static int findNearby(boolean[][] mapInited, int x,int y){
        int count = 0;
        for (int i = x - 1; i < x + 2 ; i++) {
            for (int j = y - 1; j < y + 2 ; j++) {
                if (i < 0 || i >= mapInited.length || j < 0 || j >= mapInited[0].length) continue;
                else {
                    if(mapInited[i][j]) count++;
            }
            }
        }
        return count;
    }
    private static void drawMap(String[][] createdMap){
        for (int i = 0; i < createdMap.length ; i++) {
            for (int j = 0; j < createdMap[0].length ; j++) {
                System.out.print(createdMap[i][j] + " ");
            }
            System.out.println();
        }
    }
}
