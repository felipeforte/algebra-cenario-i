import Util.ConsoleColors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Definir a matriz aumentada
//        double[][] matriz = {{1, 2, 4, 0},
//                {0, 1, 2, 9},
//                {0, 0, 0, 0}};

        Scanner scanner = new Scanner(System.in);

        showMenu();

        int option = scanner.nextInt();

        while (option != 0) {
            switch (option) {
                case 1:
                    transposeMatrix();
                    break;
                case 2:
                    sumMatrix();
                    break;
                case 3:
                    timesMatrixWithScalar();
                    break;
                case 4:
                    timesMatrix();
                    break;
                case 5:
                    gauss();
                    break;
                case 6:
                    solve();
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
                    System.out.println("Opção inválida\n");
                    System.out.println(ConsoleColors.RESET);
            }

            showMenu();
            option = scanner.nextInt();
        }

        System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Encerrando aplicação...");
        System.out.println(" ");
        System.exit(0);
        System.out.println(ConsoleColors.RESET);
    }

    public static void showMenu() {
        System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD + "MENU");
        System.out.println("Escolha uma opção: ");
        System.out.println("0 - Sair");
        System.out.println("1 - Transpor uma matriz");
        System.out.println("2 - Somar duas matrizes");
        System.out.println("3 - Multiplicar uma matriz por um escalar");
        System.out.println("4 - Multiplicar duas matrizes");
        System.out.println("5 - Resolver um sistema linear");
        System.out.println("6 - Solve");
        System.out.println(ConsoleColors.RESET);
    }

    public static void showVector(Vector vector) {
        System.out.println(
                ConsoleColors.CYAN_BACKGROUND_BRIGHT +
                        ConsoleColors.BLACK_BOLD +
                        vector + ConsoleColors.RESET
        );
    }

    public static void showMatrix(Matrix matrix) {
        System.out.println(
                ConsoleColors.CYAN_BACKGROUND_BRIGHT +
                        ConsoleColors.BLACK_BOLD +
                        matrix + ConsoleColors.RESET
        );
    }

    public static void showMatrix(Matrix matrix1, Matrix matrix2) {
        System.out.print(
                ConsoleColors.CYAN_BACKGROUND_BRIGHT +
                        ConsoleColors.BLACK_BOLD +
                        matrix1
        );

        System.out.print(
                ConsoleColors.CYAN_BACKGROUND_BRIGHT +
                        ConsoleColors.BLACK_BOLD +
                        matrix2 +
                        ConsoleColors.RESET
        );
    }

    public static void transposeMatrix() {
        Scanner scanner = new Scanner(System.in);
        AlgebraLinear algebra = new AlgebraLinear();

        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Transpor uma matriz \n");
        System.out.println(ConsoleColors.RESET);

        System.out.println("Digite a quantidade de linhas da matriz: ");
        int qtyLines = scanner.nextInt();

        System.out.println("Digite a quantidade de colunas da matriz: ");
        int qtyColumns = scanner.nextInt();

        //verifico se qtyLines e qtyColumns são maiores que 0
        if (qtyLines <= 0 || qtyColumns <= 0) {
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
            System.out.println("Quantidade de linhas e colunas deve ser maior que 0 \n");
            System.out.println(ConsoleColors.RESET);
            return;
        }

        double[][] preMatrix = new double[qtyLines][qtyColumns];

        for (int i = 0; i < qtyLines; i++) {
            for (int j = 0; j < qtyColumns; j++) {
                System.out.println("Digite o valor da linha " + (i + 1) + " e coluna " + (j + 1) + ": ");
                preMatrix[i][j] = scanner.nextInt();
            }
        }

        Matrix matrix = new Matrix(qtyLines, qtyColumns, preMatrix);

        System.out.println("Matriz digitada: ");
        showMatrix(matrix);

        System.out.println("Matriz transposta: ");
        showMatrix(algebra.transpose(matrix));
    }

    public static void sumMatrix() {
        Scanner scanner = new Scanner(System.in);
        AlgebraLinear algebra = new AlgebraLinear();

        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Somar duas matrizes \n");
        System.out.println(ConsoleColors.RESET);

        System.out.println("Digite a quantidade de linhas da 1ª matriz: ");
        int qtyLines = scanner.nextInt();
        System.out.println("Digite a quantidade de colunas da 1ª matriz: ");
        int qtyColumns = scanner.nextInt();

        double[][] preMatrix1 = new double[qtyLines][qtyColumns];

        System.out.println("1ª Matriz:");
        for (int i = 0; i < qtyLines; i++) {
            for (int j = 0; j < qtyColumns; j++) {
                System.out.println("Digite o valor da linha " + (i + 1) + " e coluna " + (j + 1) + ": ");
                preMatrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("-------------------- \n");

        double[][] preMatrix2 = new double[qtyLines][qtyColumns];

        System.out.println("2ª Matriz:");
        for (int i = 0; i < qtyLines; i++) {
            for (int j = 0; j < qtyColumns; j++) {
                System.out.println("Digite o valor da linha " + (i + 1) + " e coluna " + (j + 1) + ": ");
                preMatrix2[i][j] = scanner.nextInt();
            }
        }

        Matrix matrix1 = new Matrix(qtyLines, qtyColumns, preMatrix1);
        Matrix matrix2 = new Matrix(qtyLines, qtyColumns, preMatrix2);

        showMatrix(matrix1, matrix2);
        System.out.println("Matriz 1 + Matriz 2: ");
        showMatrix(algebra.sum(matrix1, matrix2));
    }

    public static void timesMatrixWithScalar() {
        Scanner scanner = new Scanner(System.in);
        AlgebraLinear algebra = new AlgebraLinear();

        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Multiplicar uma matriz por um escalar \n");
        System.out.println(ConsoleColors.RESET);

        System.out.println("Digite a quantidade de linhas da matriz: ");
        int qtyLines = scanner.nextInt();
        System.out.println("Digite a quantidade de colunas da matriz: ");
        int qtyColumns = scanner.nextInt();

        double[][] preMatrix = new double[qtyLines][qtyColumns];

        System.out.println("Matriz:");
        for (int i = 0; i < qtyLines; i++) {
            for (int j = 0; j < qtyColumns; j++) {
                System.out.println("Digite o valor da linha " + (i + 1) + " e coluna " + (j + 1) + ": ");
                preMatrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Digite o valor do escalar: ");
        int scalar = scanner.nextInt();

        Matrix matrix = new Matrix(qtyLines, qtyColumns, preMatrix);

        System.out.println("Matriz digitada: ");
        showMatrix(matrix);

        System.out.println("Matriz * " + scalar + ": ");

        showMatrix(algebra.times(scalar, matrix));
    }

    public static void timesMatrix() {
        Scanner scanner = new Scanner(System.in);
        AlgebraLinear algebra = new AlgebraLinear();

        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Multiplicar duas matrizes \n");
        System.out.println(ConsoleColors.RESET);

        System.out.println("Digite a quantidade de linhas da 1ª matriz: ");
        int qtyLines1 = scanner.nextInt();
        System.out.println("Digite a quantidade de colunas da 1ª matriz: ");
        int qtyColumns1 = scanner.nextInt();

        double[][] preMatrix1 = new double[qtyLines1][qtyColumns1];

        System.out.println("1ª Matriz:");
        for (int i = 0; i < qtyLines1; i++) {
            for (int j = 0; j < qtyColumns1; j++) {
                System.out.println("Digite o valor da linha " + (i + 1) + " e coluna " + (j + 1) + ": ");
                preMatrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("-------------------- \n");

        System.out.println("Digite a quantidade de linhas da 2ª matriz: ");
        int qtyLines2 = scanner.nextInt();
        System.out.println("Digite a quantidade de colunas da 2ª matriz: ");
        int qtyColumns2 = scanner.nextInt();

        double[][] preMatrix2 = new double[qtyLines2][qtyColumns2];

        System.out.println("2ª Matriz:");
        for (int i = 0; i < qtyLines2; i++) {
            for (int j = 0; j < qtyColumns2; j++) {
                System.out.println("Digite o valor da linha " + (i + 1) + " e coluna " + (j + 1) + ": ");
                preMatrix2[i][j] = scanner.nextInt();
            }
        }

        Matrix matrix1 = new Matrix(qtyLines1, qtyColumns1, preMatrix1);
        Matrix matrix2 = new Matrix(qtyLines2, qtyColumns2, preMatrix2);

        System.out.println("Matrizes digitadas: ");
        showMatrix(matrix1, matrix2);

        System.out.println("Matriz 1 * Matriz 2: ");
        showMatrix(algebra.times(matrix1, matrix2));
    }

    public static void gauss() {
        Scanner scanner = new Scanner(System.in);
        AlgebraLinear algebra = new AlgebraLinear();

        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Resolver um sistema linear \n");
        System.out.println(ConsoleColors.RESET);

        System.out.println("Digite a quantidade de linhas da matriz: ");
        int qtyLines = scanner.nextInt();
        System.out.println("Digite a quantidade de colunas da matriz: ");
        int qtyColumns = scanner.nextInt();

        double[][] preMatrix = new double[qtyLines][qtyColumns];

        System.out.println("Matriz:");
        for (int i = 0; i < qtyLines; i++) {
            for (int j = 0; j < qtyColumns; j++) {
                System.out.println("Digite o valor da linha " + (i + 1) + " e coluna " + (j + 1) + ": ");
                preMatrix[i][j] = scanner.nextInt();
            }
        }

        Matrix matrix = new Matrix(qtyLines, qtyColumns, preMatrix);

        System.out.println("Matriz digitada: ");
        showMatrix(matrix);

        System.out.println("Solução: ");
        showMatrix(algebra.gauss(matrix));
    }

    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        AlgebraLinear algebra = new AlgebraLinear();

        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Resolver um sistema linear \n");
        System.out.println(ConsoleColors.RESET);

        System.out.println("Digite a quantidade de linhas da matriz: ");
        int qtyLines = scanner.nextInt();
        System.out.println("Digite a quantidade de colunas da matriz: ");
        int qtyColumns = scanner.nextInt();

        double[][] preMatrix = new double[qtyLines][qtyColumns];

        System.out.println("Matriz:");
        for (int i = 0; i < qtyLines; i++) {
            for (int j = 0; j < qtyColumns; j++) {
                System.out.println("Digite o valor da linha " + (i + 1) + " e coluna " + (j + 1) + ": ");
                preMatrix[i][j] = scanner.nextInt();
            }
        }

        Matrix matrix = new Matrix(qtyLines, qtyColumns, preMatrix);

        System.out.println("Matriz digitada: ");
        showMatrix(matrix);

        System.out.println("Solução: ");
        showVector(algebra.solve(matrix));
    }
}
