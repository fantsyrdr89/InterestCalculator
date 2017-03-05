package eightbitsakathebigbyte;

import Repository.AccountRepository;
import Repository.TransactionsRepository;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

public class DatabaseInteraction {
    AccountRepository repository;
    TransactionsRepository transrepo;

    @Bean
    public Account addAccount(String accountType, String firstName, String lastName, Long balance, Double interestRate, Long overDraftPenalty, Long requiredMinimumBalance, ArrayList<RecurringTransaction> transactions){
        repository.save(new Account(accountType, firstName, lastName, balance, interestRate, overDraftPenalty, requiredMinimumBalance, transactions));
        transrepo.save(new ArrayList<Object>(transactions));
        return findAccountByName(lastName, firstName);
    }

    @Bean
    public Account findAccountByName(String lastName, String firstName){
        try {
            for (Account account : repository.findAll()) {
                if (account.getLastName().equals(lastName) && account.getFirstName().equals(firstName)) {
                    return account;
                }
            }
            throw new ItemNotFoundException();
        } catch(Exception e){
            return null;
        }
    }

    @Bean
    public Account findAccountById(long accountID){
        try {
            for (Account account : repository.findAll()) {
                if (account.getAccountID() == accountID) {
                    return account;
                }
            }
            throw new ItemNotFoundException();
        } catch(Exception e){
            return null;
        }
    }

    @Bean
    public ArrayList<Object> findTransactionsById(long accountID){
        try {
            for (ArrayList<Object> transactions : transrepo.findAll()){
                if(transactions.contains(accountID)){
                    return transactions;
                }
            }
            throw new ItemNotFoundException();
        } catch(Exception e){
            return null;
        }
    }
}

class ItemNotFoundException extends Exception{}
