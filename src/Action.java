import java.util.function.Function;

public class Action {
    private Function<Double, Double> operation;
    private String description;

    public Action(Function<Double, Double> operation, String description) {
        this.operation = operation;
        this.description = description;
    }

    public Double doTheMath(Double number) {
        return operation.apply(number);
    }

    @Override
    public String toString() {
        return description;
    }

    public static Action replace(String s, String s1) {
        return new Action(
            num -> replace(num, s, s1) ,
            String.format("%s => %s", s, s1)
        );
    }


    public static Action add(Double i) {
        return new Action(
            num -> num + i,
            String.format("+ %s", i)
        );
    }

    public static Action div(Double i) {
        return new Action(
            num -> num / i,
            String.format("/ %s", i)
        );
    }


    private static Double replace(Double num, String s, String s1) {
        return Double.parseDouble(num.toString().replace(s, s1));
    }
}
