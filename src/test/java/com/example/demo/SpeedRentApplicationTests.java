package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpeedRentApplicationTests {
   @Autowired
    private MockMvc mvc;
	   
	@Test
	public void contextLoads() {
	}
	
	
	 public static CarModelDTO createDTO(String manufacturer, String name) {
			CarModelDTO dto = new CarModelDTO(manufacturer, name);	 
	        return dto;
	    }

	@Test
	public void whenCallHello_thenReturnCarResponse() {
		CarModelDTO dto = createDTO("Ford", "Fiesta");	
		CarModelDTO dto1 = createDTO("Maruti", "Swift");	
		CarsModel carsModel = new CarsModel();
	    carsModel.AddCar(dto);
	    carsModel.AddCar(dto1);
	    try {
			mvc.perform(get("/hello")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
			  .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			  .andExpect(content().string("{\"Ford\":\"Fiesta\",\"Maruti\":\"Swift\"}"));
	    }
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
