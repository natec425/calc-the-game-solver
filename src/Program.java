import java.util.Arrays;


public class Program {
    public static void main(String[] args) {
        var level = new Level(
                32,
                Arrays.asList(
                        Action.div(2.0),
                        Action.add(3.0),
                        Action.replace("1", "2"),
                        Action.replace("2", "9")),
                29,
                5,
                11.0);
        System.out.println(level.solve());
    }
}
