package com.example.demo;

import java.util.HashMap;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class CarModelDTO {
    @NotEmpty
    @Length(max = 100)
    public String manufacturer;
    @NotEmpty
    @Length(max = 100)
    public String name;	
      
    public CarModelDTO(String manufacturer, String name) {
        
        this.manufacturer = manufacturer;
        this.name = name;
    }
}

 class CarsModel {
	HashMap<String, String> map;	
      
    public CarsModel() {        
    	map = new HashMap<>();
    }
    
    public void AddCar(CarModelDTO carModelDto)
    {
    	this.map.put(carModelDto.manufacturer, carModelDto.name);
    }
    
    HashMap<String, String> getMap()
    {
    	return map;    	
    }
}