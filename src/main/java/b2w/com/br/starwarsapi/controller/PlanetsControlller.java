package b2w.com.br.starwarsapi.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import b2w.com.br.starwarsapi.entity.Planet;
import b2w.com.br.starwarsapi.service.PlanetsService;

@RestController
@RequestMapping("/planets")
public class PlanetsControlller {
	
	@Autowired
	private PlanetsService service;
	
	@GetMapping
	public List<Planet> getAllPlanets(){
		return service.findAllPlanets();
	}
	
	@GetMapping("/byname/{name}")
	public Planet getPlanetByName(@PathVariable("name") String name) {
		return service.findPlanetByName(name);
	}
	
	@GetMapping("/byid/{id}")
	public Planet getPlanetById(@PathVariable("id") ObjectId id) {
		return service.findPlanetById(id);
	}
	
	@DeleteMapping("/delete")
	public void deletePlanet(@RequestBody Planet planet) {
		service.deletePlanet(planet);
	}
	
	@PostMapping("/add")
	public void addNewPlanet(@RequestBody Planet planet) {
		service.addNewPlanet(planet);
	}
}
