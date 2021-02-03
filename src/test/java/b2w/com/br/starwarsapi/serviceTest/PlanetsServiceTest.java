package b2w.com.br.starwarsapi.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import b2w.com.br.starwarsapi.entity.Planet;
import b2w.com.br.starwarsapi.repository.PlanetsRepository;
import b2w.com.br.starwarsapi.service.PlanetsService;

@SpringBootTest
public class PlanetsServiceTest {
	
	@Test
	void contextLoads() {
	}
	
	@Autowired
	private PlanetsService service;
	
	Planet planetTestOne;
	Planet planetTestTwo;
	
	@BeforeEach
	public void insertPlanetTest() {
		planetTestOne = new Planet(new ObjectId(), "TestName", "TestWeather", "TestBiome");
		planetTestTwo = new Planet(new ObjectId(), "TestName2", "TestWeather2", "TestBiome2");
		
		service.addNewPlanet(planetTestOne);
		service.addNewPlanet(planetTestTwo);
	}
	
	@Test
	public void findAllPlanetsTest() {
		List<Planet> planets = service.findAllPlanets();
		assertThat(planets);
	}
	
	@Test
	public void findPlanetByNameTest() {
		Planet planet = service.findPlanetByName(planetTestOne.getName());
		assertThat(planet).isNotNull();
	}
	
	@Test
	public void findPlanetByIdTest() {
		Planet planet = service.findPlanetById(new ObjectId(planetTestTwo.get_id()));
		assertThat(planet).isNotNull();
	}
	
	@AfterEach
	public void deletePlanetsTest() {
		service.deletePlanet(planetTestOne);
		service.deletePlanet(planetTestTwo);
	}
}
