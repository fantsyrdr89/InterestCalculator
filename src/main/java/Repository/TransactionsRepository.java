package Repository;

import eightbitsakathebigbyte.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface TransactionsRepository extends CrudRepository<ArrayList<Object>, Integer> {

    List<Account> findByAccountID(Long accountID);

}
