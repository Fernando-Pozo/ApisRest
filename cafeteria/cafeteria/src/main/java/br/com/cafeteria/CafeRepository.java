package br.com.cafeteria;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CafeRepository extends CrudRepository<Cafe, String> {

	Iterable<Cafe> findAll();

	Optional<Cafe> findById(String id);

	boolean existsById(String id);

	void deleteById(String id);
}
