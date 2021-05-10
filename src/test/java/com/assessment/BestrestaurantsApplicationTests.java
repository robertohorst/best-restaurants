package com.assessment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.assessment.api.controller.RestaurantController;
import com.assessment.domain.repository.RestaurantRepository;

@WebMvcTest(RestaurantController.class)
class BestrestaurantsApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private RestaurantRepository restaurantRespository;
	
	@Test
	public void testIfContextIsRunning() throws Exception  {
		mvc.perform(get("/restaurants")).
		andExpect(status().isOk()).
		andExpect(content().json("[]"));
	}
	
}
