package in.bank.cards.model;

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
public class Cards {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "card_id")
	private int cardId;
	
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "card_number")
	private int cardNumber;
	
	@Column(name = "card_type")
	private String cardType;
	
	@Column(name = "expiry_date")
	private Date expiryDate;
}
