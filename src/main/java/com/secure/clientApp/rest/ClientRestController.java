package com.secure.clientApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("client")
public class ClientRestController {


	@Autowired
	private RestTemplate template;

	@GetMapping("/hello")
	public void run(String... args) throws Exception {
		ResponseEntity<String> response = template.getForEntity("https://localhost:8081/server/api",String.class);
		System.out.println(response.getBody());
	}
	
	
	public String sayHello() {
		
		/*OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
		  .url("https://localhost:8081/server/api")
		  .build();
		
		Response response = null;
		try {
			 response = client.newCall(request).execute();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		String result = null;
		try {
			result = response.body().string();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Client call server with the reponse : " + result;*/
		
		return "hello";
	}
}
