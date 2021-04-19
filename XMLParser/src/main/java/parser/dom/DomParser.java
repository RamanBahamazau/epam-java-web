package parser.dom;

import entity.BankDeposit;
import exception.CustomException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.BankDepositBuilderMother;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DomParser extends BankDepositBuilderMother {

    private final Set<BankDeposit> arrayOfBankDeposits = new HashSet<>();
    private final DocumentBuilder documentBuilder;

    public DomParser() throws CustomException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (Exception e) {
            throw new CustomException("Parser config exception: " + e.getCause());
        }
    }

    @Override
    public void buildArrayBanks(String filename) throws CustomException {

    }

    public List<BankDeposit> getBankDeposits() {
        return new ArrayList<>(arrayOfBankDeposits);
    }

    public void buildArray(String filename) throws CustomException {
        try {
            Document doc = documentBuilder.parse(new File(filename));
            doc.getDocumentElement().normalize();
            Element root = doc.getDocumentElement();

            NodeList banksList = root.getElementsByTagName("bank");
            for (int i = 0; i < banksList.getLength(); i++) {
                Element bankElement = (Element) banksList.item(i);
                BankDeposit bankDeposit = buildBank(bankElement);
                arrayOfBankDeposits.add(bankDeposit);
            }
        } catch (Exception e) {
            throw new CustomException("Parsing problem, file not found: " + e.getCause());
        }
    }

    private BankDeposit buildBank(Element bankDepositElement) {
        String id = getElementTextContent(bankDepositElement, "id");
        String name = getElementTextContent(bankDepositElement, "bank-name");
        String country = getElementTextContent(bankDepositElement, "registration-in-country");
        String type = getElementTextContent(bankDepositElement, "type-of-deposit");
        String depositor = getElementTextContent(bankDepositElement, "depositors-name");
        String accountId = getElementTextContent(bankDepositElement, "account-id");
        String amountOnDeposit = getElementTextContent(bankDepositElement, "deposit-amount");
        String profitability = getElementTextContent(bankDepositElement, "annual-percentage");
        String timeConstraints = getElementTextContent(bankDepositElement, "term-of-deposit");;

        return new BankDeposit(id, name, country, type, depositor, accountId, amountOnDeposit, profitability, timeConstraints);
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }

}
