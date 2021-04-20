package parser.sax;

import entity.BankDeposit;
import exception.CustomException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import parser.ParserMother;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class SaxParser extends ParserMother {

    @Override
    public void buildBankDepositsArray(String filename) throws CustomException {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            XMLReader reader = parser.getXMLReader();

            SaxXmlHandler saxXmlHandler = new SaxXmlHandler();
            reader.setContentHandler(saxXmlHandler);
            reader.parse(filename);

            SaxXmlHandler sax = (SaxXmlHandler) reader.getContentHandler();
            bankDeposits = sax.getListBankDeposit();
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new CustomException("Some problem with SAX parsing: " + e.getCause());
        }
    }

}
