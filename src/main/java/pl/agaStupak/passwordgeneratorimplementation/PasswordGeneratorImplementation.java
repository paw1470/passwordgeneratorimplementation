package pl.agaStupak.passwordgeneratorimplementation;

import pl.agaStupak.passwordgeneratorapi.PasswordGeneratorParameters;
import pl.agaStupak.passwordgeneratorapi.PasswordGeneratorService;

import java.util.List;
import java.util.Random;

public class PasswordGeneratorImplementation implements PasswordGeneratorService {

    private static final Random RANDOM = new Random();
    private static final String LOWERCASE_CHARACTERS = "qwertyuiopasdfghjklzxcvbnm";
    private static final String UPPERCASE_CHARACTERS = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String SYMBOLS = "!@#$%^&*()-=+";
    private static final String NUMBERS = "0123456789";

    public String generate(PasswordGeneratorParameters passwordGeneratorParameters) {
        if(isInvalid(passwordGeneratorParameters)){
            throw new IllegalArgumentException();
        }
        String alphabet = generateAlphabet(passwordGeneratorParameters);
        String password = generateRequiredTypes(passwordGeneratorParameters);
        int passwordLen = password.length();
        for (int i = 0; i < passwordGeneratorParameters.getPasswordLength() -passwordLen; i++) {
            password += getRandomChar(alphabet);
        }
        return password;
    }

    private String generateAlphabet(PasswordGeneratorParameters passwordGeneratorParameters) {
        String alphabet = "";
        if(passwordGeneratorParameters.isIncludeLowercaseCharacters()){
            alphabet += LOWERCASE_CHARACTERS;
        }
        if(passwordGeneratorParameters.isIncludeUppercaseCharacters()){
            alphabet += UPPERCASE_CHARACTERS;
        }
        if(passwordGeneratorParameters.isIncludeSymbols()){
            alphabet += SYMBOLS;
        }
        if(passwordGeneratorParameters.isIncludeNumbers()){
            alphabet += NUMBERS;
        }
        return alphabet;
    }

    private String generateRequiredTypes(PasswordGeneratorParameters passwordGeneratorParameters) {
        String password = "";
        if(passwordGeneratorParameters.isIncludeLowercaseCharacters()){
            password += getRandomChar(LOWERCASE_CHARACTERS);
        }
        if(passwordGeneratorParameters.isIncludeUppercaseCharacters()){
            password += getRandomChar(UPPERCASE_CHARACTERS);
        }
        if(passwordGeneratorParameters.isIncludeSymbols()){
            password += getRandomChar(SYMBOLS);
        }
        if(passwordGeneratorParameters.isIncludeNumbers()){
            password += getRandomChar(NUMBERS);
        }
        return password;
    }

    private char getRandomChar(String alphabet) {
        return alphabet.charAt(RANDOM.nextInt(alphabet.length()));
    }


    private boolean isInvalid(PasswordGeneratorParameters passwordGeneratorParameters) {
        return passwordGeneratorParameters.getPasswordLength() <= 0
                || !(passwordGeneratorParameters.isIncludeLowercaseCharacters()
                || passwordGeneratorParameters.isIncludeNumbers()
                || passwordGeneratorParameters.isIncludeSymbols()
                || passwordGeneratorParameters.isIncludeUppercaseCharacters());
    }


    public List<String> generate(PasswordGeneratorParameters passwordGeneratorParameters, int count) {
        return null;
    }
}
