public class Vector {
    private int dimensao;
    private int[] elementos;

    public Vector(int dimensao, int[] elementos) {
        this.dimensao = dimensao;
        this.elementos = elementos;
    }

    public int getElementos(int i) {
        return elementos[i];
    }

    public void set(int i, int valor) {
        this.elementos[i] = valor;
    }
}

