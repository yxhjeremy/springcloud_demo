package com.jeremy.springcloud.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jeremy.springcloud.dao.DeptDao;
import com.jeremy.springcloud.entities.Dept;
import com.jeremy.springcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{

	@Resource
	private DeptDao deptDao;
	
	
	@Override
	public boolean addDept(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.addDept(dept);
	}

	@Override
	public Dept findById(Long id) {
		// TODO Auto-generated method stub
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		return deptDao.findAll();
	}

}
