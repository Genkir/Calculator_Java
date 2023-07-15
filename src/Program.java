import java.util.Scanner;
import static  java.lang.System.*;

public class Program {


    public static void main (String[] args) {
        ArrayMath calc = new ArrayMath();
        int result;
        boolean t = true;
        Scanner in = new Scanner(System.in);
        while (t) {
            String a = in.nextLine();
            if (LineChecking.LineChecks(a)) {
                out.println("Incorrect input");
                t=false;
            } else {
                result = calc.Calculator(a);
                out.println(result);
            }
        }
    }
}
