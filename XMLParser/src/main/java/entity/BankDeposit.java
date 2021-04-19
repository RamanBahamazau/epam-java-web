package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class BankDeposit {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private final Long id;
    private final String name;
    private final String country;
    private final DepositType type;
    private final String depositor;
    private final String accountId;
    private final Double amountOnDeposit;
    private final Double profitability;
    private final LocalDateTime timeConstraints;

    public BankDeposit(
            Long id,
            String name,
            String country,
            DepositType type,
            String depositor,
            String accountId,
            Double amountOnDeposit,
            Double profitability,
            LocalDateTime timeConstraints) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.type = type;
        this.depositor = depositor;
        this.accountId = accountId;
        this.amountOnDeposit = amountOnDeposit;
        this.profitability = profitability;
        this.timeConstraints = timeConstraints;
    }

    public BankDeposit(
            String id,
            String name,
            String country,
            String type,
            String depositor,
            String accountId,
            String amountOnDeposit,
            String profitability,
            String timeConstraints) {
        this.id = Long.parseLong(id);
        this.name = name;
        this.country = country;
        this.type = DepositType.valueOf(type);
        this.depositor = depositor;
        this.accountId = accountId;
        this.amountOnDeposit = Double.parseDouble(amountOnDeposit);
        this.profitability = Double.parseDouble(profitability);
        this.timeConstraints = LocalDateTime.parse(timeConstraints, DATE_TIME_FORMATTER);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public DepositType getType() {
        return type;
    }

    public String getDepositor() {
        return depositor;
    }

    public String getAccountId() {
        return accountId;
    }

    public Double getAmountOnDeposit() {
        return amountOnDeposit;
    }

    public Double getProfitability() {
        return profitability;
    }

    public LocalDateTime getTimeConstraints() {
        return timeConstraints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankDeposit bankDeposit = (BankDeposit) o;
        return Objects.equals(id, bankDeposit.id) && Objects.equals(name, bankDeposit.name) && Objects.equals(country, bankDeposit.country) && Objects.equals(type, bankDeposit.type) && Objects.equals(depositor, bankDeposit.depositor) && Objects.equals(accountId, bankDeposit.accountId) && Objects.equals(amountOnDeposit, bankDeposit.amountOnDeposit) && Objects.equals(profitability, bankDeposit.profitability) && Objects.equals(timeConstraints, bankDeposit.timeConstraints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, type, depositor, accountId, amountOnDeposit, profitability, timeConstraints);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                ", depositor='" + depositor + '\'' +
                ", accountId='" + accountId + '\'' +
                ", amountOnDeposit='" + amountOnDeposit + '\'' +
                ", profitability=" + profitability +
                ", timeConstraints='" + timeConstraints.toString() + '\'' +
                '}';
    }

}
