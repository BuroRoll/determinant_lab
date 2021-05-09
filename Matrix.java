public class Matrix {

    static double det(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            throw new IllegalArgumentException("матрица введена неверно");
        int n = matrix.length;
        if (n == 1)
            return matrix[0][0];
        if (n == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        double ans = 0;
        int minor[][] = new int[n - 1][n - 1];
        int l = 1;
        for (int i = 0; i < n; ++i) {

            int x = 0, y = 0;
            for (int j = 1; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (i == k) continue;
                    minor[x][y] = matrix[j][k];
                    ++y;
                    if (y == n - 1) {
                        y = 0;
                        ++x;
                    }
                }
            }
            ans += l * matrix[0][i] * det(minor);
            l *= (-1);
        }
        return ans;
    }
}
