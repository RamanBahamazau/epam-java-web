package parser.dom;

import exception.CustomException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DomParserUnitTest {

    private static DomParser domParser;

    @BeforeAll
    public static void setUp() {
        try {
            domParser = new DomParser();
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldReturnListWithSixteenSize_whenBuildBankDepositsArray_given() throws CustomException {
        // when
        domParser.buildBankDepositsArray(getClass().getClassLoader().getResource("bankDeposit.xml").getFile());
        // then
        assertEquals(domParser.getBankDeposits().size(), 16);
    }
}
