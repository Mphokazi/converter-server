package com.converter.sever.service;


import java.util.Map;

import com.converter.sever.util.Unit;

public interface ConverterService {

	public Map<String, Double> convert(double input, Unit unit);
}
