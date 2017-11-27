package com.converter.sever.service;


import org.springframework.stereotype.Service;

import com.converter.sever.dto.ConvertDTO;
import com.converter.sever.util.Unit;

@Service
public class ConverterSeviceImp implements ConverterService{

	@Override
	public ConvertDTO convert(double input, Unit unit) {
		
		switch (unit) {
		case CELCIOUS:
			return converFarenheittToCelcious(input);
		case FARENHEIT:
			return convertCelciousToFarenheit(input);
		case CENTIMETERS:
			return convertMetersToCentimeters(input);
		case METERS:
			return converCentimetersToMeters(input);
		default:
			return new ConvertDTO(input);
		}
		
	}
	
	private ConvertDTO convertCelciousToFarenheit(double input) {
		double convert = (9 * (input) / 5) + 32;
		return new ConvertDTO(convert);
	}
	
	private ConvertDTO converFarenheittToCelcious(double input) {
		double convert = 5 * (input - 32) / 9;
		return new ConvertDTO(convert);
	}
	
	private ConvertDTO convertMetersToCentimeters(double input) {
		double convert = input / 0.010000;
		return new ConvertDTO(convert);
	}
	
	private ConvertDTO converCentimetersToMeters(double input) {
		double convert = (input * 0.010000);
		return new ConvertDTO(convert);
	}
	
}
