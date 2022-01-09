package Bank;

import Enumeration.EnumBank;

import java.math.BigDecimal;

public class CreditCard extends Card {

    public CreditCard(EnumBank enumBank, int pincode, int num, String owner, BigDecimal balance) {
        super(enumBank, pincode, num, owner, balance);
    }
}
