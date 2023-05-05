public class Vector {
    private double[] vector;

    public Vector(int dimension, double[] vector) {
        this.vector = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            this.vector[i] = vector[i];
        }
    }

    public double get(int index) {
        return vector[index];
    }

    public void set(int index, int value) {
        vector[index] = value;
    }

    public int getLength() {
        return vector.length;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        //forma reduzida
        //        for (int j : vector) {
        //            str.append(j).append(" ");
        //        }
        for (int i = 0; i < vector.length; i++) {
            str.append(vector[i]).append(" ");
        }

        return str.toString();
    }

}
