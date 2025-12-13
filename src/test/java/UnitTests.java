import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;

import util.Util;
import java.util.ArrayList;

public class UnitTests {

    // =========================
    // Address Tests
    // =========================

    @Test
    @DisplayName("Valid postal code: A1B2C3")
    void testValidPostalCode() {
        String postalCode = "A1B2C3";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }
