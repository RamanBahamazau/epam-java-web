package parser;

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

}
