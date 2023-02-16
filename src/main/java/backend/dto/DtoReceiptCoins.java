package backend.dto;

import java.io.Serializable;

import backend.entity.ReceiptCoins;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoReceiptCoins implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String IdReceiptCoins;
	private String coinFivecents;
	private String coinTencents;
	private String coinTwentyfivecents;
	private String coinFifitycents;
	private String coinOne;
	private String noteTwo;
	private String noteFive;
	private String noteTen;
	private String noteTwenty;
	private String noteFifity;
	private String noteOnehundred;
	private String noteTwohundred;
	
	public DtoReceiptCoins(ReceiptCoins receiptCoins) {
		
		IdReceiptCoins = Long.toString(receiptCoins.getReceiptCoinsId());
		coinFivecents = Double.toString(receiptCoins.getCoinFivecents());
		coinTencents = Double.toString(receiptCoins.getCoinTencents());
		coinTwentyfivecents = Double.toString(receiptCoins.getCoinTwentyfivecents());
		coinFifitycents = Double.toString(receiptCoins.getCoinFifitycents());
		coinOne = Double.toString(receiptCoins.getCoinOne());
		noteTwo = Double.toString(receiptCoins.getNoteTwo());
		noteFive = Double.toString(receiptCoins.getNoteFive());
		noteTen = Double.toString(receiptCoins.getNoteTen());
		noteTwenty = Double.toString(receiptCoins.getNoteTwenty());
		noteFifity = Double.toString(receiptCoins.getNoteFifity());
		noteOnehundred = Double.toString(receiptCoins.getNoteOnehundred());
		noteTwohundred = Double.toString(receiptCoins.getNoteTwohundred());
	}
	
}
