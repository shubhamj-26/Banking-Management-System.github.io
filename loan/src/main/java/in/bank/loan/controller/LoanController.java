package in.bank.loan.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import in.bank.loan.model.ConfigProps;
import in.bank.loan.config.LoanConfigService;
import in.bank.loan.model.Customer;
import in.bank.loan.model.Loan;
import in.bank.loan.repository.LoanRepository;

@RestController
public class LoanController {
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private LoanConfigService loanConfig;
	
	@PostMapping("/loan")
	public List<Loan> getLoanDetails(@RequestBody Customer customer){
		List<Loan> loan = loanRepository.findByCustomerId(customer.getCustomerId());
		return loan;
	}
	
	@GetMapping("/loan/configProps")
	public String getPropertyDetails() throws JsonProcessingException{
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		ConfigProps properties = new ConfigProps(loanConfig.getMsg()
				,loanConfig.getBuildVersion(),loanConfig.getMailDetails(),loanConfig.getActiveBranches());
		String jsonstr = ow.writeValueAsString(properties);
		return jsonstr;
	}
}
