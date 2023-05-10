public class Transformations {
    public Vector translate2D(Vector v, double dx, double dy) {
        // Cria uma array com uma coordenada homogênea, ou seja com uma dimensão a mais que o vetor final*
        double[] array = new double[3];

        if (v.getLength() < 2) {
            // Em caso de vetor unidimensional, preencher apenas o primeiro elemento, e o resto com 0
            array[0] = v.get(0);
            array[1] = 0;
        } else {
            // Preenche elementos do vetor no array
            for (int i = 0; i < 2; i++) {
                array[i] = v.get(i);
            }
        }


        // Adiciona a coordenada homogênea
        array[2] = 1;

        // Cria a matriz de transformação
        double[][] transMatriz = {
                {1, 0, dx},
                {0, 1, dy},
                {0, 0, 1}
        };
        // Realiza a multiplicação da matriz pelo vetor e armazena o resultado no vetorResultante
        double[] vetorResultante = new double[3];
        for (int i = 0; i < 3; i++) {
            double soma = 0;
            for (int j = 0; j < 3; j++) {
                soma += transMatriz[i][j] * array[j];
            }
            vetorResultante[i] = soma;
        }

        // Transfere os elementos do vetor resultante em um vetor sem a coordenada homogênea
        double[] vetorPreFinal = new double[2];
        for (int i = 0; i < 2; i++) {
            vetorPreFinal[i] = vetorResultante[i];
        }

        Vector vetorFinal = new Vector(2, vetorPreFinal);
        return vetorFinal;
    }

    public Vector translate3D(Vector v, double dx, double dy, double dz) {
        // Cria uma array com uma coordenada homogênea, ou seja com uma dimensão a mais que o vetor final*
        double[] array = new double[4];

        if (v.getLength() == 1) {
            // Em caso de vetor unidimensional, preencher apenas o primeiro elemento, o resto com 0
            array[0] = v.get(0);
            array[1] = 0;
            array[2] = 0;
        } else if (v.getLength() == 2) {
            // Em caso de vetor bidimensional, preencher apenas os dois primeiros elementos, o resto com 0
            array[0] = v.get(0);
            array[1] = v.get(1);
            array[2] = 0;
        } else {
            // Preenche elementos do vetor no array
            for (int i = 0; i < 3; i++) {
                array[i] = v.get(i);
            }
        }


        // Adiciona a coordenada homogênea
        array[3] = 1;

        // Cria a matriz de transformação
        double[][] transMatriz = {
                {1, 0, 0, dx},
                {0, 1, 0, dy},
                {0, 0, 1, dz},
                {0, 0, 0, 1}
        };
        // Realiza a multiplicação da matriz pelo vetor e armazena o resultado no vetorResultante
        double[] vetorResultante = new double[4];
        for (int i = 0; i < 4; i++) {
            double soma = 0;
            for (int j = 0; j < 4; j++) {
                soma += transMatriz[i][j] * array[j];
            }
            vetorResultante[i] = soma;
        }

        // Transfere os elementos do vetor resultante em um vetor sem a coordenada homogênea
        double[] vetorPreFinal = new double[3];
        for (int i = 0; i < 3; i++) {
            vetorPreFinal[i] = vetorResultante[i];
        }

        Vector vetorFinal = new Vector(3, vetorPreFinal);
        return vetorFinal;
    }

//    public Vector rotation2D(Vector v, double ang) {
//    }
//    public Vector rotation3DX(Vector v, double ang) {
//    }
//    public Vector rotation3DY(Vector v, double ang) {
//    }
//    public Vector rotation3DZ(Vector v, double ang) {
//    }
    public Vector reflection2DX(Vector v) {
        // Cria uma array com uma coordenada homogênea, ou seja com uma dimensão a mais que o vetor
        double[] array = new double[v.getLength() + 1];
        // Preenche elementos do vetor no array
        for (int i = 0; i < v.getLength(); i++) {
            array[i] = v.get(i);
        }
        // Adiciona a coordenada homogênea
        array[v.getLength()] = 1;

        // Cria a matriz de transformação
        double[][] transMatriz = {
                {1, 0},
                {0, -1}
        };
        // Realiza a multiplicação da matriz pelo vetor e armazena o resultado no vetorResultante
        double[] vetorResultante = new double[2];
        for (int i = 0; i < 2; i++) {
            double soma = 0;
            for (int j = 0; j < 2; j++) {
                soma += transMatriz[i][j] * array[j];
            }
            vetorResultante[i] = soma;
        }

        // Transfere os elementos do vetor resultante em um vetor sem a coordenada homogênea
        double[] vetorPreFinal = new double[2];
        for (int i = 0; i < 2; i++) {
            vetorPreFinal[i] = vetorResultante[i];
        }

        Vector vetorFinal = new Vector(2, vetorPreFinal);
        return vetorFinal;
    }

    public Vector reflection2DY(Vector v) {
        // Cria uma array com uma coordenada homogênea, ou seja com uma dimensão a mais que o vetor
        double[] array = new double[v.getLength() + 1];
        // Preenche elementos do vetor no array
        for (int i = 0; i < v.getLength(); i++) {
            array[i] = v.get(i);
        }
        // Adiciona a coordenada homogênea
        array[v.getLength()] = 1;

        // Cria a matriz de transformação
        double[][] transMatriz = {
                {-1, 0},
                {0, 1}
        };
        // Realiza a multiplicação da matriz pelo vetor e armazena o resultado no vetorResultante
        double[] vetorResultante = new double[2];
        for (int i = 0; i < 2; i++) {
            double soma = 0;
            for (int j = 0; j < 2; j++) {
                soma += transMatriz[i][j] * array[j];
            }
            vetorResultante[i] = soma;
        }

        // Transfere os elementos do vetor resultante em um vetor sem a coordenada homogênea
        double[] vetorPreFinal = new double[2];
        for (int i = 0; i < 2; i++) {
            vetorPreFinal[i] = vetorResultante[i];
        }

        Vector vetorFinal = new Vector(2, vetorPreFinal);
        return vetorFinal;
    }

    public Vector reflection3DX(Vector v) {
        // Cria uma array com uma coordenada homogênea, ou seja com uma dimensão a mais que o vetor
        double[] array = new double[v.getLength() + 1];
        // Preenche elementos do vetor no array
        for (int i = 0; i < v.getLength(); i++) {
            array[i] = v.get(i);
        }
        // Adiciona a coordenada homogênea
        array[v.getLength()] = 1;

        // Cria a matriz de transformação
        double[][] transMatriz = {
                {-1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        // Realiza a multiplicação da matriz pelo vetor e armazena o resultado no vetorResultante
        double[] vetorResultante = new double[3];
        for (int i = 0; i < 3; i++) {
            double soma = 0;
            for (int j = 0; j < 3; j++) {
                soma += transMatriz[i][j] * array[j];
            }
            vetorResultante[i] = soma;
        }

        // Transfere os elementos do vetor resultante em um vetor sem a coordenada homogênea
        double[] vetorPreFinal = new double[3];
        for (int i = 0; i < 3; i++) {
            vetorPreFinal[i] = vetorResultante[i];
        }

        Vector vetorFinal = new Vector(3, vetorPreFinal);
        return vetorFinal;
    }

    public Vector reflection3DY(Vector v) {
        // Cria uma array com uma coordenada homogênea, ou seja com uma dimensão a mais que o vetor
        double[] array = new double[v.getLength() + 1];
        // Preenche elementos do vetor no array
        for (int i = 0; i < v.getLength(); i++) {
            array[i] = v.get(i);
        }
        // Adiciona a coordenada homogênea
        array[v.getLength()] = 1;

        // Cria a matriz de transformação
        double[][] transMatriz = {
                {1, 0, 0},
                {0, -1, 0},
                {0, 0, 1}
        };
        // Realiza a multiplicação da matriz pelo vetor e armazena o resultado no vetorResultante
        double[] vetorResultante = new double[3];
        for (int i = 0; i < 3; i++) {
            double soma = 0;
            for (int j = 0; j < 3; j++) {
                soma += transMatriz[i][j] * array[j];
            }
            vetorResultante[i] = soma;
        }

        // Transfere os elementos do vetor resultante em um vetor sem a coordenada homogênea
        double[] vetorPreFinal = new double[3];
        for (int i = 0; i < 3; i++) {
            vetorPreFinal[i] = vetorResultante[i];
        }

        Vector vetorFinal = new Vector(3, vetorPreFinal);
        return vetorFinal;
    }

    public Vector reflection3DZ(Vector v) {
        // Cria uma array com uma coordenada homogênea, ou seja com uma dimensão a mais que o vetor
        double[] array = new double[v.getLength() + 1];
        // Preenche elementos do vetor no array
        for (int i = 0; i < v.getLength(); i++) {
            array[i] = v.get(i);
        }
        // Adiciona a coordenada homogênea
        array[v.getLength()] = 1;

        // Cria a matriz de transformação
        double[][] transMatriz = {
                {-1, 0, 0},
                {0, -1, 0},
                {0, 0, 1}
        };
        // Realiza a multiplicação da matriz pelo vetor e armazena o resultado no vetorResultante
        double[] vetorResultante = new double[3];
        for (int i = 0; i < 3; i++) {
            double soma = 0;
            for (int j = 0; j < 3; j++) {
                soma += transMatriz[i][j] * array[j];
            }
            vetorResultante[i] = soma;
        }

        // Transfere os elementos do vetor resultante em um vetor sem a coordenada homogênea
        double[] vetorPreFinal = new double[3];
        for (int i = 0; i < 3; i++) {
            vetorPreFinal[i] = vetorResultante[i];
        }

        Vector vetorFinal = new Vector(3, vetorPreFinal);
        return vetorFinal;
    }

    public Vector projection2DX(Vector v) {
        // Cria uma array com uma coordenada homogênea, ou seja com uma dimensão a mais que o vetor
        double[] array = new double[v.getLength() + 1];
        // Preenche elementos do vetor no array
        for (int i = 0; i < v.getLength(); i++) {
            array[i] = v.get(i);
        }
        // Adiciona a coordenada homogênea
        array[v.getLength()] = 1;

        // Cria a matriz de transformação
        double[][] transMatriz = {
                {1, 0},
                {0, 0}
        };
        // Realiza a multiplicação da matriz pelo vetor e armazena o resultado no vetorResultante
        double[] vetorResultante = new double[2];
        for (int i = 0; i < 2; i++) {
            double soma = 0;
            for (int j = 0; j < 2; j++) {
                soma += transMatriz[i][j] * array[j];
            }
            vetorResultante[i] = soma;
        }

        // Transfere os elementos do vetor resultante em um vetor sem a coordenada homogênea
        double[] vetorPreFinal = new double[2];
        for (int i = 0; i < 2; i++) {
            vetorPreFinal[i] = vetorResultante[i];
        }

        return new Vector(2, vetorPreFinal);
    }

    public Vector projection2DY(Vector v) {
        // Cria uma array com uma coordenada homogênea, ou seja com uma dimensão a mais que o vetor
        double[] array = new double[v.getLength() + 1];
        // Preenche elementos do vetor no array
        for (int i = 0; i < v.getLength(); i++) {
            array[i] = v.get(i);
        }
        // Adiciona a coordenada homogênea
        array[v.getLength()] = 1;

        // Cria a matriz de transformação
        double[][] transMatriz = {
                {0, 0},
                {0, 1}
        };
        // Realiza a multiplicação da matriz pelo vetor e armazena o resultado no vetorResultante
        double[] vetorResultante = new double[3];
        for (int i = 0; i < 3; i++) {
            double soma = 0;
            for (int j = 0; j < 3; j++) {
                soma += transMatriz[i][j] * array[j];
            }
            vetorResultante[i] = soma;
        }

        // Transfere os elementos do vetor resultante em um vetor sem a coordenada homogênea
        double[] vetorPreFinal = new double[2];
        for (int i = 0; i < 2; i++) {
            vetorPreFinal[i] = vetorResultante[i];
        }

        return new Vector(2, vetorPreFinal);
    }

    public Vector projection3DX(Vector v) {
        // Cria uma array com uma coordenada homogênea, ou seja com uma dimensão a mais que o vetor
        double[] array = new double[v.getLength() + 1];
        // Preenche elementos do vetor no array
        for (int i = 0; i < v.getLength(); i++) {
            array[i] = v.get(i);
        }
        // Adiciona a coordenada homogênea
        array[v.getLength()] = 1;

        // Cria a matriz de transformação
        double[][] transMatriz = {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        // Realiza a multiplicação da matriz pelo vetor e armazena o resultado no vetorResultante
        double[] vetorResultante = new double[3];
        for (int i = 0; i < 3; i++) {
            double soma = 0;
            for (int j = 0; j < 3; j++) {
                soma += transMatriz[i][j] * array[j];
            }
            vetorResultante[i] = soma;
        }

        // Transfere os elementos do vetor resultante em um vetor sem a coordenada homogênea
        double[] vetorPreFinal = new double[3];
        for (int i = 0; i < 3; i++) {
            vetorPreFinal[i] = vetorResultante[i];
        }

        return new Vector(3, vetorPreFinal);
    }

    public Vector projection3DY(Vector v) {
        // Cria uma array com uma coordenada homogênea, ou seja com uma dimensão a mais que o vetor
        double[] array = new double[v.getLength() + 1];
        // Preenche elementos do vetor no array
        for (int i = 0; i < v.getLength(); i++) {
            array[i] = v.get(i);
        }
        // Adiciona a coordenada homogênea
        array[v.getLength()] = 1;

        // Cria a matriz de transformação
        double[][] transMatriz = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        // Realiza a multiplicação da matriz pelo vetor e armazena o resultado no vetorResultante
        double[] vetorResultante = new double[3];
        for (int i = 0; i < 3; i++) {
            double soma = 0;
            for (int j = 0; j < 3; j++) {
                soma += transMatriz[i][j] * array[j];
            }
            vetorResultante[i] = soma;
        }

        // Transfere os elementos do vetor resultante em um vetor sem a coordenada homogênea
        double[] vetorPreFinal = new double[3];
        for (int i = 0; i < 3; i++) {
            vetorPreFinal[i] = vetorResultante[i];
        }

        return new Vector(3, vetorPreFinal);
    }

    public Vector projection3DZ(Vector v) {
        // Cria uma array com uma coordenada homogênea, ou seja com uma dimensão a mais que o vetor
        double[] array = new double[v.getLength() + 1];
        // Preenche elementos do vetor no array
        for (int i = 0; i < v.getLength(); i++) {
            array[i] = v.get(i);
        }
        // Adiciona a coordenada homogênea
        array[v.getLength()] = 1;

        // Cria a matriz de transformação
        double[][] transMatriz = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        // Realiza a multiplicação da matriz pelo vetor e armazena o resultado no vetorResultante
        double[] vetorResultante = new double[3];
        for (int i = 0; i < 3; i++) {
            double soma = 0;
            for (int j = 0; j < 3; j++) {
                soma += transMatriz[i][j] * array[j];
            }
            vetorResultante[i] = soma;
        }

        // Transfere os elementos do vetor resultante em um vetor sem a coordenada homogênea
        double[] vetorPreFinal = new double[3];
        for (int i = 0; i < 3; i++) {
            vetorPreFinal[i] = vetorResultante[i];
        }

        return new Vector(3, vetorPreFinal);
    }
//    public Vector shearing(Vector v, double kx, double ky) {
//    }
}
