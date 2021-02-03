package b2w.com.br.starwarsapi.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import b2w.com.br.starwarsapi.utils.RestService;

@SpringBootTest
public class RestServiceTest {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RestService rest;

	@Test
	public void testSwapiRestCall() throws IOException {
		Integer qtdFilms = rest.findFilmsByPlanetWithSwapi("Tatooine");
		assertThat(qtdFilms).isGreaterThan(0);
	}
}
