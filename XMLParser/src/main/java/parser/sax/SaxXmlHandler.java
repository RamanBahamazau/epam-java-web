package parser.sax;

import static parser.BankDepositTag.*;

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
    private Long id = 1L;
    private String name;
    private String country;
    private DepositType type;
    private String depositor;
    private String accountId;
    private Double amountOnDeposit;
    private Double profitability;

    private final Set<BankDeposit> listBankDeposit = new HashSet<>();

    private final Logger logger = LogManager.getLogger();

    @Override
    public void startDocument() {
        logger.info("SAX parsing started");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        String value = attributes.getValue("id");
        if (value != null) {
            id = Long.parseLong(value);
        }
        currentElement = qName;
        logger.info(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String information = new String(ch, start, length).replace("\n", "").trim();
        if (currentElement == null || information.isEmpty() || information.contains("<")) {
            return;
        }

        if (currentElement.equals(NAME.getId())) {
            name = information;
        } else if (currentElement.equals(COUNTRY.getId())) {
            country = information;
        } else if (currentElement.equals(TYPE.getId())) {
            type = DepositType.valueOf(information);
        } else if (currentElement.equals(DEPOSITOR.getId())) {
            depositor = information;
        } else if (currentElement.equals(ACCOUNT_ID.getId())) {
            accountId = information;
        } else if (currentElement.equals(AMOUNT_ON_DEPOSIT.getId())) {
            amountOnDeposit = Double.parseDouble(information);
        } else if (currentElement.equals(PROFITABILITY.getId())) {
            profitability = Double.parseDouble(information);
        } else if (currentElement.equals(TIME_CONSTRAINTS.getId())) {
            LocalDateTime timeConstraints = LocalDateTime.parse(information, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            BankDeposit bankDeposit = new BankDeposit(id, name, country, type, depositor, accountId, amountOnDeposit, profitability, timeConstraints);
            listBankDeposit.add(bankDeposit);
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

    public Set<BankDeposit> getListBankDeposit() {
        return listBankDeposit;
    }

}
