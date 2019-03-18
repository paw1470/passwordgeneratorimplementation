package pl.dominisz.passwordgeneratorimplementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.dominisz.passwordgeneratorapi.PasswordGeneratorParameters;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorImplementationTest {

    PasswordGeneratorImplementation passwordGeneratorImplementation = new PasswordGeneratorImplementation();

    @Test
    void shouldGeneratePasswordOfProperLength() {
        PasswordGeneratorParameters passwordGeneratorParameters = new PasswordGeneratorParameters();
        passwordGeneratorParameters.setPasswordLength(10);
        String password = passwordGeneratorImplementation.generate(passwordGeneratorParameters);
        Assertions.assertEquals(10, password.length());
    }
}