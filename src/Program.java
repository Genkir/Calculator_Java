import java.util.Scanner;
import static  java.lang.System.*;

public class Program {
    public static void main(String[] args) {
        ArrayMath calc = new ArrayMath();
        int result;
        boolean repeat = true;
        Scanner in = new Scanner(System.in);
        while (repeat) {
            try {
                String line = in.nextLine();
                LineChecking.LineChecks(line);
                result = calc.Calculator(line);
                out.println(result);
            } catch (MissInputException ex) {
                out.print(ex.getMessage());
                out.print(ex.getNumber());
                out.println(" position");
                repeat = false;
            }
        }
    }
}
