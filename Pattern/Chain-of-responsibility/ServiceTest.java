import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ServiceTest {

    @Test
    void testMain() {
        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Run the main method
        Service.main(null);

        // Restore System.out
        System.setOut(originalOut);

        // Verify the output
        String expectedOutput = "LoggingHandler" + System.lineSeparator() +
                                "AuthenticationHandler" + System.lineSeparator() +
                                "AuthorizationHandler" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}
