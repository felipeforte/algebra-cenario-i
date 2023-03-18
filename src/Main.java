import Util.ConsoleColors;

public class Main {
    public static void main(String[] args) {
        AlgebraLinear algebra = new AlgebraLinear();

//        int[] m1 = {5, 7, -1, 6, 0, -3};
//        Vector vector1 = new Vector(m1.length, m1);
//        Matrix matrix1 = new Matrix(2, 3, vector1);

//        int[] m2 = {0, 3, -5, 2, 0, 0};
//        Vector vector2 = new Vector(m2.length, m2);
//        Matrix matrix2 = new Matrix(2, 3, vector2);

//        System.out.println(
//                ConsoleColors.GREEN_BACKGROUND_BRIGHT +
//                        ConsoleColors.BLACK_BOLD +
//                        algebra.sumMatrix(matrix1, matrix2).toString("Matriz somada: ")
//        );
//
//        System.out.println(
//                ConsoleColors.YELLOW_BACKGROUND_BRIGHT +
//                ConsoleColors.BLACK_BOLD +
//                        algebra.transposeMatrix(matrix1).toString("Matriz 1 transposta: ")
//        );


//        int[] m1 = {5, 7, -1, 6, 0, -3};
//        Vector vector1 = new Vector(m1.length, m1);
//        Matrix matrix1 = new Matrix(2, 3, vector1);
//
//        int[] m2 = {0, 2, 3, 0, -5, 0};
//        Vector vector2 = new Vector(m2.length, m2);
//        Matrix matrix2 = new Matrix(3, 2, vector2);
//
//        System.out.println(
//                ConsoleColors.GREEN_BACKGROUND_BRIGHT +
//                        ConsoleColors.BLACK_BOLD +
//                        algebra.timesMatrix(2, matrix2).toString("Matriz multiplicada: ")
//        );

        int[] m1 = {
                1, 1, 1, 1,
                4, 4, 2, 2,
                2, 1, -1, 0
        };
        Vector vector1 = new Vector(m1.length, m1);
        Matrix matrix1 = new Matrix(3, 4, vector1);

        System.out.println(
                ConsoleColors.GREEN_BACKGROUND_BRIGHT +
                        ConsoleColors.BLACK_BOLD +
                        algebra.gauss(matrix1).toString("Matriz 1: ")
        );
    }
}
