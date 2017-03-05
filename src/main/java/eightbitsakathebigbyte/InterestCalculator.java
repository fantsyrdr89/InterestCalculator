package eightbitsakathebigbyte;

public class InterestCalculator {

    Account account;

    public long calculateSimpleInterest(Account account,float interval){
        long recurringTransaction = consistentRecurringTransactions(account);
        long interestOnPrincipal = simpleInterestEquation(account, interval);
        long interestOnRecurring = simpleRecurringEquation(account, recurringTransaction, interval);
        return interestOnPrincipal + interestOnRecurring;
    }

    public long calculateComplexInterest(Account account, float interval,int frequency){

        return 0;
    }

    private boolean isOverdraft(Account account){
        if(account.getBalance()<0) return true;
        return false;
    }


    // SIMPLE INTEREST HELPER METHODS
    private long consistentRecurringTransactions(Account account) {
        if(account.getRecurringTransactions().size()==0) return 0;
        long totalRecurringTransactions = 0;
        for(RecurringTransaction entry : account.getRecurringTransactions()) totalRecurringTransactions += entry.getAmount();
        if(totalRecurringTransactions / account.getRecurringTransactions().size() != account.getRecurringTransactions().get(0).getAmount())     // Fix average number hole
            return 0;
        return totalRecurringTransactions;
    }

    private long simpleRecurringEquation(Account account, long transaction, float interval) {
        float maturity = interval/0.08333333333f;
        return (long)(transaction*(maturity*(maturity+1)/(2*12))*account.getInterestRate());
    }

    private long simpleInterestEquation(Account account, float interval) {
        return (long)(account.getBalance()*account.getInterestRate()*interval);
    }
}
