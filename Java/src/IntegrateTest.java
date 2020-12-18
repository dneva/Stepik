import java.util.function.DoubleUnaryOperator;

public class IntegrateTest {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double result = 0, h = (b-a)/100000000;

        for(int i = 0; i < 100000000; i++) {
            result += f.applyAsDouble(a + h * i);
        }

        result *= h;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));
    }
}

