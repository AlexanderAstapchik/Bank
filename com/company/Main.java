package com.company;

import Bank.Card;
import Bank.Atm;
import Bank.CreditCard;

import java.math.BigDecimal;

import static Enumeration.EnumBank.ALPHA_BANK;
import static Enumeration.EnumBank.PRIVAT_BANK;

public class Main {

    public static void main(String[] args) {
        Card card = new Card(ALPHA_BANK, 4321, 11, "Alexander Astapchik", new BigDecimal(1238.12));
        Card creditCard = new CreditCard(ALPHA_BANK, 1234, 1, "Alexander Astapchik", new BigDecimal(2334.45));
        System.out.println("Hello, " + card.getOwner());
        Atm atm = new Atm(ALPHA_BANK);
        atm.enterPinAndCheck(card);
        atm.checkBalance(card);
        atm.cashWithdrawal(card);
        atm.enterPinAndCheck(creditCard);
        atm.checkBalance(creditCard);
        atm.credit(creditCard);

    }
}
