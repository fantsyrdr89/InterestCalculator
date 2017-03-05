package eightbitsakathebigbyte;

public class InterestCalculator {

    Account account;

    public long calculateSimpleInterest(Account account,float interval){
        return (long)(account.getBalance()*account.getInterestRate()*interval);
    }
    public long calculateSimpleInterest(Account account,float interval,long recurring){
        long interestOnPrincipal = (long)(account.getBalance()*account.getInterestRate()*interval);
        long interestOnRecurring = (long)(recurring*(interval*(interval+1)/2*12)*account.getInterestRate());
        return interestOnPrincipal + interestOnRecurring;
    }

    public long calculateComplexInterest(Account account, float interval,int frequency){

        return 0;
    }

    private boolean isOverdraft(Account account){
        if(account.getBalance()<0){
            return true;
        }
        return false;
    }


}
