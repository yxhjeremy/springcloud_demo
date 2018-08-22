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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {

	@Resource
	private DeptService deptService;

	@PostMapping(value = "/dept/add")
	public boolean add(@RequestBody Dept dept) {
		return deptService.addDept(dept);
	}

	@GetMapping(value = "/dept/get/{id}") 
	@HystrixCommand(fallbackMethod="processHystrix_GET")
	public Dept get(@PathVariable("id") Long id) {
		 Dept dept = deptService.findById(id);
		 if(dept==null) {
			 throw new RuntimeException("未找到对应的数据!");
		 }
		 return dept;
	}

	@GetMapping(value = "/dept/list")
	public List<Dept> list() {
		return deptService.findAll();
	} 
	
	public Dept processHystrix_GET(@PathVariable("id") Long id) {
		return new Dept().setDbSource("no data").setDeptNo(id).setDName("该ID:"+id+"没有对应的数据!");
	}
}
