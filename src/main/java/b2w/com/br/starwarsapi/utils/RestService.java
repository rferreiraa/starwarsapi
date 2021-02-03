package b2w.com.br.starwarsapi.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RestService {

	@Value("https://swapi.dev/api/planets/")
	private String urlApi;

	private RestTemplate rest = new RestTemplate();

	public Integer findFilmsByPlanetWithSwapi(String name) {
		String input = "{\"name\":\"" + name + "\"}";
		HttpEntity<String> entity = new HttpEntity<>(input);
		String response = rest.exchange(urlApi, HttpMethod.GET, entity, String.class).getBody();

		ObjectMapper mapper = new ObjectMapper();
		Integer qntdFilms = 0;
		
		try {
			JsonNode result = mapper.readTree(response).get("results");
			
			for (JsonNode planet : result) {
				String planetName = planet.path("name").asText();
				JsonNode films = planet.path("films");
				
				if(name.equals(planetName)) {
					if(films.isArray()) {
						 qntdFilms = films.size();
						 break;
					}
				}
			}
		
		} catch (JsonProcessingException e) {
			log.error("Erro ao processar JSON");
		}

		return qntdFilms;
	}
}
