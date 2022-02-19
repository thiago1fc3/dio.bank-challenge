package me.dio.bank.domain;

public class CheckingAccount extends Account {

    private static final String OPERATION = "001";

    public CheckingAccount(String agency) {
        super(agency);
    }

    @Override
    public String extract() {
        return String.format("""
                === Extract Checking Account (%s) ===
                %s
                
                History
                %s
                Balance: %.2f
                -------------------------------------                  
                """, OPERATION, accountInfo(), history(), balance());
    }

}
