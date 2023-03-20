public class Matrix {
    private int rows;
    private int cols;
    private int[][] elements;

    public Matrix(int rows, int cols, int[][] elements) {
        this.rows = rows;
        this.cols = cols;
        this.elements = elements;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int[] getRow(int i) {
        return elements[i];
    }

    public void setRow(int i, int[] row) {
        elements[i] = row;
    }

    public int get(int row, int column) {
        return elements[row][column];
    }

    public void set(int i, int j, int value) {
        elements[i][j] = value;
    }

    public int[][] getElements() {
        return elements;
    }

    public void swapRows(int i, int j) {
        int[] temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            str.append("| ");
            for (int j = 0; j < cols; j++) {
                str.append(elements[i][j]).append(" ");
            }
            str.append("|\n");
        }

        return str.toString();
    }
}
