package com.converter.sever.service;


import com.converter.sever.dto.ConvertDTO;
import com.converter.sever.util.Unit;

public interface ConverterService {

	public ConvertDTO convert(double input, Unit unit);
}
