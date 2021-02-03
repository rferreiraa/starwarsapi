package b2w.com.br.starwarsapi.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import b2w.com.br.starwarsapi.entity.Planet;
import b2w.com.br.starwarsapi.repository.PlanetsRepository;
import b2w.com.br.starwarsapi.utils.RestService;

@Service
public class PlanetsService {

	@Autowired
	private PlanetsRepository repository;

	@Autowired
	private RestService rest;

	public List<Planet> findAllPlanets(){
		List<Planet> planets = repository.findAll();
		getQuantityFilmsByPlanet(planets);
		return planets;
	}

	public Planet findPlanetByName(String name) {
		Planet planet = repository.findTopByName(name);
		planet.setFilms(rest.findFilmsByPlanetWithSwapi(name));
		return planet;
	}

	public Planet findPlanetById(ObjectId id) {
		Planet planet = repository.findBy_id(id).orElse(null);
		if(!ObjectUtils.isEmpty(planet)) {
			planet.setFilms(rest.findFilmsByPlanetWithSwapi(planet.getName()));	
		}
		return planet;
	}

	public void deletePlanet(Planet planet) {
		repository.delete(planet);
	}

	public void addNewPlanet(Planet planet) {
		repository.save(planet);
	}
	
	private void getQuantityFilmsByPlanet(List<Planet> planets) {
		planets.forEach(planet -> {
			Integer qntdFilm = rest.findFilmsByPlanetWithSwapi(planet.getName());
			planet.setFilms(qntdFilm);
		});
	}
}
