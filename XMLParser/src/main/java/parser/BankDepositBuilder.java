package parser;

import exception.CustomException;
import parser.dom.DomParser;
import parser.sax.SaxParser;
import parser.stax.StaxParser;

import java.util.Locale;

public class BankDepositBuilder {

    private enum TypeOfParser{
        DOM,
        SAX,
        STAX
    }

    public static BankDepositBuilderMother createXML(String typeOfParser) throws CustomException {
        TypeOfParser type = TypeOfParser.valueOf(typeOfParser.toLowerCase(Locale.ROOT));
        switch (type){
            case DOM:
                return new DomParser();
            case SAX:
                return new SaxParser();
            case STAX:
                return new StaxParser();
            default:
                throw new CustomException("Wrong type of parser");
        }
    }

}
