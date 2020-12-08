package problems;

/**
 * author yg
 * description
 * date 2020/12/8
 */
public class InterpretGoal {
    public String interpret(String command) {
        command = command.replace("()", "o");
        command = command.replace("(al)", "al");
        return command;
    }
}
