import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static Calculator calculator;
    private static String first;
    private static String second;

    private static void createCalculator(String line){
        if(Pattern.compile( "[0-9]" ).matcher(line).find()){
            calculator = new ArabicCalculator();
        }else {
            calculator = new RomalCalculator();
        }
    }

    private static String getResult(String line){
        String c = "";
        try {
            first = line.split(" ")[0];
            c = line.split(" ")[1];
            second = line.split(" ")[2];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Uncorrected!");
        }

        try {
            switch (c){
                case "+": return calculator.add(first, second);
                case "-": return calculator.subtract(first, second);
                case "*": return calculator.multiply(first, second);
                case "/": return calculator.divide(first, second);
                default: return "Not supported!";
            }
        }catch (NumberFormatException e){
            return "NumberFormatException";
        }
    }

    public static void main(String[] args) {

        boolean isToDo = true;
        Scanner scanner = new Scanner(System.in);
        String line;

        while (isToDo){
            System.out.println("Enter expresion:");
            line = scanner.nextLine();
            createCalculator(line);

            System.out.println("Result: " + getResult(line));

            System.out.println("Continue?(y/n)");
            if ("n".equals(scanner.nextLine())){
                isToDo = false;
            }

        }

    }
}
