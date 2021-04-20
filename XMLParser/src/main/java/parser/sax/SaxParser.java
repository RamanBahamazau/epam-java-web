package parser.sax;

import exception.CustomException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import parser.BankDepositBuilderMother;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParser extends BankDepositBuilderMother {

    public SaxParser(){}

    @Override
    public void buildBankDepositsArray(String filename) throws CustomException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();

            SaxXmlHandler saxXmlHandler = new SaxXmlHandler();
            reader.setContentHandler(saxXmlHandler);
            reader.parse(filename);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new CustomException("Some problem with SAX parsing: " + e.getCause());
        }
    }

}
