package com.converter.sever.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.converter.sever.service.ConverterService;
import com.converter.sever.util.Unit;

@RestController
@RequestMapping("/api")
public class ConverterController {
	
	@Autowired
	private ConverterService service;

	@RequestMapping(value = "/convert")
	@ResponseBody
	public Map<String, Double> convert(@RequestParam("input") double input, @RequestParam("unitName")Unit unit){
		return service.convert(input, unit);
	}
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}
}
