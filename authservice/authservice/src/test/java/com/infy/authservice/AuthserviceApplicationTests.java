package com.infy.authservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AuthserviceApplicationTests {
	
	@LocalServerPort
	int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void getAuthTokenHeader() {
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestEntity=new HttpEntity<String>(httpHeaders);
		restTemplate.exchange("http://localhost:"+port+"/auth", HttpMethod.POST, requestEntity, String.class);
	}

}
