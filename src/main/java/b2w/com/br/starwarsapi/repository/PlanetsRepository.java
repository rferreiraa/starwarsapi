package b2w.com.br.starwarsapi.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import b2w.com.br.starwarsapi.entity.Planet;

public interface PlanetsRepository extends MongoRepository<Planet, String>{
	
	public Planet findTopByName(String name);
	public Optional<Planet> findBy_id(ObjectId id);
}
