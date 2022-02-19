package me.dio.bank.domain;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {

        final String agency = "054";

        var client = new Client();
        client.setName("Thiago Felippe");

        var checkingAccount = new CheckingAccount(agency);
        var savingsAccount = new SavingsAccount(agency);

        client.add(checkingAccount);
        client.add(savingsAccount);

        try {

            checkingAccount.deposit(BigDecimal.valueOf(680));
            checkingAccount.toHistory(String.format("Saved money: %.2f", BigDecimal.valueOf(680)));

            checkingAccount.toWithdraw(BigDecimal.valueOf(100));
            checkingAccount.toHistory(String.format("Cash drawn: %.2f", BigDecimal.valueOf(100)));

            savingsAccount.deposit(BigDecimal.valueOf(5_000));
            savingsAccount.toHistory(String.format("Saved money: %.2f", BigDecimal.valueOf(5_000)));

            savingsAccount.toWithdraw(BigDecimal.valueOf(560));
            savingsAccount.toHistory(String.format("Cash drawn: %.2f", BigDecimal.valueOf(560)));

        } catch (RuntimeException ex) {

        }

        for (var account : client.getAccounts()) {
            System.out.println(account.extract());
        }

    }
}
