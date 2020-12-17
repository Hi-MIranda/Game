package s;
import java.util.Scanner;
public class hw2d {
    public static double[][] multiplyMatrix (double[][] a, double[][] b) {
        int len = b.length;
        int row = a.length;
        int col = b[0].length;
        double[][] c = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                double res = 0;
                for (int k = 0; k < len; k++) {
                    res += a[i][k] * b[k][j];
                }
                c[i][j] = res;
            }
        }
        return c;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Matrix1: ");
        String[] line1 = sc.nextLine().split(" ");
        double[][] a = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = Double.parseDouble(line1[i * 3 + j]);
            }
        }
        System.out.print("Enter Matrix2: ");
        String[] line2 = sc.nextLine().split(" ");
        double[][] b = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j] = Double.parseDouble(line2[i * 3 + j]);
            }
        }
        sc.close();
        double[][] c = multiplyMatrix(a, b);
        System.out.println("The result of Matrix a multipled by Matrix b is: ");
        String res = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++){
                res += String.format("%.1f", c[i][j]) + " ";
            }
            res += String.format("%.1f", c[i][2]) + "\n";
        }
        System.out.println(res);
    }
}