package eightbitsakathebigbyte;

/**
 * Created by jeriahhumphrey on 3/2/17.
 */
public class CheckedAccount {
    Account newAccount;

    public CheckedAccount(Account account){
        newAccount=account;
        checkInterestRate();
        checkBalance();
    }

    public boolean checkValidAccountType() {
        switch (newAccount.getAccountType().toLowerCase()) {
            case "savings":
            case "checking":
            case "money market":
                return true;
            default:
                return false;
        }
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

    private void checkNormalInterestRate(){
        if(isChecking()){
            newAccount.setInterestRate(0.0);
        }

        if(isSavings()){
            newAccount.setInterestRate(0.01);
        }
        if(isMoneyMarket()){
            newAccount.setInterestRate(0.05);
        }
    }


    private void checkRMBInterestRate(){
        if(isRMB()){
            if(isSavings()){
                newAccount.setInterestRate(0.005);
            }
            if(isMoneyMarket()){
                newAccount.setInterestRate(-0.025);
            }
        }
    }

    public double checkInterestRate(){
        checkNormalInterestRate();
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

    public long checkRequiredMinimumBalance(){
        if(checkMinimumBalanceRequirement()){
            if(isSavings()){
                newAccount.setRequiredMinimumBalance(10000l);
            }
            if(isMoneyMarket()){
                newAccount.setRequiredMinimumBalance( 1000000l);
            }
        }
            return newAccount.getRequiredMinimumBalance();
    }

    public boolean isRMB(){
        checkRequiredMinimumBalance();
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




