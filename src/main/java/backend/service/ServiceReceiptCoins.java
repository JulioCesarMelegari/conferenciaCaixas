package backend.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import backend.entity.ReceiptCoins;
import backend.repository.ReceiptCoinsRepository;

@Service
public class ServiceReceiptCoins {
	
	@Autowired
	private ReceiptCoinsRepository repository;
	
	public ReceiptCoins Save(ReceiptCoins coins) {
		repository.save(coins);
		return coins;
	}
	
	public Optional<ReceiptCoins> findById(String id) {
		return repository.findById(Long.valueOf(id));
	}
	
	@GetMapping
	public Page<ReceiptCoins> findAll(Pageable pageable){
		Page<ReceiptCoins> result = repository.findAll(pageable);
		return result.map(x -> new ReceiptCoins());		
	}
	
	@SuppressWarnings("deprecation")
	public  List<Double> valueOfReceiptCoins(String id) {
		ReceiptCoins receiptcoin = repository.getById(Long.valueOf(id));
		double valueCoin = valueOfCoins(receiptcoin);
		double valueNote = valueOfNotes(receiptcoin);
		double total = valueCoin + valueNote;
		List<Double> list = Arrays.asList(valueCoin, valueNote, total);
		return list;		 
	}
	
	private double valueOfCoins(ReceiptCoins coins) {
		double valueCoinFivecents = coins.getCoinFivecents()*0.5;
		double valueCoinTencents = coins.getCoinTencents() * 0.1;
		double valueCoinTwentyfivecents = coins.getCoinTwentyfivecents()*0.25;
		double valueCoinCoinFifitycents = coins.getCoinFifitycents()*0.50;
		double valueCoinOne = coins.getCoinOne()*1;
		double total = valueCoinOne + valueCoinCoinFifitycents + valueCoinTwentyfivecents + valueCoinTencents + valueCoinFivecents;	
		return total;
	}
		
	private double valueOfNotes(ReceiptCoins coins) {	
		double valueNoteTwo = coins.getNoteTwo()*2;
		double valueNoteFive = coins.getNoteFive()*5;
		double valueNoteTen = coins.getNoteTen()*10;
		double valueNoteTwenty = coins.getNoteTwenty()*20;
		double valueNoteFifity = coins.getNoteFifity()*50;
		double valueNoteOnehundred = coins.getNoteOnehundred()*100;
		double valueNoteTwohundred = coins.getNoteTwohundred()*200;
		double total = valueNoteTwohundred + valueNoteOnehundred + valueNoteFifity + valueNoteTwenty + valueNoteTen + valueNoteFive + valueNoteTwo;	
		return total;
	}
	

}
