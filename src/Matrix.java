public class Matrix {
    private int lines;
    private int columns;
    private int[][] elements;

    public Matrix(int lines, int columns, Vector vector) {
        if (lines * columns != vector.getLength()) {
            System.out.println("Matriz inválida! O vetor tem um tamanho diferente da matriz!");
            throw new IllegalArgumentException();
        }

        this.lines = lines;
        this.columns = columns;
        this.elements = new int[lines][columns];
        int indice_vetor = 0;
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                this.elements[i][j] = vector.get(indice_vetor);
                indice_vetor++;
            }
        }
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getColumns() {
        return columns;
    }

    public int[] getLine(int line) {
        return this.elements[line];
    }

    public int[] setLine(int lineIndex, int[] line) {
        return this.elements[lineIndex] = line;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int get(int i, int j) {
        return this.elements[i][j];
    }

    public void set(int i, int j, int valor) {
        this.elements[i][j] = valor;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < lines; i++) {
            str.append("|");
            for (int j = 0; j < columns; j++) {
                str.append("\t");
                if (elements[i][j] >= 0) {
                    str.append(" ");
                }
                str.append(elements[i][j]);
                str.append("\t");
            }
            str.append("|\n");
        }

        return str.toString();
    }

    public String toString(String title) {
        return title + "\n" + this.toString();
    }
}
