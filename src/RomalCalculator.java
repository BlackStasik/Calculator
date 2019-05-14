import java.util.HashMap;
import java.util.Map;

public class RomalCalculator implements Calculator {

    private Map<Integer, String> numbers;

    public RomalCalculator() {
        this.numbers = new HashMap<Integer, String>();
        this.numbers.put(1, "I");
        this.numbers.put(2, "II");
        this.numbers.put(3, "III");
        this.numbers.put(4, "IV");
        this.numbers.put(5, "V");
        this.numbers.put(6, "VI");
        this.numbers.put(7, "VII");
        this.numbers.put(8, "VIII");
        this.numbers.put(9, "IX");
        this.numbers.put(10, "X");
        this.numbers.put(11, "XI");
        this.numbers.put(12, "XII");
        this.numbers.put(13, "XIII");
        this.numbers.put(14, "XIV");
        this.numbers.put(15, "XV");
        this.numbers.put(16, "XVI");
        this.numbers.put(17, "XVII");
        this.numbers.put(18, "XVIII");
        this.numbers.put(19, "XIX");
        this.numbers.put(20, "XX");
    }

    private Integer toArabic(String roman){
        return numbers.entrySet().stream()
                .filter(x -> x.getValue().equals(roman))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
    }

    private String toRoman(Integer arabic){
        return numbers.entrySet().stream()
                .filter(x -> x.getKey().equals(arabic))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse("Not supported.");
    }

    @Override
    public String add(String first, String second) {
        System.out.println(toArabic(first));
        return toRoman(toArabic(first) + toArabic(second));
    }

    @Override
    public String subtract(String first, String second) {
        return toRoman(toArabic(first) - toArabic(second));
    }

    @Override
    public String multiply(String first, String second) {
        return toRoman(toArabic(first) * toArabic(second));
    }

    @Override
    public String divide(String first, String second) {
        return toRoman(toArabic(first) / toArabic(second));
    }
}
