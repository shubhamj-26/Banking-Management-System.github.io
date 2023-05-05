package in.bank.account.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class CustomerDetails {
	private Account account;
	private List<Cards> cards;
	private List<Loan> loan;
	private List<Insurance> insurance;
}
