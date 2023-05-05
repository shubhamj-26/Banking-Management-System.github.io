package in.bank.account.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.bank.account.model.Cards;
import in.bank.account.model.Customer;

@FeignClient("cards")
public interface CardsFeignClient {
	@RequestMapping(method = RequestMethod.POST, value = "cards", consumes = "application/json")
	List<Cards> getCardDetails(@RequestBody Customer customer);
}
