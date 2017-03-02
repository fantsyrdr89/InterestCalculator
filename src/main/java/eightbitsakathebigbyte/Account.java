package eightbitsakathebigbyte;

import java.util.ArrayList;

public class Account {

    String accountType;
    Long balance;
    Double interestRate;
    Long overdraftPenalty;
    Long requiredMinimumBalance;
    boolean isMinimumBalanceRequired;
    ArrayList<RecurringTransaction> recurringTransactions;

    public Account(String accountType, Long balance, Double interestRate, Long overdraftPenalty, Long requiredMinimumBalance, boolean isMinimumBalanceRequired,ArrayList<RecurringTransaction> recurringTransactions) {
        this.accountType = accountType;
        this.balance = balance;
        this.interestRate = interestRate;
        this.overdraftPenalty = overdraftPenalty;
        this.requiredMinimumBalance = requiredMinimumBalance;
        this.recurringTransactions = recurringTransactions;
        this.isMinimumBalanceRequired = isMinimumBalanceRequired;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Long getOverdraftPenalty() {
        return overdraftPenalty;
    }

    public void setOverdraftPenalty(Long overdraftPenalty) {
        this.overdraftPenalty = overdraftPenalty;
    }

    public Long getRequiredMinimumBalance() {
        return requiredMinimumBalance;
    }

    public boolean isMinimumBalanceRequired() {
        return isMinimumBalanceRequired;
    }

    public void setMinimumBalanceRequired(boolean minimumBalanceRequired) {
        isMinimumBalanceRequired = minimumBalanceRequired;
    }

    public void setRequiredMinimumBalance(Long requiredMinimumBalance) {
        this.requiredMinimumBalance = requiredMinimumBalance;
    }

    public ArrayList<RecurringTransaction> getRecurringTransactions() {
        return recurringTransactions;
    }

    public void setRecurringTransactions(ArrayList<RecurringTransaction> recurringTransactions) {
        this.recurringTransactions = recurringTransactions;
    }
}
