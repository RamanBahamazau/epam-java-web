package parser.stax;

import entity.BankDeposit;
import entity.DepositType;
import exception.CustomException;
import parser.ParserMother;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static javax.xml.stream.XMLStreamConstants.CHARACTERS;
import static javax.xml.stream.XMLStreamConstants.START_ELEMENT;
import static parser.BankDepositTag.*;
import static parser.BankDepositTag.TIME_CONSTRAINTS;

public class StaxParser extends ParserMother {

    @Override
    public void parse(String filePath) {
        File file = new File(filePath);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            XMLStreamReader xmlStreamReader = (XMLInputFactory.newInstance()).createXMLStreamReader(fileInputStream);

            String localeName = null;

            Long id = null;
            String name = null;
            String country = null;
            DepositType type = null;
            String depositor = null;
            String accountId = null;
            Double amountOnDeposit = null;
            Double profitability = null;
            while (xmlStreamReader.hasNext()) {
                int index = xmlStreamReader.next();
                switch (index) {
                    case START_ELEMENT:
                        if (xmlStreamReader.getAttributeCount() > 0) {
                            id = Long.parseLong(xmlStreamReader.getAttributeValue(0));
                        } else {
                            localeName = xmlStreamReader.getLocalName();
                        }
                        break;
                    case CHARACTERS:
                        if (!xmlStreamReader.isWhiteSpace()) {
                            String text = xmlStreamReader.getText();
                            if (localeName.equals(NAME.getId())) {
                                name = text;
                            } else if (localeName.equals(COUNTRY.getId())) {
                                country = text;
                            } else if (localeName.equals(TYPE.getId())) {
                                type = DepositType.valueOf(text);
                            } else if (localeName.equals(DEPOSITOR.getId())) {
                                depositor = text;
                            } else if (localeName.equals(ACCOUNT_ID.getId())) {
                                accountId = text;
                            } else if (localeName.equals(AMOUNT_ON_DEPOSIT.getId())) {
                                amountOnDeposit = Double.parseDouble(text);
                            } else if (localeName.equals(PROFITABILITY.getId())) {
                                profitability = Double.parseDouble(text);
                            } else if (localeName.equals(TIME_CONSTRAINTS.getId())) {
                                LocalDateTime timeConstraints = LocalDateTime.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                                BankDeposit bankDeposit = new BankDeposit(id, name, country, type, depositor, accountId, amountOnDeposit, profitability, timeConstraints);
                                bankDeposits.add(bankDeposit);
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            new CustomException("Stax Parser exception: " + e.getMessage());
        }
    }

}
