package parser;

import entity.BankDeposit;
import exception.CustomException;

import java.util.HashSet;
import java.util.Set;

public abstract class ParserMother {

    public enum BankDepositTags {
        ID("id"),
        NAME("name"),
        COUNTRY("country"),
        TYPE("type"),
        DEPOSITOR("depositor"),
        ACCOUNT_ID("account-id"),
        AMOUNT_ON_DEPOSIT("amount-on-deposit"),
        PROFITABILITY("profitability"),
        TIME_CONSTRAINTS("time-constraints");

        private final String id;

        BankDepositTags(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

    protected Set<BankDeposit> bankDeposits;

    public ParserMother(Set<BankDeposit> bankDeposits){
        this.bankDeposits = bankDeposits;
    }

    protected ParserMother() {
        bankDeposits = new HashSet<>();
    }

    public Set<BankDeposit> getBankDeposits() throws CustomException {
        if (bankDeposits.isEmpty()){
            throw new CustomException("Array is empty");
        }
        return new HashSet<>(bankDeposits);
    }

    public abstract void buildBankDepositsArray(String filename) throws CustomException;

}
