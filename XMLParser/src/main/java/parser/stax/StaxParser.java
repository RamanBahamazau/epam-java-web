package parser.stax;

import exception.CustomException;
import parser.BankDepositBuilderMother;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.StringWriter;

public class StaxParser extends BankDepositBuilderMother {

    public void staxParser(String path) throws CustomException, XMLStreamException, FileNotFoundException, TransformerException {
        System.out.println(transformXML(4, (new StaxXmlHandler()).processXMLFile(new File(path))));
    }

    public String transformXML(int indentation, StringBuilder rawXML) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute("indent-number", indentation);
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult streamResult = new StreamResult(new StringWriter());
        transformer.transform(new StreamSource(new StringReader(rawXML.toString())), streamResult);

        return streamResult.getWriter().toString();
    }

    @Override
    public void buildArrayBanks(String filename) throws CustomException {

    }

}
