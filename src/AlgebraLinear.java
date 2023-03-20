public class AlgebraLinear {
    public Matrix transpose(Matrix a) {
        int rows = a.getCols();
        int cols = a.getRows();
        int[][] elements = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                elements[i][j] = a.get(j, i);
            }
        }

        return new Matrix(rows, cols, elements);
    }

    public Matrix sum(Matrix a, Matrix b) {
        int rows = a.getRows();
        int cols = a.getCols();
        int[][] elements = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                elements[i][j] = a.get(i, j) + b.get(i, j);
            }
        }

        return new Matrix(rows, cols, elements);
    }

    public Matrix times(int a, Matrix b) {
        int rows = b.getRows();
        int cols = b.getCols();
        int[][] elements = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                elements[i][j] = a * b.get(i, j);
            }
        }

        return new Matrix(rows, cols, elements);
    }

    public Matrix times(Matrix a, Matrix b) {
        int rows = a.getRows();
        int cols = a.getCols();
        int[][] elements = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                elements[i][j] = a.get(i, j) * b.get(i, j);
            }
        }

        return new Matrix(rows, cols, elements);
    }

    public Matrix dot(Matrix a, Matrix b) {
        //validate matrix dimensions
        if (a.getCols() != b.getRows()) {
            throw new IllegalArgumentException("Matrix dimensions must agree.");
        }

        int rows = a.getRows();
        int cols = b.getCols();
        int[][] elements = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                for (int k = 0; k < a.getCols(); k++) {
                    sum += a.get(i, k) * b.get(k, j);
                }
                elements[i][j] = sum;
            }
        }

        return new Matrix(rows, cols, elements);
    }

    public Matrix gauss(Matrix matrix) {
        int numRows = matrix.getRows();
        int numCols = matrix.getCols();

        Matrix result = new Matrix(numRows, numCols, matrix.getElements());

        // verifica se a matriz possui linhas com os coeficientes iguais a zero
        for (int i = 0; i < numRows; i++) {
            boolean allZeros = true;
            for (int j = 0; j < numCols - 1; j++) {
                if (result.get(i, j) != 0) {
                    allZeros = false;
                    break;
                }
            }
            if (allZeros) {
                throw new IllegalArgumentException("Sistema impossível. Matrix contém uma impossibilidade.");
            }
        }

        // Realiza a eliminação gaussiana
        for (int line = 0; line < numRows; line++) {
            // Encontra o pivô da coluna
            int max = result.get(line, line);
            int maxRow = line;
            for (int cols = line + 1; cols < numRows; cols++) {
                int abs = result.get(line, cols);
                if (abs > max) {
                    max = abs;
                    maxRow = cols;
                }
            }

            // Troca as linhas k e maxRow
            if (maxRow != line) {
                for (int j = 0; j < numRows; j++) {
                    int temp = result.get(line, j);
                    result.set(line, j, result.get(maxRow, j));
                    result.set(maxRow, j, temp);
                }
            }

            // Zera os elementos abaixo do pivô
            for (int i = line + 1; i < numRows; i++) {
                int factor = result.get(i, line) / result.get(line, line);
                result.set(i, line, 0);
                for (int j = line + 1; j < numCols; j++) {
                    result.set(i, j, result.get(i, j) - factor * result.get(line, j));
                }
            }

            // converte numeros negativos em positivos
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < numCols; j++) {
                    if (result.get(i, j) < 0) {
                        result.set(i, j, result.get(i, j) * -1);
                    }
                }
            }
        }

        return result;
    }
}
