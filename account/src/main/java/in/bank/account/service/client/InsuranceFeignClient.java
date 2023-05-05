package in.bank.account.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.bank.account.model.Insurance;
import in.bank.account.model.Customer;

@FeignClient("insurance")
public interface InsuranceFeignClient {
	@RequestMapping(method = RequestMethod.POST, value = "insurance", consumes = "application/json")
	List<Insurance> getInsuranceDetails(@RequestBody Customer customer);
}
