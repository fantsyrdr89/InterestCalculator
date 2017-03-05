package eightbitsakathebigbyte;


public class InterestCalculator {

    CheckedAccount checkedAccount;

    public long calculateSimpleInterest(Account account, float interval) {

        return -1L;
    }

    public long calculateComplexInterest(Account account, float interval, int frequency) {
        checkedAccount = new CheckedAccount(account);
        long interestAccrued;
        long principal = account.getBalance();
        double interestRate = account.getInterestRate();
        long recurringTransaction = 0;
        if (account.getRecurringTransactions() != null) {
            for (int i = 0; i < account.getRecurringTransactions().size(); i++) {
                recurringTransaction += account.getRecurringTransactions().get(i).amount;
            }
        }
        interestAccrued = (long) ((principal * Math.pow(1 + (interestRate / frequency), (frequency * interval)) - principal)
                + recurringTransaction * (Math.pow((1 + (interestRate / frequency)), (frequency * interval)) - 1) / (interestRate / frequency));

        return interestAccrued;
    }
}


