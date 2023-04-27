package com.example.dc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class Springboot3DockerComposeApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetAllBooks() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
											.andExpect(status().isOk());
		resultActions.andExpect(jsonPath("$[*].name", containsInAnyOrder("book1", "book2")))
				.andExpect(jsonPath("$[*].author", containsInAnyOrder("author1", "author2")));
	}

}
