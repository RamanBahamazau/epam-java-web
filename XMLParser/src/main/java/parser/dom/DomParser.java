package parser.dom;

import static parser.ParserMother.BankDepositTags.*;

import entity.BankDeposit;
import exception.CustomException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.ParserMother;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.stream.IntStream;

public class DomParser extends ParserMother {

    private final DocumentBuilder documentBuilder;

    public DomParser() throws CustomException {
        try {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (Exception e) {
            throw new CustomException("Document builder configuration exception: " + e.getCause());
        }
    }

    @Override
    public void buildBankDepositsArray(String filename) throws CustomException {
        try {
            File file = new File(filename);
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();

            NodeList banksList = root.getElementsByTagName("bankDeposit");
            IntStream.range(0, banksList.getLength())
                    .mapToObj(i -> (Element) banksList.item(i))
                    .map(this::buildBank)
                    .forEach(bankDeposits::add);
        } catch (Exception e) {
            throw new CustomException("Parsing problem, file not found: " + e.getCause());
        }
    }

    private BankDeposit buildBank(Element bankDepositElement) {
        String id = bankDepositElement.getAttribute(ID.getId());
        String name = getElementTextContent(bankDepositElement, NAME);
        String country = getElementTextContent(bankDepositElement, COUNTRY);
        String type = getElementTextContent(bankDepositElement, TYPE);
        String depositor = getElementTextContent(bankDepositElement, DEPOSITOR);
        String accountId = getElementTextContent(bankDepositElement, ACCOUNT_ID);
        String amountOnDeposit = getElementTextContent(bankDepositElement, AMOUNT_ON_DEPOSIT);
        String profitability = getElementTextContent(bankDepositElement, PROFITABILITY);
        String timeConstraints = getElementTextContent(bankDepositElement, TIME_CONSTRAINTS);

        return new BankDeposit(id, name, country, type, depositor, accountId, amountOnDeposit, profitability, timeConstraints);
    }

    private static String getElementTextContent(Element element, BankDepositTags elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName.getId());
        Node node = nodeList.item(0);
        return node.getTextContent();
    }

}
