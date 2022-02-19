package me.dio.bank.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public abstract class Account {

    private final static Logger logger = Logger.getLogger("me.dio.bank.domain.Account");
    private static int increment = 0;

    private final String agency;
    private final String number;
    private BigDecimal balance;

    private List<History> histories;

    protected Account(String agency) {
        this.agency = agency;
        this.number = String.format("%d", ++increment);
        this.balance = BigDecimal.ZERO;
        this.histories = new ArrayList<>();
    }

    public void toWithdraw(final BigDecimal value) {

        if (value.compareTo(BigDecimal.ZERO) < 0) {
            logger.warning("The value cannot be negative!");
            throw new RuntimeException("The value cannot be negative!");
        }

        if (value.compareTo(balance) > 0) {
            logger.warning("Insufficient balance!");
            throw new RuntimeException("Insufficient balance!");
        }

        logger.info(String.format("%s, subtract value %.2f", accountInfo(), value));

        this.balance = this.balance.subtract(value);
    }

    public void deposit(final BigDecimal value) {

        if (value.compareTo(BigDecimal.ZERO) < 0) {
            logger.warning("The value cannot be negative!");
            throw new RuntimeException("The value cannot be negative!");
        }

        logger.info(String.format("%s, deposit value %.2f", accountInfo(), value));
        this.balance = this.balance.add(value);

    }

    public void transferTo(final Account target, final BigDecimal value) {

        this.toWithdraw(value);

        target.deposit(value);

    }

    public String accountInfo() {
        return String.format("Account: %s %s", agency, number);
    }

    public String history() {
        var log = "";

        for (var h : histories) {
            log = log.concat(h.toString() + "\n");
        }

        return String.format("%s", log);

    }

    public BigDecimal balance() {
        return balance;
    }

    public void toHistory(String operation) {
        this.histories.add(History.create(operation));
    }

    public abstract String extract();

}
