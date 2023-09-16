import java.util.Arrays;
import java.util.Random;
import java.lang.Math;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Vars
        int firstC = 3;
        int lastC = 15;
        int lenC = lastC - firstC;

        int lenX = 17;
        float minX = -13;
        float maxX = 5;

        int lenFirstMatrixC2 = 12;
        int lenSecondMatrixC2 = 17;

        long condVar = 14;
        int[] condArray = {3, 6, 8, 9, 11, 15};


        // Inits
        Random rand = new Random();
        long[] c = new long[lenC];
        double[] x = new double[lenX];
        double[][] c2 = new double[lenFirstMatrixC2][lenSecondMatrixC2];


        // Filling arrays

        // Заполнение массива "c" числами от 3 до 15 включительно в порядке возрастания
        for (int i = firstC, j = 0; i < lenC; i++, j++) {
            c[j] = i;
        }

        // Заполнение массива "x" 12-ю случайными числами в диапазоне от -13.0 (minX) до 5.0 (maxX).
        for (int i = 0; i < lenX; i++) {
            x[i] = minX + rand.nextDouble()*(minX - maxX);
        }
        System.out.println();
        // main task
        for (int i = 0; i < lenFirstMatrixC2; i++) {
            for (int j = 0; j < lenSecondMatrixC2; j++) {
                if (c[i] == condVar) {
                    c2[i][j] = Math.cbrt(Math.tan(Math.pow(2*x[j],2)));
                } else if (containsValue(condArray, c[i])) {
                    c2[i][j] = Math.log(Math.abs(Math.asin(Math.cos(x[j])))); // ln(|arcsin(cos(x))|);
                } else {
                    c2[i][j] = Math.sin(Math.atan(Math.pow(Math.sin(x[j]),2))); // sin(arctan((sin(x))2))
                }

                System.out.printf("%-5s", (c2[i][j] >= 0 || Double.isNaN(c2[i][j])) ? "      " : "");
                System.out.printf("%-6s  | x = %-6s | c = %-20s", (Double.isNaN(c2[i][j])) ? "Тортик" : (c2[i][j] == 0) ? "0" : String.format("%.4f", c2[i][j]), String.format("%.4f", x[j]), c[i]);
                System.out.printf("%-5s", (c2[i][j] < 0) ? "" : "     ");

            }
            System.out.println();

        }
    }
    /**
     * Checking if value is in an array
     * @param array The array where value will be looked up.
     * @param value The value which will be finding.
     * @return return True if value in array / False if value not in array.
     */
    private static boolean containsValue(int[] array, long value) {
        for (int item : array) {
            if (item == value) {
                return true;
            }
        }
        return false;
    }
}