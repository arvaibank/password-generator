package ltd.arvai.validator;

public class InputValidator {
    public boolean validate(String input) {
        return input.equals("Igen") || input.equals("igen") || input.equals("I") || input.equals("i") || input.equals("Ig") || input.equals("ig")  || input.equals("Ige") || input.equals("ige");
    }
}
