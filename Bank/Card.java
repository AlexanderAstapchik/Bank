package Bank;
import Enumeration.EnumBank;

import java.math.BigDecimal;

public class Card {
    private EnumBank enumBank;
    private int pincode;
    private int num;
    private String owner;
    BigDecimal balance;

    public Card(EnumBank enumBank, int pincode, int num, String owner, BigDecimal balance) {
        this.enumBank = enumBank;
        this.pincode = pincode;
        this.num = num;
        this.owner = owner;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public EnumBank getEnumBank() {
        return enumBank;
    }

    public void setEnumBank(EnumBank enumBank) {
        this.enumBank = enumBank;
    }
}


