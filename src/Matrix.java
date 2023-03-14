public class Matrix {
    private int linhas;
    private int colunas;
    private int[][] elementos;

    public Matrix(int linhas, int colunas, int[] vetor) {
        if (linhas * colunas != vetor.length) {
            System.out.println("Matriz inválida! O vetor tem um tamanho diferente da matriz!");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        this.elementos = new int[linhas][colunas];
        int indice_vetor = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                this.elementos[i][j] = vetor[indice_vetor];
                indice_vetor++;
            }
        }
    }

    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public int get(int i, int j) {
        return this.elementos[i - 1][j - 1];
    }

    public void set(int i, int j, int valor) {
        this.elementos[i - 1][j - 1] = valor;
    }
}
