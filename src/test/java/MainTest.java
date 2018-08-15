import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main main;
    private static final double EPS = 1e-6;

    @Test
    void functionValue1() {
        double x = 0.2;
        double expected = -2.66520095441;
        double result = main.functionValue(x);

        assertEquals(expected,result,EPS);
    }

    @Test
    void functionValue2() {
        double x = 1.0;
        double expected = 2.09806382607;
        double result = main.functionValue(x);

        assertEquals(expected,result,EPS);
    }

    @Test
    void getStepAmount() {
        double start = 0.2;
        double finish = 2.0;
        double step = 0.004;
        int expected = 451;
        int result = main.getStepAmount(start,finish,step);

        assertEquals(expected,result);
    }

    @Test
    void getXArray() {
        double start = 0.2;
        double finish = 2.0;
        double step = 0.004;
        double[] expected = {0.2,0.9,2.0};
        double[] x = main.getXArray(start,finish,step);

        assertEquals(expected[0],x[0],EPS);
        assertEquals(expected[1],x[175],EPS);
        assertEquals(expected[2],x[450],EPS);
    }

    @Test
    void getYArray() {
        double start = 0.2;
        double finish = 2.0;
        double step = 0.004;
        double[] expected = {-2.66520095441,0.45938480323,1.4028611464};

        double[] x = main.getYArray(main.getXArray(start,finish,step));

        assertEquals(expected[0],x[0],EPS);
        assertEquals(expected[1],x[175],EPS);
        assertEquals(expected[2],x[450],EPS);
    }

    @Test
    void getMax() {
        double[] arr = {2.0,4.9,-9,-0.0087,123.009};
        int expected = 4;
        int max = main.getMax(arr);

        assertEquals(expected,max);
    }

    @Test
    void getMin() {
        double[] arr = {2.0,4.9,-9,-0.0087,123.009};
        int expected = 2;
        int min = main.getMin(arr);

        assertEquals(expected,min);
    }

    @Test
    void getAvarage() {
        double[] arr = {2.0,4.9,-9,-0.0087,123.009};
        double expected = 24.18006;
        double avarage = main.getAvarage(arr);

        assertEquals(expected,avarage,EPS);
    }

    @Test
    void getSum() {
        double[] arr = {2.0,4.9,-9,-0.0087,123.009};
        double expected = 120.9003;
        double sum = main.getSum(arr);

        assertEquals(expected,sum,EPS);
    }

    @BeforeEach
    void setUp() {
        main = new Main();
    }
}