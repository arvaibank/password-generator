package ltd.arvai.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {
    Generator generator;

    @BeforeEach
    void setup() {
        generator = new Generator();
    }


    @Test
    void testGeneratePasswordLengthShouldBe3() {
        int lengthOfPassword = 3;

        int expected = 3;
        String actual = generator.generatePassword(lengthOfPassword);

        Assertions.assertEquals(expected, actual.length());
    }

    @Test
    void testGeneratePasswordShouldContainAtLeastOneUppercaseLetter() {
        int lengthOfPassword = 8;
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String regexPattern = "[" + Pattern.quote(symbols) + "]";
        Pattern pattern = Pattern.compile(regexPattern);

        String actual = generator.generatePassword(lengthOfPassword);
        Matcher matcher = pattern.matcher(actual);

        boolean matcherAssertion = matcher.find();
        Assertions.assertTrue(matcherAssertion);
    }

    @Test
    void testGeneratePasswordShouldContainAtLeastOneLowercaseLetter() {
        int lengthOfPassword = 8;
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        String regexPattern = "[" + Pattern.quote(symbols) + "]";
        Pattern pattern = Pattern.compile(regexPattern);

        String actual = generator.generatePassword(lengthOfPassword);
        Matcher matcher = pattern.matcher(actual);

        boolean matcherAssertion = matcher.find();
        Assertions.assertTrue(matcherAssertion);
    }

    @Test
    void testGeneratePasswordShouldContainAtLeastOneSymbol() {
        int lengthOfPassword = 8;
        String symbols = "!@#$%^&*()_+-=[]{}|;:,.<>?";
        String regexPattern = "[" + Pattern.quote(symbols) + "]";
        Pattern pattern = Pattern.compile(regexPattern);

        String actual = generator.generatePassword(lengthOfPassword);
        Matcher matcher = pattern.matcher(actual);

        boolean matcherAssertion = matcher.find();
        Assertions.assertTrue(matcherAssertion);
    }

    @Test
    void testGeneratePasswordShouldContainAtLeastOneNumber() {
        int lengthOfPassword = 8;
        String symbols = "0123456789";
        String regexPattern = "[" + Pattern.quote(symbols) + "]";
        Pattern pattern = Pattern.compile(regexPattern);

        String actual = generator.generatePassword(lengthOfPassword);
        Matcher matcher = pattern.matcher(actual);

        boolean matcherAssertion = matcher.find();
        Assertions.assertTrue(matcherAssertion);
    }
    

}