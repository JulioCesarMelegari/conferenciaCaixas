package backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_dinheiro")
public class ReceiptCoins {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ReceiptCoinsId;
	
	private int coinFivecents;
	private int coinTencents;
	private int coinTwentyfivecents;
	private int coinFifitycents;
	private int coinOne;
	private int noteTwo;
	private int noteFive;
	private int noteTen;
	private int noteTwenty;
	private int noteFifity;
	private int noteOnehundred;
	private int noteTwohundred;
	
}
