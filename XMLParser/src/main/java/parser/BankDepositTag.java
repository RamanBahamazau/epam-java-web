package parser;

public enum BankDepositTag {
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

    BankDepositTag(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
