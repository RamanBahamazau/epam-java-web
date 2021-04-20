package parser;

import exception.CustomException;
import org.junit.jupiter.api.Test;

import static parser.BankDepositBuilder.TypeOfParser.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserUnitTest {

    @Test
    public void shouldReturnListWithSixteenSize_whenBuildBankDepositsArray_givenDomParser() throws CustomException {
        // given
        final ParserMother parser = BankDepositBuilder.buildParser(DOM);
        // when
        parser.buildBankDepositsArray(getClass().getClassLoader().getResource("bankDeposit.xml").getFile());
        // then
        assertEquals(parser.getBankDeposits().size(), 16);
    }

    @Test
    public void shouldReturnListWithSixteenSize_whenBuildBankDepositsArray_givenSaxParser() throws CustomException {
        // given
        final ParserMother parser = BankDepositBuilder.buildParser(SAX);
        // when
        parser.buildBankDepositsArray(getClass().getClassLoader().getResource("bankDeposit.xml").getFile());
        // then
        assertEquals(parser.getBankDeposits().size(), 16);
    }

    @Test
    public void shouldReturnListWithSixteenSize_whenBuildBankDepositsArray_givenStaxParser() throws CustomException {
        // given
        final ParserMother parser = BankDepositBuilder.buildParser(STAX);
        // when
        parser.buildBankDepositsArray(getClass().getClassLoader().getResource("bankDeposit.xml").getFile());
        // then
        assertEquals(parser.getBankDeposits().size(), 16);
    }

}
