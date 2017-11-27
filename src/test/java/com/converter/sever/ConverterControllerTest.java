package com.converter.sever;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.converter.sever.controller.ConverterController;
import com.converter.sever.service.ConverterService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest( value = ConverterController.class, secure = false)
public class ConverterControllerTest {

	@Autowired
	private WebApplicationContext applicationContext;
	private MockMvc mockMvc;
	
	@MockBean
	private ConverterService service;
	
	@InjectMocks
	private ConverterController converterController;
	
	@Before
	public void init() {
		 DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.applicationContext);
	      this.mockMvc = builder.build();
	}
	
	@Test
	public void testConvertCentimetersToMeters() throws Exception {
		
		this.mockMvc.perform(get("/api/convert?input=8&unitName=METERS")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	@Test
	public void testConvertToMetersCentimeters() throws Exception {
		
		this.mockMvc.perform(get("/api/convert?input=8&unitName=CENTIMETERS")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	@Test
	public void testConvertCelciousToFarenheit() throws Exception {
		
		this.mockMvc.perform(get("/api/convert?input=10&unitName=FARENHEIT")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
	
	@Test
	public void testConvertFarenheitToCelcious() throws Exception {
		this.mockMvc.perform(get("/api/convert?input=8&unitName=CELCIOUS")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
	}
}
