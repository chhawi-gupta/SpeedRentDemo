package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class SpeedRentApplication {
	@RequestMapping(value = "/hello1", method = RequestMethod.GET, produces = "application/json")
	String home1() {
		String carAsString = null;
		ObjectMapper objectMapper = new ObjectMapper();
		CarModel car = new CarModel("Maruti","Swift");
		try {
			carAsString = objectMapper.writeValueAsString(car.toString());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
        return carAsString;
	}
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
	HashMap<String, String> home() {
	    // Option 2
	    CarModelDTO car1 = new CarModelDTO("Maruti","Swift");
	    CarModelDTO car2 = new CarModelDTO("Ford","Fiesta");
	    CarsModel carsModel = new CarsModel();
	    carsModel.AddCar(car1);
	    carsModel.AddCar(car2);
	    return carsModel.getMap();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpeedRentApplication.class, args);
	}

}
