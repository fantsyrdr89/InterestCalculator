package eightbitsakathebigbyte;

/**
 * Created by jeriahhumphrey on 3/2/17.
 */
public class CheckedAccount {
    Account newAccount;
    double storedInterestRate;

    public CheckedAccount(Account account){
        newAccount=account;
        checkInterestRate();
        checkBalance();
        storedInterestRate = account.getInterestRate();
    }



    private boolean isChecking(){
        if (newAccount.getAccountType().toLowerCase().equals("checking")){
            return true;
        }
        return false;
    }

    private boolean isSavings(){
        if (newAccount.getAccountType().toLowerCase().equals("savings")){
            return true;
        }
        return false;
    }

    private boolean isMoneyMarket(){
        if (newAccount.getAccountType().toLowerCase().equals("money market")){
            return true;
        }
        return false;
    }

    public boolean isOverdraft(){
    if (newAccount.getBalance()<0){
        return true;
        }
        return false;
    }


    private void checkRMBInterestRate(){
        if(isRMB()){
            newAccount.setInterestRate(0.0);
        }
        else{
            newAccount.setInterestRate(storedInterestRate);
        }

    }

    public double checkInterestRate(){
        checkRMBInterestRate();
        return newAccount.getInterestRate();
    }


    public boolean checkMinimumBalanceRequirement(){
        if(isChecking()){
            newAccount.setMinimumBalanceRequired(false);
        }
        if(isSavings()){
            newAccount.setMinimumBalanceRequired(true);
        }
        if(isMoneyMarket()){
            newAccount.setMinimumBalanceRequired(true);
        }
        return newAccount.isMinimumBalanceRequired;
    }


    public boolean isRMB(){
        if(checkMinimumBalanceRequirement()) {
            if (newAccount.getBalance() < newAccount.getRequiredMinimumBalance()) {
                return true;
            }
        }
        return false;
    }

    public void setCheckedBalance() {
        if (isOverdraft()) {
            newAccount.setBalance(newAccount.getBalance() - newAccount.getOverdraftPenalty());
        }
    }

    public long checkBalance(){
                setCheckedBalance();
                return newAccount.getBalance();
    }
    }




