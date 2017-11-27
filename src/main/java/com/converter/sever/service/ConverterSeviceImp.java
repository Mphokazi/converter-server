package com.converter.sever.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.converter.sever.dto.ConvertDTO;
import com.converter.sever.util.Unit;

@Service
public class ConverterSeviceImp implements ConverterService{

	@Override
	public Map<String, Double> convert(double input, Unit unit) {
		
		switch (unit) {
		case CELCIOUS:
			return converFarenheittToCelcious(input);
		case FARENHEIT:
			return convertCelciousToFarenheit(input);
		case CENTIMETERS:
			return convertMetersToCentimeters(input);
		case METERS:
			return convertCentimetersToMeters(input);
		case KILOGRAMS:
			return convertKilogramsToGrams(input);
		case GRAMS:
			return convertGramsToKilograms(input);
		default:
			return new HashMap<>();
		}
		
	}
	
	private Map<String, Double> convertCelciousToFarenheit(double input) {
		double convert = (9 * (input) / 5) + 32;
		Map<String, Double> mapper = new HashMap<>();
		mapper.put("content", convert);
		return mapper;
	}
	
	private Map<String, Double> converFarenheittToCelcious(double input) {
		double convert = 5 * (input - 32) / 9;
		Map<String, Double> mapper = new HashMap<>();
		mapper.put("content", convert);
		return mapper;
	}
	
	private Map<String, Double> convertMetersToCentimeters(double input) {
		double convert = input / 0.010000;
		Map<String, Double> mapper = new HashMap<>();
		mapper.put("content", convert);
		return mapper;
	}
	
	private Map<String, Double> convertCentimetersToMeters(double input) {
		double convert = (input * 0.010000);
		Map<String, Double> mapper = new HashMap<>();
		mapper.put("content", convert);
		return mapper;
	}
	private Map<String, Double> convertKilogramsToGrams(double input){
		double convert = (input * 1000);
		Map<String, Double> mapper = new HashMap<>();
		mapper.put("content", convert);
		return mapper;
	}
	
	private Map<String, Double> convertGramsToKilograms(double input){
		double convert = (input * 0.001);
		Map<String, Double> mapper = new HashMap<>();
		mapper.put("content", convert);
		return mapper;
	}
	
}
