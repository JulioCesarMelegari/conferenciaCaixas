package backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dto.DtoReceiptCoins;
import backend.entity.ReceiptCoins;
import backend.service.ServiceReceiptCoins;

@RestController
@RequestMapping(value= "fechamentoDinheiro")
public class ControllerReceiptCoins {
	
	@Autowired
	private ServiceReceiptCoins service;
	
	@PostMapping("/novo")
	public void saveReceiptCoins(@RequestBody DtoReceiptCoins dto) {
		ReceiptCoins receiptCoins = service.DtoToEntity(dto);
		service.Save(receiptCoins);
	}
	
	@GetMapping("/caixa/{id}")
	public Optional<ReceiptCoins> getCompositionById(@PathVariable("id") String id) {
		return service.findById(id);
	}
	
	@GetMapping
	public ResponseEntity<Page<DtoReceiptCoins>> findAll(Pageable pageable){
		Page<DtoReceiptCoins> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}

}
