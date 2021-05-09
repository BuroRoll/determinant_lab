import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("Тесты для проверки решения систем линейных уравнений методом Крамера")
class TestKramer {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testCorrectSolutions(){
        int[][] k = {
                {1, 1, 1},
                {2, -1, -6},
                {3, -2, 0},

        };
        int[] f = {2, -1, 8};
        assertArrayEquals(new double[]{2.0, -1.0, 1.0}, Kramer.solve(k, f));
    }

    @Test
    public void testNoSolutions(){
        int[][] k = {
                {2, -1, 3},
                {3, -5, 1},
                {4, -7, 1},
        };
        int[] f = {9, -4, 5};
        Kramer.solve(k, f);
        assertEquals("Решений нет", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void testInfSolutions() {
        int[][] k = {
                {1, 2, -3, 5},
                {1, 3, -13, 22},
                {3, 5, 1, -2},
                {2, 3, 4, -7},
        };
        int[] f = {1, -1, 5, 4};
        Kramer.solve(k, f);
        assertEquals("Система имеет бесконечное количество решений", outputStreamCaptor.toString()
                .trim());
    }
}