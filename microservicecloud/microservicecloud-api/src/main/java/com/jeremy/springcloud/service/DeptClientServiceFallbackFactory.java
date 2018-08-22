package com.jeremy.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jeremy.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component  // 千万不能忘记添加 ,否则启动报错
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {
		 
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				 
				return null;
			}
			
			@Override
			public Dept get(Long id) { 
				return new Dept().setDbSource("no data!").setDeptNo(id).setDName("由于服务降级, 该微服务暂停提供服务!");
			}
			
			@Override
			public boolean add(Dept dept) { 
				return false;
			}
		};
	}

}
