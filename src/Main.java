public class Main {
    public static void main(String[] args) {
        AlgebraLinear algebra = new AlgebraLinear();
        int[] m1 = {5, 7, -1, 6, 0, -3, -4, 3, 0};
        int[] m2 = {0, 3, -5, 2, 0, 0, -1, -5, 3};
        Matrix matrix1 = new Matrix(3, 3, m1);
        Matrix matrix2 = new Matrix(3, 3, m2);
        System.out.println(algebra.sumMatrix(matrix1, matrix2));
//        System.out.println(matrix.get(1,1));
    }
}
