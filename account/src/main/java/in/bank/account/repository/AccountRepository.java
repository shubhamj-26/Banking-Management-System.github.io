package in.bank.account.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.bank.account.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{
	Account findByCustomerId(int customerID);
}
