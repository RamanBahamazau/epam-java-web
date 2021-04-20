package parser;

import exception.CustomException;
import parser.dom.DomParser;
import parser.sax.SaxParser;
import parser.stax.StaxParser;

public class BankDepositBuilder {

    public enum TypeOfParser{
        DOM,
        SAX,
        STAX
    }

    public static ParserMother buildParser(TypeOfParser typeOfParser) throws CustomException {
        switch (typeOfParser){
            case DOM:
                return new DomParser();
            case SAX:
                return new SaxParser();
            case STAX:
                return new StaxParser();
            default:
                throw new CustomException("Unexpected type of parser!");
        }
    }

}
