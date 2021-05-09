import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты для проверки вычисления определителя")
class TestsMatrix {

    @Test
    public void testSuccessDet() {
        int[][] matrix = {
                {1, -2, 3},
                {4, 0, 6},
                {-7, 8, 9}
        };
        assertEquals(204, Matrix.det(matrix));
    }

    @Test
    public void testZeroDet() {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}
        };
        assertEquals(0, Matrix.det(matrix));
    }

    @Test
    public void testRedhefferMatrix() {
        int[][] RedhefferMatrix = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        };
        assertEquals(-2, Matrix.det(RedhefferMatrix));
    }

    @Test
    public void testMiniMatrix(){
        int[][] matrix = {
                {4},
        };
        assertEquals(4, Matrix.det(matrix));
    }

    @Test
    public void testEmptyMatrix(){
        int[][] matrix = {};
        Assertions.assertThrows(IllegalArgumentException.class, ()-> Matrix.det(matrix));
    }
}