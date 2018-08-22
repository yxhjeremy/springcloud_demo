package com.jeremy.springcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 

import com.jeremy.springcloud.entities.Dept;
import com.jeremy.springcloud.service.DeptClientService;

@RestController
public class DeptController_Consumer {

	@Resource
	private DeptClientService service;
 

	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return this.service.add(dept);
	}

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return this.service.get(id);
	}

	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		return this.service.list();
	}

}
