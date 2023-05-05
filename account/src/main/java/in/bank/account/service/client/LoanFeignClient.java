package in.bank.account.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.bank.account.model.Customer;
import in.bank.account.model.Loan;

@FeignClient("loan")
public interface LoanFeignClient {
	@RequestMapping(method = RequestMethod.POST, value = "loan", consumes = "application/json")
	List<Loan> getLoanDetails(@RequestBody Customer customer);
}
