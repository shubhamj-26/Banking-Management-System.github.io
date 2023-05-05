package in.bank.loan.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.bank.loan.model.Loan;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long>{
	List<Loan> findByCustomerId(int customerId);
}
