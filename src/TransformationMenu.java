import Util.ConsoleColors;

import java.util.Scanner;

public class TransformationMenu {

    public void showOptions() {
        Scanner scanner = new Scanner(System.in);

        this.menu();

        int option = scanner.nextInt();

        while (option != 0) {
            switch (option) {
                case 1:
                    translation2D();
                    break;
                case 2:
                    translation3D();
                    break;
                case 3:
                    rotation2D();
                    break;
                case 4:
                    rotation3D("x");
                    break;
                case 5:
                    rotation3D("y");
                    break;
                case 6:
                    rotation3D("z");
                    break;
                case 7:
                    reflection2D("x");
                    break;
                case 8:
                    reflection2D("y");
                    break;
                case 9:
                    reflection3D("x");
                    break;
                case 10:
                    reflection3D("y");
                    break;
                case 11:
                    reflection3D("z");
                    break;
                case 12:
                    projection2D("x");
                    break;
                case 13:
                    projection2D("y");
                    break;
                case 14:
                    projection3D("x");
                    break;
                case 15:
                    projection3D("y");
                    break;
                case 16:
                    projection3D("z");
                    break;
                case 17:
                    shear();
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
                    System.out.println("Opção inválida\n");
                    System.out.println(ConsoleColors.RESET);
            }

            this.menu();
            option = scanner.nextInt();
        }
    }

