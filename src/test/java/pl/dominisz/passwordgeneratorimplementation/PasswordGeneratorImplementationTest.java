package pl.dominisz.passwordgeneratorimplementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import pl.dominisz.passwordgeneratorapi.PasswordGeneratorParameters;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorImplementationTest {

    PasswordGeneratorImplementation passwordGeneratorImplementation = new PasswordGeneratorImplementation();

    @Test
    void shouldGeneratePasswordOfProperLength() {
        PasswordGeneratorParameters passwordGeneratorParameters = new PasswordGeneratorParameters();
        passwordGeneratorParameters.setIncludeUppercaseCharacters(true);
        passwordGeneratorParameters.setIncludeLowercaseCharacters(true);
        passwordGeneratorParameters.setIncludeNumbers(true);
        passwordGeneratorParameters.setIncludeSymbols(true);

        passwordGeneratorParameters.setPasswordLength(10);

        String password = passwordGeneratorImplementation.generate(passwordGeneratorParameters);

        Assertions.assertEquals(10, password.length());
    }

    @Test
    void shouldGenerateLowercasePassword(){
        PasswordGeneratorParameters passwordGeneratorParameters = new PasswordGeneratorParameters();
        passwordGeneratorParameters.setIncludeLowercaseCharacters(true);
        passwordGeneratorParameters.setPasswordLength(10);

        String password = passwordGeneratorImplementation.generate(passwordGeneratorParameters);

        Assertions.assertEquals(10, password.length());
        Assertions.assertEquals(password, password.toLowerCase());
    }

    @Test
    void shouldThrowIllegalArgumentException(){
        PasswordGeneratorParameters passwordGeneratorParameters = new PasswordGeneratorParameters();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {passwordGeneratorImplementation.generate(passwordGeneratorParameters);});
    }

    @Test
    void shouldGenerateUppercasePassword(){
        PasswordGeneratorParameters passwordGeneratorParameters = new PasswordGeneratorParameters();
        passwordGeneratorParameters.setIncludeUppercaseCharacters(true);
        passwordGeneratorParameters.setPasswordLength(10);

        String password = passwordGeneratorImplementation.generate(passwordGeneratorParameters);

        Assertions.assertEquals(10, password.length());
        Assertions.assertEquals(password, password.toUpperCase());
    }

    @Test
    void shouldGenerateSymbolsPassword(){
        PasswordGeneratorParameters passwordGeneratorParameters = new PasswordGeneratorParameters();
        passwordGeneratorParameters.setIncludeSymbols(true);
        passwordGeneratorParameters.setPasswordLength(10);

        String password = passwordGeneratorImplementation.generate(passwordGeneratorParameters);

        Assertions.assertTrue(containsOnlySymbols(password));
    }

    private boolean containsOnlySymbols(String string){
        return string.matches("[!@#$%^&*()\\-=+]+");
    }

    @Test
    void shouldGenerateNumericPassword(){
        PasswordGeneratorParameters passwordGeneratorParameters = new PasswordGeneratorParameters();
        passwordGeneratorParameters.setIncludeNumbers(true);
        passwordGeneratorParameters.setPasswordLength(10);

        String password = passwordGeneratorImplementation.generate(passwordGeneratorParameters);

        Assertions.assertTrue(containsOnlyNumbers(password));
    }

    private boolean containsOnlyNumbers(String password) {
        return password.matches("[0-9]+");
    }
}