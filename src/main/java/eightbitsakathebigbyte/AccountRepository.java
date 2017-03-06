package eightbitsakathebigbyte;

import eightbitsakathebigbyte.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    List<Account> findByAccountID(Long accountID);
    List<Account> findByLastName(String lastName);
    List<Account> findByFirstName(String firstName);

}
