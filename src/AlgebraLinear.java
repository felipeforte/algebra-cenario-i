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

    //escalar * matrix
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

    // matrix * matrix
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
                int divisor = result.get(line, line);
                int factor = result.get(i, line) /  (divisor == 0 ? 1 : divisor);
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

    public Matrix gauss2(Matrix a) {

        int n = a.getRows();
        int m = a.getCols();

        // Faz a eliminação gaussiana
        for (int i = 0; i < n; i++) {
            int pivotRow = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(a.get(j, i)) > Math.abs(a.get(pivotRow, i))) {
                    pivotRow = j;
                }
            }
            if (pivotRow != i) {
                a.swapRows(i, pivotRow);
            }

            for (int j = i + 1; j < m; j++) {
                a.set(i, j, a.get(i, j) / a.get(i, i));
            }
            a.set(i, i, 1);

            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < m; k++) {
                    a.set(j, k, a.get(j, k) - a.get(j, i) * a.get(i, k));
                }
                a.set(j, i, 0);
            }
        }

        // Faz a retrosubstituição
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = m - 2; k > i; k--) {
                    a.set(j, m - 1, a.get(j, m - 1) - a.get(j, k) * a.get(k, m - 1));
                    a.set(j, k, 0);
                }
            }
        }

        return a;
    }

    public Matrix solve(Matrix a) {
        a = gauss2(a);

        // Definir a matriz aumentada
        double[][] matriz = {{1, 2, 4, 0},
                {0, 1, 2, 9},
                {0, 0, 1, 3}};

        // Aplicar o algoritmo de Gauss-Jordan
        for (int k = 0; k < 3; k++) {
            double pivo = matriz[k][k];
            for (int j = k; j < 4; j++) {
                matriz[k][j] /= pivo;
            }
            for (int i = 0; i < 3; i++) {
                if (i != k) {
                    double fator = matriz[i][k];
                    for (int j = k; j < 4; j++) {
                        matriz[i][j] -= fator * matriz[k][j];
                    }
                }
            }
        }

        // Exibir o resultado
        System.out.println("x = " + matriz[0][3]);
        System.out.println("y = " + matriz[1][3]);
        System.out.println("z = " + matriz[2][3]);

        return a;
    }

}
