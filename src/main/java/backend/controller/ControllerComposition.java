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

import backend.dto.DtoComposition;
import backend.entity.Composition;
import backend.service.ServiceComposition;

@RestController
@RequestMapping(value= "movimento")
public class ControllerComposition {
	
	@Autowired
	private ServiceComposition service;
	
	@PostMapping("/novo")
	public void saveComposition(@RequestBody DtoComposition dto) {
		Composition composition = service.DtoToEntity(dto);
		service.Save(composition);
	}
	
	@GetMapping("/movimento/{id}")
	public Optional<Composition> getCompositionById(@PathVariable("id") String id) {
		return service.findById(id);
	}
	
	@GetMapping
	public ResponseEntity<Page<DtoComposition>> findAll(Pageable pageable){
		Page<DtoComposition> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}

}
