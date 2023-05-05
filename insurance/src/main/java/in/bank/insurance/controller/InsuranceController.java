package in.bank.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import in.bank.insurance.config.InsuranceConfigService;
import in.bank.insurance.model.Insurance;
import in.bank.insurance.model.ConfigProps;
import in.bank.insurance.model.Customer;
import in.bank.insurance.repository.InsuranceRepository;

@RestController
public class InsuranceController {

	@Autowired
	private InsuranceRepository insuranceRepository;
	
	@Autowired
	private InsuranceConfigService insuranceConfig;
	
	@PostMapping("/insurance")
	public List<Insurance> getInsuranceDetails(@RequestBody Customer customer){
		List<Insurance> insurance = insuranceRepository.findByCustomerId(customer.getCustomerId());
		return insurance;
	}
	
	@GetMapping("/insurance/configProps")
	public String getPropertyDetails() throws JsonProcessingException{
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		ConfigProps properties = new ConfigProps(insuranceConfig.getMsg()
				,insuranceConfig.getBuildVersion(),insuranceConfig.getMailDetails(),insuranceConfig.getActiveBranches());
		String jsonstr = ow.writeValueAsString(properties);
		return jsonstr;
	}
	
}
