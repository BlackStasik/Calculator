public class ArabicCalculator implements Calculator {


    @Override
    public String add(String first, String second) {
        return String.valueOf((Integer.parseInt(first) + Integer.parseInt(second)));
    }

    @Override
    public String subtract(String first, String second) {
        return String.valueOf(Integer.parseInt(first) - Integer.parseInt(second));
    }

    @Override
    public String multiply(String first, String second) {
        return String.valueOf(Integer.parseInt(first) * Integer.parseInt(second));
    }

    @Override
    public String divide(String first, String second) {
        try {
            return String.valueOf(Integer.parseInt(first) / Integer.parseInt(second));
        }catch (ArithmeticException e){
            return "ArithmeticException";
        }
    }
}
