import java.util.Scanner;
import java.util.stream.IntStream;

public class Program {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Что необходимо сделать?");
        System.out.println("1. Найти определитель");
        System.out.println("2. Решить квадратную систему линейных уравнений методом Крамера");
        String chose = scanner.next();
        switch (chose) {
            case "1" -> find_det();
            case "2" -> kramer_solver();
        }
    }

    private static void find_det() {
        System.out.println("Введите размерность матрицы");
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        System.out.println("Введите матрицу");
        IntStream.range(0, size).forEach(i -> IntStream.range(0, size).forEach(j -> matrix[i][j] = scanner.nextInt()));
        double det = Matrix.det(matrix);
        System.out.println("Определитель матрицы равен " + det);
    }

    private static void kramer_solver() {
        System.out.println("Введите размер системы");
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        int[] free_elements = new int[size];
        System.out.println("Введите коэффициенты при неизвесных и свободные члены");
        IntStream.range(0, size).forEach(i -> IntStream.range(0, size+1).forEach(j -> {
            if (j == size) {
                free_elements[i] = scanner.nextInt();
            } else {
                matrix[i][j] = scanner.nextInt();
            }
        }));
        double[] result = Kramer.solve(matrix, free_elements);
        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                System.out.println("X" + i + " = " + result[i]);
            }
        }
    }
}

