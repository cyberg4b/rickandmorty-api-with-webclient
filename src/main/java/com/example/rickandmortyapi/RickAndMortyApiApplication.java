package com.example.rickandmortyapi;

import com.example.rickandmortyapi.modules.dto.ApiResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class RickAndMortyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RickAndMortyApiApplication.class, args);

		WebClient client = WebClient.create("https://rickandmortyapi.com");

		Mono<ApiResponseDTO> response = client.get()
				.uri("/api/character/?name=rick")
				.retrieve()
				.bodyToMono(String.class)
				.map(resBody -> {

					ObjectMapper mapper = new ObjectMapper();
                    try {
						return mapper.readValue(resBody, ApiResponseDTO.class);

					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				});

		response.subscribe(apiResponse -> {
			if(apiResponse != null) {
				apiResponse.getResults().forEach(System.out::println);
			}
		});
	}
}