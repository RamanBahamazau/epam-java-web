package parser.stax;

import exception.CustomException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static javax.xml.stream.XMLStreamConstants.*;

public class StaxXmlHandler {

    public StringBuilder processXMLFile(File xmlFile) throws FileNotFoundException, XMLStreamException, CustomException {
        StringBuilder stringBuilder = new StringBuilder();
        XMLStreamReader xmlStreamReader = (XMLInputFactory.newInstance()).createXMLStreamReader(new FileInputStream(xmlFile));
        while (xmlStreamReader.hasNext()) {
            switch (xmlStreamReader.next()) {
                case START_ELEMENT:
                    stringBuilder.append("<").append(xmlStreamReader.getLocalName()).append(">");
                    break;
                case CHARACTERS:
                    if (!xmlStreamReader.isWhiteSpace()) {
                        stringBuilder.append(xmlStreamReader.getText());
                    }
                    break;
                case END_ELEMENT:
                    stringBuilder.append("</").append(xmlStreamReader.getLocalName()).append(">");
                    break;
                default:
                    break;
            }
        }
        return stringBuilder;
    }

}