    protected void menu() {
        System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD + "Operações com vetores".toUpperCase() + " [BETA]");
        System.out.println("Escolha uma opção: ");
        System.out.println("0 - Voltar para o menu principal".toUpperCase());
        System.out.println("1 - Translação 2D");
        System.out.println("2 - Translação 3D");
        System.out.println("--------------------");
        System.out.println("3 - Rotação 2D");
        System.out.println("4 - Rotação 3DX");
        System.out.println("5 - Rotação 3DY");
        System.out.println("6 - Rotação 3DZ");
        System.out.println("--------------------");
        System.out.println("7 - Reflexão 2DX");
        System.out.println("8 - Reflexão 2DY");
        System.out.println("9 - Reflexão 3DX");
        System.out.println("10 - Reflexão 3DY");
        System.out.println("11 - Reflexão 3DZ");
        System.out.println("--------------------");
        System.out.println("12 - Projeção 2DX");
        System.out.println("13 - Projeção 2DY");
        System.out.println("14 - Projeção 3DX");
        System.out.println("15 - Projeção 3DY");
        System.out.println("16 - Projeção 3DZ");
        System.out.println("--------------------");
        System.out.println("17 - Cisalhamento");
        System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD + "Versão [BETA]");
        System.out.println(ConsoleColors.RESET);
    }

    protected void putEnterPrompt() {
        Scanner scanner = new Scanner(System.in);

        //detect enter press
        System.out.println("Pressione ENTER para continuar...");
        scanner.nextLine();
    }

    public void rotation2D() {
        System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD + "ROTAÇÃO 2D");
        System.out.println(ConsoleColors.RESET);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os elementos (X,Y) do vetor: ");
        String[] elements = scanner.nextLine().split(" ");

        if (elements.length != 2) {
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
            System.out.println("O vetor deve ter 2 elementos\n");
            System.out.println(ConsoleColors.RESET);
            return;
        }

        double[] vector = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            vector[i] = Double.parseDouble(elements[i]);
        }

        System.out.println("Digite o ângulo de rotação: ");
        double angle = scanner.nextDouble();

        Transformations transformations = new Transformations();
        Vector result = transformations.rotation2D(new Vector(vector.length, vector), angle);

        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Resultado: " + result.toString() + "\n");
        System.out.println(ConsoleColors.RESET);

        this.putEnterPrompt();
    }

    public void rotation3D(String axis) {
        System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD + "ROTAÇÃO 3D " + axis.toUpperCase());
        System.out.println(ConsoleColors.RESET);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os elementos (X,Y,Z) do vetor: ");
        String[] elements = scanner.nextLine().split(" ");

        if (elements.length != 3) {
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
            System.out.println("O vetor deve ter 3 elementos\n");
            System.out.println(ConsoleColors.RESET);
            return;
        }

        double[] vector = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            vector[i] = Double.parseDouble(elements[i]);
        }

        System.out.println("Digite o ângulo de rotação: ");
        double angle = scanner.nextDouble();

        Transformations transformations = new Transformations();
        Vector result;
        Vector mountedVector = new Vector(3, new double[]{vector[0], vector[1], vector[2]});

        switch (axis) {
            case "x":
                result = transformations.rotation3DX(mountedVector, angle);
                break;
            case "y":
                result = transformations.rotation3DY(mountedVector, angle);
                break;
            case "z":
                result = transformations.rotation3DZ(mountedVector, angle);
                break;
            default:
                System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
                System.out.println("Eixo inválido\n");
                System.out.println(ConsoleColors.RESET);
                return;
        }

        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Resultado: " + result.toString() + "\n");
        System.out.println(ConsoleColors.RESET);

        this.putEnterPrompt();
    }

    public void translation2D() {
        System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD + "TRANSLAÇÃO 2D");
        System.out.println(ConsoleColors.RESET);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os elementos (X,Y) do vetor: ");
        String[] elements = scanner.nextLine().split(" ");

        if (elements.length != 2) {
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
            System.out.println("O vetor deve ter 2 elementos\n");
            System.out.println(ConsoleColors.RESET);
            return;
        }

        double[] vector = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            vector[i] = Double.parseDouble(elements[i]);
        }

        System.out.println("Digite a translação (X,Y) do vetor: ");
        String[] trans = scanner.nextLine().split(" ");

        double[] translacao = new double[2];
        if (trans.length == 1) {
            translacao[0] = Double.parseDouble(trans[0]);
            translacao[1] = 0;
        } else if (elements.length != 2) {
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
            System.out.println("A translação deve ter no mínimo 1 elemento e no máximo 2\n");
            System.out.println(ConsoleColors.RESET);
            return;
        } else {
            for (int i = 0; i < trans.length; i++) {
                translacao[i] = Double.parseDouble(trans[i]);
            }
        }

        Transformations transformations = new Transformations();
        Vector result;
        Vector mountedVector = new Vector(2, new double[]{vector[0], vector[1]});

        result = transformations.translate2D(mountedVector, translacao[0], translacao[1]);

        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Resultado: " + result.toString() + "\n");
        System.out.println(ConsoleColors.RESET);

        this.putEnterPrompt();
    }

    public void translation3D() {
        System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD + "TRANSLAÇÃO 3D");
        System.out.println(ConsoleColors.RESET);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os elementos (X,Y,Z) do vetor: ");
        String[] elements = scanner.nextLine().split(" ");

        if (elements.length != 3) {
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
            System.out.println("O vetor deve ter 3 elementos\n");
            System.out.println(ConsoleColors.RESET);
            return;
        }

        double[] vector = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            vector[i] = Double.parseDouble(elements[i]);
        }

        System.out.println("Digite a translação (X,Y,Z) do vetor: ");
        String[] trans = scanner.nextLine().split(" ");

        double[] translacao = new double[3];
        if (trans.length == 1) {
            translacao[0] = Double.parseDouble(trans[0]);
            translacao[1] = 0;
            translacao[2] = 0;
        } else if (trans.length == 2) {
            translacao[0] = Double.parseDouble(trans[0]);
            translacao[1] = Double.parseDouble(trans[1]);
            translacao[2] = 0;
        } else if (elements.length != 3) {
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
            System.out.println("A translação deve ter no mínimo 1 elemento e no máximo 3\n");
            System.out.println(ConsoleColors.RESET);
            return;
        } else {
            for (int i = 0; i < trans.length; i++) {
                translacao[i] = Double.parseDouble(trans[i]);
            }
        }

        Transformations transformations = new Transformations();
        Vector result;
        Vector mountedVector = new Vector(3, new double[]{vector[0], vector[1], vector[2]});

        result = transformations.translate3D(mountedVector, translacao[0], translacao[1], translacao[2]);

        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Resultado: " + result.toString() + "\n");
        System.out.println(ConsoleColors.RESET);

        this.putEnterPrompt();
    }

    public void reflection2D(String axis) {
        System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD + "REFLEXÃO 2D" + axis.toUpperCase());
        System.out.println(ConsoleColors.RESET);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os elementos (X,Y) do vetor: ");
        String[] elements = scanner.nextLine().split(" ");

        if (elements.length != 2) {
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
            System.out.println("O vetor deve ter 2 elementos\n");
            System.out.println(ConsoleColors.RESET);
            return;
        }

        double[] vector = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            vector[i] = Double.parseDouble(elements[i]);
        }

        Transformations transformations = new Transformations();
        Vector result;
        Vector mountedVector = new Vector(2, new double[]{vector[0], vector[1]});
        if (axis.equals("x")) {
            result = transformations.reflection2DX(mountedVector);
        } else {
            result = transformations.reflection2DY(mountedVector);
        }

        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Resultado: " + result.toString() + "\n");
        System.out.println(ConsoleColors.RESET);

        this.putEnterPrompt();
    }

    public void reflection3D(String axis) {
        System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD + "REFLEXÃO 3D" + axis.toUpperCase());
        System.out.println(ConsoleColors.RESET);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os elementos (X,Y,Z) do vetor: ");
        String[] elements = scanner.nextLine().split(" ");

        if (elements.length != 3) {
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
            System.out.println("O vetor deve ter 3 elementos\n");
            System.out.println(ConsoleColors.RESET);
            return;
        }

        double[] vector = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            vector[i] = Double.parseDouble(elements[i]);
        }

        Transformations transformations = new Transformations();
        Vector result;
        Vector mountedVector = new Vector(3, new double[]{vector[0], vector[1], vector[2]});
        if (axis.equals("x")) {
            result = transformations.reflection3DX(mountedVector);
        } else if (axis.equals("y")) {
            result = transformations.reflection3DY(mountedVector);
        } else {
            result = transformations.reflection3DZ(mountedVector);
        }

        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Resultado: " + result.toString() + "\n");
        System.out.println(ConsoleColors.RESET);

        this.putEnterPrompt();
    }

    public void projection2D(String axis) {
        System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD + "PROJEÇÃO 2D" + axis.toUpperCase());
        System.out.println(ConsoleColors.RESET);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os elementos (X,Y) do vetor: ");
        String[] elements = scanner.nextLine().split(" ");

        if (elements.length != 2) {
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
            System.out.println("O vetor deve ter 2 elementos\n");
            System.out.println(ConsoleColors.RESET);
            return;
        }

        double[] vector = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            vector[i] = Double.parseDouble(elements[i]);
        }

        Transformations transformations = new Transformations();
        Vector result;
        Vector mountedVector = new Vector(2, new double[]{vector[0], vector[1]});
        if (axis.equals("x")) {
            result = transformations.projection2DX(mountedVector);
        } else {
            result = transformations.projection2DY(mountedVector);
        }

        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Resultado: " + result.toString() + "\n");
        System.out.println(ConsoleColors.RESET);

        this.putEnterPrompt();
    }

    public void projection3D(String axis) {
        System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD + "PROJEÇÃO 3D" + axis.toUpperCase());
        System.out.println(ConsoleColors.RESET);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os elementos (X,Y,Z) do vetor: ");
        String[] elements = scanner.nextLine().split(" ");

        if (elements.length != 3) {
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
            System.out.println("O vetor deve ter 3 elementos\n");
            System.out.println(ConsoleColors.RESET);
            return;
        }

        double[] vector = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            vector[i] = Double.parseDouble(elements[i]);
        }

        Transformations transformations = new Transformations();
        Vector result;
        Vector mountedVector = new Vector(3, new double[]{vector[0], vector[1], vector[2]});
        if (axis.equals("x")) {
            result = transformations.projection3DX(mountedVector);
        } else if (axis.equals("y")) {
            result = transformations.projection3DY(mountedVector);
        } else {
            result = transformations.projection3DZ(mountedVector);
        }

        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Resultado: " + result.toString() + "\n");
        System.out.println(ConsoleColors.RESET);

        this.putEnterPrompt();
    }

    public void shear(){
        System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD + "CISALHAMENTO 2D");
        System.out.println(ConsoleColors.RESET);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os elementos (X,Y) do vetor: ");
        String[] elements = scanner.nextLine().split(" ");

        if (elements.length != 2) {
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
            System.out.println("O vetor deve ter 2 elementos\n");
            System.out.println(ConsoleColors.RESET);
            return;
        }

        double[] vector = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            vector[i] = Double.parseDouble(elements[i]);
        }

        //pega os fatores de cisalhamento
        System.out.println("Digite os fatores de cisalhamento (X,Y): ");
        String[] shearingFactors = scanner.nextLine().split(" ");

        if (shearingFactors.length != 2) {
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
            System.out.println("O vetor deve ter 2 elementos\n");
            System.out.println(ConsoleColors.RESET);
            return;
        }

        double[] shearingFactorsVector = new double[shearingFactors.length];
        for (int i = 0; i < shearingFactors.length; i++) {
            shearingFactorsVector[i] = Double.parseDouble(shearingFactors[i]);
        }

        Transformations transformations = new Transformations();
        Vector result;
        Vector mountedVector = new Vector(2, new double[]{vector[0], vector[1]});
        result = transformations.shearing2D(mountedVector, shearingFactorsVector[0], shearingFactorsVector[1]);

        System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
        System.out.println("Resultado: " + result.toString() + "\n");
        System.out.println(ConsoleColors.RESET);

        this.putEnterPrompt();
    }
}
