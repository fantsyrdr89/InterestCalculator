package eightbitsakathebigbyte;

public class InterestCalculator {

    Account account;

    public long calculateSimpleInterest(Account account,float interval){
        return (long)(account.getBalance()*account.getInterestRate()*interval);
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
