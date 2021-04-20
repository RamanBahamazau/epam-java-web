package parser;

import entity.BankDeposit;
import exception.CustomException;

import java.util.HashSet;
import java.util.Set;

public abstract class BankDepositBuilderMother {

    protected Set<BankDeposit> bankDeposits;

    public BankDepositBuilderMother(Set<BankDeposit> bankDeposits){
        this.bankDeposits = bankDeposits;
    }

    protected BankDepositBuilderMother() {
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
