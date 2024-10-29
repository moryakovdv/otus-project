package otus.moryakovdv.meteoapi;

import static org.junit.Assert.assertNotNull;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import otus.moryakovdv.meteoapi.service.AllmeteotypesApiService;

@SpringBootTest()
@TestMethodOrder(OrderAnnotation.class)
class LoggingTest {

	@Autowired
	private AllmeteotypesApiService allmts;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Order(10)
	@Test
	void testLokiPush() throws JsonMappingException, JsonProcessingException {
		
		allmts.loadAllMeteoTypes(10);
	}
	
	@Order(20)
	//@Test
	void testLokiQuery() throws JsonMappingException, JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String baseUrl = "http://localhost:3100/loki/api/v1/query";
		String query = "{level=\"INFO\"}";

		// Get time in UTC
		LocalDateTime currentDateTime = LocalDateTime.now(ZoneOffset.UTC);
		String utcTimeNowString = currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));

		LocalDateTime utcTimeBefore = currentDateTime.minusMinutes(10);
		String utcTimeBeforeString = utcTimeBefore.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));

		URI uri = UriComponentsBuilder.fromUriString(baseUrl)
		  .queryParam("query", query)
		  .queryParam("start", utcTimeBeforeString)
		  .queryParam("end", utcTimeNowString)
		  .build()
		  .toUri();
		
		
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(headers), String.class);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String responseBody = response.getBody();
		JsonNode jsonNode = objectMapper.readTree(responseBody);
		JsonNode result = jsonNode.get("data");
		assertNotNull(result);
		
		System.out.println(result.asText());
		
	}
	
	
	

}
