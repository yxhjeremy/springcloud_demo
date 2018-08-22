package com.jeremy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	@Value("${server.port}")
	private Integer port;
	@Value("${spring.application.name}")
	private String applicationName;
	@Value("${spring.profiles}")
	private String profile;
	
	@RequestMapping(value="/config",method=RequestMethod.GET)
	public String getConfig() {
		 return "port:"+port+",name:"+applicationName+",profile:"+profile;
	}
	
}

