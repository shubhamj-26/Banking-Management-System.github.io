package in.bank.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import in.bank.account.config.AccountConfigService;
import in.bank.account.model.Account;
import in.bank.account.model.Cards;
import in.bank.account.model.ConfigProp;
import in.bank.account.model.Customer;
import in.bank.account.model.CustomerDetails;
import in.bank.account.model.Insurance;
import in.bank.account.model.Loan;
import in.bank.account.repository.AccountRepository;
import in.bank.account.service.client.CardsFeignClient;
import in.bank.account.service.client.InsuranceFeignClient;
import in.bank.account.service.client.LoanFeignClient;

@RestController
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountConfigService accountsConfig;
	
	@Autowired
	private CardsFeignClient cardsFeignClient;
	
	@Autowired
	private LoanFeignClient loanFeignClient;
	
	@Autowired
	private InsuranceFeignClient insuranceFeignClient;
	
	@PostMapping("/account")
	public Account getAccountDetails(@RequestBody Customer customer) {
		Account account = accountRepository.findByCustomerId(customer.getCustomerId());
		return account;
	}
	
	@GetMapping("/account/configProps")
	public String getPropertyDetails() throws JsonProcessingException{
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		ConfigProp properties = new ConfigProp(accountsConfig.getMsg()
				,accountsConfig.getBuildVersion(),accountsConfig.getMailDetails(),accountsConfig.getActiveBranches());
		String jsonstr = ow.writeValueAsString(properties);
		return jsonstr;
	}
	
	@PostMapping("/profile")
	public CustomerDetails getCustomerDetails(@RequestBody Customer customer) {
		Account account = accountRepository.findByCustomerId(customer.getCustomerId());
		List<Cards> cards = cardsFeignClient.getCardDetails(customer);
		List<Loan> loan = loanFeignClient.getLoanDetails(customer);
		List<Insurance> insurance = insuranceFeignClient.getInsuranceDetails(customer);
		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setAccount(account);
		customerDetails.setCards(cards);
		customerDetails.setLoan(loan);
		customerDetails.setInsurance(insurance);
		return customerDetails;
	}
}
