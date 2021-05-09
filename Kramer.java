public class Kramer {
    public static double[] solve(int[][] k, int[] free_elements) {
        double det = Matrix.det(k);
        double[] solves = new double[free_elements.length];
        double[] s = new double[free_elements.length];
        for (int i = 0; i < k.length; i++) {
            int[][] temp = deepCopy(k);
            for (int j = 0; j < free_elements.length; j++)
                temp[j][i] = free_elements[j];
            double det2 = Matrix.det(temp);
            s[i] = det2;
            if (det != 0)
                solves[i] = det2 / det;
        }
        if (det != 0) {
            return solves;
        } else if (allElementsZero(s)) {
            System.out.println("Система имеет бесконечное количество решений");
            return null;
        } else {
            System.out.println("Решений нет");
            return null;
        }
    }

    private static boolean allElementsZero(double[] dets) {
        for (double element : dets)
            if (element != 0)
                return false;
        return true;
    }

    private static int[][] deepCopy(int[][] list) {
        int size = list.length;
        int[][] newList = new int[size][size];
        for (int i = 0; i < size; i++)
            System.arraycopy(list[i], 0, newList[i], 0, size);
        return newList;
    }
}
