package parser;

import entity.BankDeposit;
import exception.CustomException;

import java.util.ArrayList;

public abstract class BankDepositBuilderMother {

    private ArrayList<BankDeposit> abstractBanks;

    public BankDepositBuilderMother() {
        abstractBanks = new ArrayList<>();
    }

    public BankDepositBuilderMother(ArrayList<BankDeposit> abstractBanks){
        this.abstractBanks = abstractBanks;
    }

    public ArrayList<BankDeposit> getAbstractBanks() throws CustomException {
        if (abstractBanks.isEmpty()){
            throw new CustomException("Array is empty");
        }
        return (ArrayList<BankDeposit>) abstractBanks.clone();
    }

    public abstract void buildArrayBanks(String filename) throws CustomException;

}
