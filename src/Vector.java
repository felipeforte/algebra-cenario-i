public class Vector {
    public Vector(int dimensao, int[] elementos) {
        this.dimensao = dimensao;
        this.elementos = elementos;
    }
    private int dimensao;
    private int[] elementos;


    public int getElementos(int i) {
        return elementos[i];
    }


    public void set(int i, int valor) {
        this.elementos[i] = valor;
    }

    public String paraString() {
        String n = "";

        for(int i= 0; i<elementos.length;i++){
            n+= elementos[i];
            if (!(i ==elementos.length-1)) {
                n+=" ";
            }
        }
        return n;
    }
}
