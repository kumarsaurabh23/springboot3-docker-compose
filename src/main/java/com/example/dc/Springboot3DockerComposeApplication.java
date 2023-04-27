package com.example.dc;

import com.example.dc.dto.BookDto;
import com.example.dc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot3DockerComposeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3DockerComposeApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BookService bookService) {
		return args -> {
			bookService.saveBook(new BookDto(0, "book1", "author1"));
			bookService.saveBook(new BookDto(0, "book2", "author2"));
		};
	}

}
