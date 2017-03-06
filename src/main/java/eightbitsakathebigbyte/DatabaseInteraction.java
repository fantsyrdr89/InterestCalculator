package eightbitsakathebigbyte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping(path="/8080")
public class DatabaseInteraction {

    @Autowired
    static AccountRepository repository;
    @Autowired
    static TransactionsRepository transrepo;

    @GetMapping(path="/8080")
    public @ResponseBody Account addAccount(@RequestParam String accountType,
                                            @RequestParam String firstName,
                                            @RequestParam String lastName,
                                            @RequestParam Long balance,
                                            @RequestParam Double interestRate,
                                            @RequestParam Long overDraftPenalty,
                                            @RequestParam Long requiredMinimumBalance,
                                            @RequestParam ArrayList<Object> transactions){
        repository.save(new Account(accountType, firstName, lastName, balance, interestRate, overDraftPenalty, requiredMinimumBalance));
        transrepo.save(new ArrayList<Object>(transactions));
        return findAccountByName(lastName, firstName);
    }

    public static Account findAccountByName(String lastName, String firstName){
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

    public static Account findAccountById(long accountID){
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

    public static ArrayList<Object> findTransactionsById(long accountID){
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


