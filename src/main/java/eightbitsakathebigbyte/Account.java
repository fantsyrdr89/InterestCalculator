package eightbitsakathebigbyte;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountID;
    private String firstName;
    private String lastName;
    private String accountType;
    private Long balance;
    private Double interestRate;
    private Long overdraftPenalty;
    private Long requiredMinimumBalance;
    private ArrayList<RecurringTransaction> recurringTransactions;

   public Account(){}

    public Account(String accountType, String firstName, String lastName, Long balance, Double interestRate, Long overdraftPenalty, Long requiredMinimumBalance, ArrayList<RecurringTransaction> transactions) {
        this.accountType = accountType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.interestRate = interestRate;
        this.overdraftPenalty = overdraftPenalty;
        this.requiredMinimumBalance = requiredMinimumBalance;
        this.recurringTransactions = recurringTransactions;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {

        this.accountType=accountType;
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


    public Long getRequiredMinimumBalance() {
        return requiredMinimumBalance;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }
}
