package com.converter.sever.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.converter.sever.util.Unit;

@RestController
@RequestMapping("/api")
public class ConverterController {

	@RequestMapping(value = "/convert")
	public Map<String, Object> convertToFarenheit(@RequestParam("input") double input, @RequestParam("unitName")Unit unit){
		
		Map<String, Object> mapper = new HashMap<>();
		
		switch (unit) {
		case CELIOUS:
			mapper.put("content", convertToCelcious(input));
			break;
		case FARENHEIT:
			mapper.put("content", convertToFarenheit(input));
			break;
			
		default:
			break;
		}
		
		return mapper;
	}
	
	private double convertToFarenheit(double input) {
		
		return (9 * (input) / 5) + 32;
	}
	
	private double convertToCelcious(double input) {
		
		return 5 * (input - 32) / 9;
	}
}
