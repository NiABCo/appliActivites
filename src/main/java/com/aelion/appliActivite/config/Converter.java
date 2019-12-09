package com.aelion.appliActivite.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Converter<T> {

	@Bean
	public ModelMapper initMapper() {
		return new ModelMapper();
	}
	
	
}
