package com.RestApi.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.Repository.RestRepository;
import com.RestApi.entity.RestEntity;

@RestController
public class RestControl {
	
	@Autowired
	private RestRepository repo;
	
	@GetMapping("/get")
	public List<RestEntity> getData() {
		return repo.findAll();
	}
	
	@PostMapping("/post/{name}/{last}")
	public RestEntity postData(@PathVariable ("name") String fname,
			               @PathVariable ("last") String slast) {
	    RestEntity entity = new RestEntity();
	    entity.setName(fname);
	    entity.setLast(slast);
	    return repo.save(entity);
	}
	
	@PutMapping("/put")
	public RestEntity putData(@RequestBody RestEntity entity) {
		return repo.save(entity);
	}
	
	@DeleteMapping("/delete")
	public List<RestEntity> deleteData(String name) {
		return repo.deleteByName(name);
	}

}
