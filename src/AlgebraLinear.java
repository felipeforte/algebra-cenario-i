public class AlgebraLinear {
    public Matrix transposeMatrix(Matrix matrix) {
        int lines = matrix.getLinhas();
        int columns = matrix.getColunas();
        int[] vector = new int[lines * columns];
        int indice_vetor = 0;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < lines; j++) {
                vector[indice_vetor] = matrix.get(j + 1, i + 1);
                indice_vetor++;
            }
        }
        return new Matrix(columns, lines, vector);
    }

    public Matrix sumMatrix(Matrix matrixOne, Matrix matrixTwo) {
        int lines = matrixOne.getLinhas();
        int columns = matrixOne.getColunas();
        int[] vector = new int[lines * columns];
        int indice_vetor = 0;
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                vector[indice_vetor] = matrixOne.get(i + 1, j + 1) + matrixTwo.get(i + 1, j + 1);
                indice_vetor++;
            }
        }
        return new Matrix(lines, columns, vector);
    }
}
