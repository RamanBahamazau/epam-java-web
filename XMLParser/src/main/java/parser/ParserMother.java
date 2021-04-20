package parser;

import entity.BankDeposit;
import exception.CustomException;

import java.util.HashSet;
import java.util.Set;

public abstract class ParserMother {

    protected Set<BankDeposit> bankDeposits;

    protected ParserMother() {
        bankDeposits = new HashSet<>();
    }

    public Set<BankDeposit> getBankDeposits() throws CustomException {
        if (bankDeposits.isEmpty()){
            throw new CustomException("Array is empty");
        }
        return new HashSet<>(bankDeposits);
    }

    public abstract void parse(String filePath) throws CustomException;

}
