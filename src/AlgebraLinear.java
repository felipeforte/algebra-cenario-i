public class AlgebraLinear {
    public Matrix transposeMatrix(Matrix matrix) {
        int rows = matrix.getLines();
        int columns = matrix.getColumns();

        Vector vector = new Vector(rows * columns, new int[rows * columns]);

        int indice_vetor = 0;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                vector.set(indice_vetor, matrix.get(j, i));
                indice_vetor++;
            }
        }

        return new Matrix(columns, rows, vector);
    }

    public Matrix sumMatrix(Matrix matrixOne, Matrix matrixTwo) {
        int rows = matrixOne.getLines();
        int columns = matrixOne.getColumns();

        Vector vector = new Vector(rows * columns, new int[rows * columns]);

        int indice_vetor = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int sum = matrixOne.get(i, j) + matrixTwo.get(i, j);
                vector.set(indice_vetor, sum);
                indice_vetor++;
            }
        }

        return new Matrix(rows, columns, vector);
    }

    public Matrix timesMatrix(Matrix matrixOne, Matrix matrixTwo) {
        int rows = matrixOne.getLines();
        int columns = matrixTwo.getColumns();

        Vector vector = new Vector(rows * columns, new int[rows * columns]);

        int indice_vetor = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int sum = 0;
                for (int k = 0; k < matrixOne.getColumns(); k++) {
                    sum += matrixOne.get(i, k) * matrixTwo.get(k, j);
                }
                vector.set(indice_vetor, sum);
                indice_vetor++;
            }
        }

        return new Matrix(rows, columns, vector);
    }

    public Matrix timesMatrix(int scalar, Matrix matrix) {
        int rows = matrix.getLines();
        int columns = matrix.getColumns();

        Vector vector = new Vector(rows * columns, new int[rows * columns]);

        int indice_vetor = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int sum = matrix.get(i, j) * scalar;
                vector.set(indice_vetor, sum);
                indice_vetor++;
            }
        }

        return new Matrix(rows, columns, vector);
    }

    //metodo gauss jordan para eliminacao gaussiana de uma matriz
    public Matrix gaussJordan(Matrix matrix) {
        int rows = matrix.getLines();
        int columns = matrix.getColumns();

        for (int i = 0; i < rows; i++) {
            // find pivot and swap
            int max = i;
            for (int j = i + 1; j < rows; j++) {
                if (Math.abs(matrix.get(j, i)) > Math.abs(matrix.get(max, i))) {
                    max = j;
                }
            }

            Matrix temp = new Matrix(1, columns, new Vector(columns, matrix.getLine(max)));
            matrix.setLine(max, matrix.getLine(i));
            matrix.setLine(i, temp.getLine(0));

            // reduce the row
            for (int j = i + 1; j < rows; j++) {
                int f = matrix.get(j, i) / matrix.get(i, i);
                for (int k = i + 1; k < columns; k++) {
                    matrix.set(j, k, matrix.get(j, k) - matrix.get(i, k) * f);
                }
                matrix.set(j, i, 0);
            }

        }

        //back substitution
        for (int i = rows - 1; i >= 0; i--) {
            int f = matrix.get(i, i);
            for (int j = i + 1; j < columns - 1; j++) {
                matrix.set(i, j, matrix.get(i, j) / f);
            }
            matrix.set(i, i, 1);

            for (int j = i - 1; j >= 0; j--) {
                f = matrix.get(j, i);
                for (int k = i + 1; k < columns; k++) {
                    matrix.set(j, k, matrix.get(j, k) - matrix.get(i, k) * f);
                }
                matrix.set(j, i, 0);
            }
        }

        // normalize diagonal
        for (int i = 0; i < rows; i++) {
            int f = matrix.get(i, i);
            for (int j = 0; j < columns; j++) {
                matrix.set(i, j, matrix.get(i, j) / f);
            }
        }

        return matrix;
    }

//    Um método chamado gauss que tem como função realizar a eliminação gaussiana em uma
//    Matriz. O método deve receber como parâmetro um objeto da classe Matrix e retornar a
//    Matrix resultante da operação de eliminação gaussiana.
    public Matrix gauss(Matrix matrix) {
        int rows = matrix.getLines();
        int columns = matrix.getColumns();

        for (int i = 0; i < rows; i++) {
            // find pivot and swap
            int max = i;
            for (int j = i + 1; j < rows; j++) {
                if (Math.abs(matrix.get(j, i)) > Math.abs(matrix.get(max, i))) {
                    max = j;
                }
            }

            Matrix temp = new Matrix(1, columns, new Vector(columns, matrix.getLine(max)));
            matrix.setLine(max, matrix.getLine(i));
            matrix.setLine(i, temp.getLine(0));

            // reduce the row
            for (int j = i + 1; j < rows; j++) {
                int f = matrix.get(j, i) / matrix.get(i, i);
                for (int k = i + 1; k < columns; k++) {
                    matrix.set(j, k, matrix.get(j, k) - matrix.get(i, k) * f);
                }
                matrix.set(j, i, 0);
            }

        }

        return matrix;
    }


//    Um método chamado solve que tem como função um sistema de equação linear. O método
//    deve receber como parâmetro um objeto da classe Matrix (que representa uma matriz
//            aumentada) e retornar a Matrix resultante da resolução do sistema linear.
    public Matrix solve(Matrix matrix) {
        int rows = matrix.getLines();
        int columns = matrix.getColumns();

        Matrix matrixA = new Matrix(rows, columns - 1, new Vector(rows * (columns - 1), new int[rows * (columns - 1)]));
        Matrix matrixB = new Matrix(rows, 1, new Vector(rows, new int[rows]));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns - 1; j++) {
                matrixA.set(i, j, matrix.get(i, j));
            }
            matrixB.set(i, 0, matrix.get(i, columns - 1));
        }

        Matrix matrixAInverse = gaussJordan(matrixA);

        return timesMatrix(matrixAInverse, matrixB);
    }
}
