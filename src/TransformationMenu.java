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
                    System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD);
                    System.out.println("Translação 2D\n");
                    System.out.println(ConsoleColors.RESET);
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
}
