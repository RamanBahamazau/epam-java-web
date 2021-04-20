package parser.sax;

import exception.CustomException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import parser.ParserMother;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParser extends ParserMother {

    @Override
    public void parse(String filePath) throws CustomException {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            XMLReader reader = parser.getXMLReader();

            SaxXmlHandler saxXmlHandler = new SaxXmlHandler();
            reader.setContentHandler(saxXmlHandler);
            reader.parse(filePath);

            SaxXmlHandler sax = (SaxXmlHandler) reader.getContentHandler();
            bankDeposits = sax.getListBankDeposit();
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new CustomException("Some problem with SAX parsing: " + e.getCause());
        }
    }

}
