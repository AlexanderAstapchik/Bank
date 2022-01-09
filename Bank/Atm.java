package Bank;

import Enumeration.EnumBank;

import java.math.BigDecimal;
import java.util.Scanner;

public class Atm {
    private EnumBank enumBank;

    public EnumBank getEnumBank() {
        return enumBank;
    }

    public void setEnumBank(EnumBank enumBank) {
        this.enumBank = enumBank;
    }

    public Atm(EnumBank enumBank) {
        this.enumBank = enumBank;
    }

    public void enterPinAndCheck(Card card) {
        System.out.println("Enter your pin code: ");
        Scanner scanner = new Scanner(System.in);
        int attemptToEnter = 0;
        while (attemptToEnter < 3) {
            int pin = scanner.nextInt();
            if (pin == card.getPincode()) {
                System.out.println("your pin has been accepted");
                break;
            } else if (attemptToEnter < 2) {
                System.out.println(" Your pin is not accepted.Repeat pin:");
            }
            attemptToEnter++;
            if (attemptToEnter == 3) {
                System.out.println("your card is blocked");
                System.exit(0);
            }
        }
    }

    public void checkBalance(Card card) {
        BigDecimal cardBalance = card.getBalance();
        System.out.println("Your current balance: " + cardBalance.setScale(2, BigDecimal.ROUND_CEILING));
    }

    public void cashWithdrawal(Card card) {
        if (enumBank.equals(card.getEnumBank())) {
            System.out.println("Enter the required amount: ");
        } else {
            System.out.println("Sorry. Withdrawing money is not possible");
            return;
        }
        Scanner cash = new Scanner(System.in);
        int cashWithdrawal = cash.nextInt();
        BigDecimal sumWithdrawal = new BigDecimal(cashWithdrawal);
        BigDecimal currentBalance = card.getBalance().subtract(sumWithdrawal);
        BigDecimal a = BigDecimal.ZERO;
        if (a.compareTo(currentBalance) == 1) {
            System.out.println("Not enough money on the card");
        } else {
            System.out.println("Your current balance: " + currentBalance.setScale(2, BigDecimal.ROUND_HALF_UP));
        }
    }

    public void credit(Card creditCard) {
        if (enumBank.equals(creditCard.getEnumBank())) {
            System.out.println("Enter the required amount: ");
        } else {
            System.out.println("Sorry. Withdrawing money is not possible");
            return;
        }
        Scanner cash = new Scanner(System.in);
        int cashWithdrawal = cash.nextInt();
        BigDecimal sumWithdrawal = new BigDecimal(cashWithdrawal);
        BigDecimal currentBalance = creditCard.getBalance().subtract(sumWithdrawal);
        BigDecimal a = BigDecimal.ZERO;
        if (a.compareTo(currentBalance) == 1) {
            System.out.println("Not enough money on the card.Do you want to take out a loan?: ");
            System.out.println("1. Yes");
            System.out.println("2. No");
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("Indicate, how much BYN would you like to receive: ");
                Scanner scanner = new Scanner(System.in);
                double sumCredit = scanner.nextDouble();
                System.out.println("Loan term 1 year. Percent rate - 12% ");
                /* I tried to cram into a loop BigDecimal, but I failed.
                double termin = 12;
                double main = sumCredit / termin;
                double percentage = 0.01;
                double debt = sumCredit * percentage;
                double pay = main + debt;
                double credit = sumCredit - pay;*/
                /*for ( BigDecimal i = BigDecimal.valueOf(12); i.compareTo(BigDecimal.ZERO) > 0; i = i.subtract(BigDecimal.ONE)) {
                    BigDecimal creditMoney = new BigDecimal(sumCredit);
                    BigDecimal term = new BigDecimal(termin);
                    BigDecimal mainDebt = new BigDecimal(main);
                    BigDecimal percentageRate = new BigDecimal(percentage);
                    BigDecimal overpayment = new BigDecimal(debt);
                    BigDecimal payment = new BigDecimal(pay);
                    BigDecimal creditMoney1 = new BigDecimal(credit);
                }*/
                double term = 12;
                double mainDebt = sumCredit / term;
                System.out.println("Loan calculation by months: ");
                for (int i = 1; i <= 12; i++) {
                    double percentageRate = 0.01;
                    double overpayment = sumCredit * percentageRate;
                    double payment = mainDebt + overpayment;
                    sumCredit -= payment;
                    System.out.println(i + " month : " + new BigDecimal(payment).setScale(2, BigDecimal.ROUND_HALF_UP));
                }

            } else {
                System.out.println("Ok.Have a good day!");
            }
        } else {
            System.out.println("Your current balance: " + currentBalance.setScale(2, BigDecimal.ROUND_HALF_UP));
        }
    }
}
