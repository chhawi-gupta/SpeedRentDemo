package com.example.demo;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "car")
@XmlAccessorType(XmlAccessType.NONE)
public class CarModel implements Serializable 
{      
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlElement
    private String manufacturer;
      
    @XmlElement
    private String name;	
      
    public CarModel(String manufacturer, String name) {
        
        this.manufacturer = manufacturer;
        this.name = name;
    }
    
  //Setters and Getters    
    @Override
    public String toString() {
        return "{manufacturer:" + manufacturer + ", name:" + name + "}";
    }
}
