package com.jeremy.springcloud.service;

import java.util.List;

import com.jeremy.springcloud.entities.Dept;

public interface DeptService {

	public boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}
