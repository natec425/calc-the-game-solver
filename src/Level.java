import java.util.ArrayList;
import java.util.List;

public class Level {
    private Integer levelNumber;
    private List<Action> actions;
    private Integer goal;
    private Integer moves;
    public Double number;

    public Level(Integer levelNumber, List<Action> actions, Integer goal, Integer moves, Double number) {
        this.levelNumber = levelNumber;
        this.actions = actions;
        this.goal = goal;
        this.moves = moves;
        this.number = number;
    }

    public ArrayList<Action> solve() {
        if (number == goal.doubleValue()) {
            return new ArrayList();
        } else if (moves == 0) {
            return null;
        } else {
            for (var action : actions) {
                var nextLevel = run(action);
                var solveResult = nextLevel.solve();
                if (solveResult != null) {
                    solveResult.add(0, action);
                    return solveResult;
                }
            }
            return null;
        }
    }

    @Override
    public String toString(){
        return "Level{" +
                "levelNumber=" + levelNumber +
                ", goal=" + goal +
                ", moves=" + moves +
                ", number=" + number +
                "}";
    }

    public Level run(Action action) {
        return new Level(
                levelNumber,
                actions,
                goal,
                moves - 1,
                action.doTheMath(number)
        );
    }

    public Action hint() {
        return solve().get(0);
    }
}
