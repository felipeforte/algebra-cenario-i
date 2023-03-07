public class Main {
    public static void main(String[] args) {
        int[] array = {9, 7, 8, 6, 5, 3};
        Matrix matriz = new Matrix(3,2,array);
        System.out.println(matriz.get(1,1));
    }
}
