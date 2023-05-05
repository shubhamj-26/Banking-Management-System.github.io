package in.bank.account.model;

import java.sql.Date;

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
public class Insurance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "insurance_number")
	private int insuranceNumber;
	
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "insurance_type")
	private String insuranceType;
	
	@Column(name = "insured_amount")
	private int insuredAmount;
	
	@Column(name = "insurance_end_date")
	private Date insuranceEndDate;
	
}
