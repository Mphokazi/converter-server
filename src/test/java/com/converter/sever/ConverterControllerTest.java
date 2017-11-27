package com.converter.sever;

import org.apache.catalina.filters.CorsFilter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.converter.sever.conf.WebConfig;
import com.converter.sever.controller.ConverterController;
import com.converter.sever.dto.ConvertDTO;
import com.converter.sever.service.ConverterService;
import com.converter.sever.util.Unit;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class ConverterControllerTest {

	@Autowired
	private WebApplicationContext applicationContext;
	private MockMvc mockMvc;
	
	@Mock
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
				.accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isNotFound())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.to").value(0.08));
		
	}
	
	@Test
	public void testConvertToMetersCentimeters() throws Exception {
		
		this.mockMvc.perform(get("/api/convert?input=8&unitName=CENTIMETERS")
				.accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isNotFound())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.to").value(800.0));
		
	}
	
	@Test
	public void testConvertCelciousToFarenheit() throws Exception {
		
		this.mockMvc.perform(get("/api/convert?input=10&unitName=FARENHEIT")
				.accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isNotFound())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.to").value(46.4));
		
	}
	
	@Test
	public void testConvertFarenheitToCelcious() throws Exception {
		
		this.mockMvc.perform(get("/api/convert?input=8&unitName=CELCIOUS")
				.accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isNotFound())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.to").value(-13.333333333333334));
		
	}
}
