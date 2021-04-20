package parser.sax;

import static parser.ParserMother.BankDepositTags.*;

import entity.BankDeposit;
import entity.DepositType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class SaxXmlHandler extends DefaultHandler {

    private String currentElement;
    private Long id;
    private String name;
    private String country;
    private DepositType type;
    private String depositor;
    private String accountId;
    private Double amountOnDeposit;
    private Double profitability;

    public static final Set<BankDeposit> arrayList = new HashSet<>();

    private final Logger logger = LogManager.getLogger();

    @Override
    public void startDocument() {
        logger.info("SAX parsing started");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;
        logger.info(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String information = new String(ch, start, length).replace("\n", "").trim();
        if (information.contains("<") || currentElement == null || information.isEmpty()) {
            return;
        }

        switch (valueOf(currentElement)) {
            case ID:
                id = Long.parseLong(information);
                break;
            case NAME:
                name = information;
                break;
            case COUNTRY:
                country = information;
                break;
            case TYPE:
                type = DepositType.valueOf(information);
                break;
            case DEPOSITOR:
                depositor = information;
                break;
            case ACCOUNT_ID:
                accountId = information;
                break;
            case AMOUNT_ON_DEPOSIT:
                amountOnDeposit = Double.parseDouble(information);
                break;
            case PROFITABILITY:
                profitability = Double.parseDouble(information);
                break;
            case TIME_CONSTRAINTS:
                LocalDateTime timeConstraints = LocalDateTime.parse(information, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                BankDeposit bankDeposit = new BankDeposit(id, name, country, type, depositor, accountId, amountOnDeposit, profitability, timeConstraints);
                arrayList.add(bankDeposit);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        logger.info("Element has ended");
    }

    @Override
    public void endDocument() {
        logger.info("SAX parsing ended");
    }

}
