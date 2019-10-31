package array;
import java.util.Scanner;
public class hadamardMatrix {
    public static void main(String[] args) {
        Scanner numScanner = new Scanner(System.in);
        int size = Integer.parseInt(numScanner.nextLine());
        boolean[][] hadamardMatrix = hadamard(size);
        for (int i = 0; i < hadamardMatrix.length ; i++) {
            for (int j = 0; j < hadamardMatrix[i].length ; j++) {
                if(hadamardMatrix[i][j]) System.out.print("T ");
                else System.out.print("F ");
            }
            System.out.println();
        }
    }
    private static boolean[][] hadamard(int size){
        boolean[][] matrix = new boolean[size][size];
        if (size > 1) {
            boolean[][] subMatrix =  hadamard(size / 2);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length ; j++) {
                    if(i < subMatrix.length && j < subMatrix[i].length ) matrix[i][j] = subMatrix[i][j];
                    else if(i < subMatrix.length && j >= subMatrix[0].length ) matrix[i][j] = subMatrix[i][j - subMatrix[0].length];
                    else if(i >= subMatrix.length && j < subMatrix[0].length ) matrix[i][j] = subMatrix[i - subMatrix.length][j];
                    else if(i >= subMatrix.length && j >=  subMatrix[0].length ) matrix[i][j] = !subMatrix[i - subMatrix.length][j - subMatrix[0].length];
                }
            }
        }
        else {
            matrix[size - 1][size - 1] = true;
        }
        return matrix;
    }
}

