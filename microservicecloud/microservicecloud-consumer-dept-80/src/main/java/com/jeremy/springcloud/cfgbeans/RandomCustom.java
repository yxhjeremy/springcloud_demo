package com.jeremy.springcloud.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class RandomCustom {

	@Bean
	public IRule getRandomCustomRule() {
		return new RandomCustomRule();
	}
}
