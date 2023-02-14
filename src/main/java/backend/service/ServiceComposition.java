package backend.service;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import backend.dto.DtoComposition;
import backend.entity.Composition;
import backend.repository.CompositionRepository;

@Service
public class ServiceComposition {
	
	@Autowired
	private CompositionRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Composition DtoToEntity (DtoComposition dto) { 
		return modelMapper.map(dto, Composition.class);
	}
	
	public Composition Save(Composition composition) {
		repository.save(composition);
		return composition;
	}

	public Optional<Composition> findById(String id) {
		return repository.findById(Long.valueOf(id));
	}
	
	@GetMapping
	public Page<DtoComposition> findAll(Pageable pageable){
		Page<Composition> result = repository.findAll(pageable);
		return result.map(x -> new DtoComposition(x));
			
	}
	
}
