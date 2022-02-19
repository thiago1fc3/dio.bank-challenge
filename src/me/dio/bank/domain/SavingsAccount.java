package me.dio.bank.domain;

public class SavingsAccount extends Account {

    private static final String OPERATION = "013";

    public SavingsAccount(String agency) {
        super(agency);
    }

    @Override
    public String extract() {
        return String.format("""
                === Extract Savings Account (%s) ===
                %s
                                
                History
                %s
                Balance: %.2f
                -------------------------------------                  
                """, OPERATION, accountInfo(), history(), balance());
    }

}
