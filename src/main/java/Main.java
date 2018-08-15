import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {
    private static final double EPS = 1e-6;
    private static double t = 2.2;
    private static double start = 0.2;
    private static double finish = 2.0;
    private static double step = 0.004;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        double[] yArray = getYArray(getXArray(start, finish, step));
        double avarage = getAvarage(yArray);
        System.out.println("avarage = " + avarage);
        int max = getMax(yArray);
        System.out.println("max = " + max);
        int min = getMin(yArray);
        System.out.println("min = " + min);
        double sum = getSum(yArray);
        System.out.println("sum = " + sum);
    }

    public double functionValue(double x) {
        return x <= 0.9 + EPS
                ?
                (Math.pow(Math.log(x), 3) + x * x) / Math.sqrt(x + t)
                :
                Math.cos(x) + t * Math.pow(Math.sin(x), 2);
    }

    public int getStepAmount(double start, double finish, double step) {
        return (int) ((finish-start)/step+1);
    }

    public double[] getXArray(double start, double finish, double step) {
        return DoubleStream.iterate(0.2,d->d+step).limit(getStepAmount(start, finish, step)).toArray();
    }

    public double[] getYArray(double[] xArray) {
        return Arrays.stream(xArray).map(this::functionValue).toArray();
    }

    public int getMax(double[] arr) {
        int max;
        if (arr!=null&&arr.length>0) {
            max = 0;
            for (int i = 1; i < arr.length; i++) {
                max = arr[max]>arr[i]?max:i;
            }
        }else {
            max = -1;
        }
        return max;
    }

    public int getMin(double[] arr) {
        int min;
        if (arr!=null&&arr.length>0) {
            min = 0;
            for (int i = 1; i < arr.length; i++) {
                min = arr[min]<arr[i]?min:i;
            }
        }else {
            min = -1;
        }
        return min;
    }

    public double getAvarage(double[] arr) {
        OptionalDouble average = Arrays.stream(arr).average();
        return average.isPresent()?average.getAsDouble():EPS;
    }

    public double getSum(double[] arr) {
        return Arrays.stream(arr).sum();
    }
}
