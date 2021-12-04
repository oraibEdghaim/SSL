package com.secure.clientApp;

import java.io.InputStream;
import java.net.http.HttpClient;
import java.security.KeyStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientAppApplication.class, args);
	}

	/*@Bean
	 public RestTemplate template() throws Exception{
	 RestTemplate template = new RestTemplate();
		try {
			KeyStore keyStore;
			keyStore = KeyStore.getInstance("jks");
			/*ClassPathResource classPathResource = new ClassPathResource("test");
			InputStream inputStream = classPathResource.getInputStream();
			keyStore.load(inputStream, "set ".toCharArray());*/
			
			SSLConnetionSocketFactory socketFactory = new SSLConnetionSocketFactory(
					new SSLContextBuilder().loadTrustMaterial(null, new TrustSelfSignedStrategy())
							.loadKeyMaterial(keyStore, "".toCharArray()).build(),
					NoopHostnameVerifier.INSTANCE);

			HttpClient httpClient = HttpClients.custome().setSSLSocketFactory(socketFactory)
					.setMaxConnTotal(Integer.valueOf(5)).setMaxConnPerRoute(Integer.valueOf(5)).build();

			requestFactory = new HttpComponentsClientHttpFactory(httpClient);
			requestFactory.setReadTimeout(Integer.valueOf(1000));
			requestFactory.setConnectTimeout(Integer.valueOf(1000));

			restTemplate.setRequestFactory(requestFactory);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	 return template;
	 }*/
}
