package in.bank.account.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Account {

	@Column(name = "customer_id")
	private int customerId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_Number")
	private int accountNumber;
	
	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "branch")
	private String branch;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	
}
