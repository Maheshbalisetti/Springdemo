package com.example.SpringDemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.example.SpringDemo.controller.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(Student.class)
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void testGetForm() throws Exception {
		mockMvc.perform(get("/getform"))
				.andExpect(status().isOk())
				.andExpect(view().name("form"));
	}

	@Test
	public void testSubmitForm() throws Exception {
		mockMvc.perform(post("/submitForm")
						.param("name", "John Doe")
						.param("email", "john.doe@example.com")
						.param("gender", "male"))
				.andExpect(status().isOk())
				.andExpect(view().name("formSuccess"))
				.andExpect(model().attribute("name", "John Doe"))
				.andExpect(model().attribute("email", "john.doe@example.com"))
				.andExpect(model().attribute("gender", "male"));
	}
}
