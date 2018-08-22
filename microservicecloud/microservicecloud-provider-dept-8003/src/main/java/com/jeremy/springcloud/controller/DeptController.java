package com.jeremy.springcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jeremy.springcloud.entities.Dept;
import com.jeremy.springcloud.service.DeptService;

@RestController
public class DeptController {

	@Resource
	private DeptService deptService;

	@PostMapping(value = "/dept/add")
	public boolean add(@RequestBody Dept dept) {
		return deptService.addDept(dept);
	}

	@GetMapping(value = "/dept/get/{deptNo}")
	public Dept get(@PathVariable("deptNo") Long deptNo) {
		return deptService.findById(deptNo);
	}

	@GetMapping(value = "/dept/list")
	public List<Dept> list() {
		return deptService.findAll();
	}

}
