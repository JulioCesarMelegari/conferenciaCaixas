package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.entity.Composition;

public interface CompositionRepository extends JpaRepository<Composition, Long>{

}
