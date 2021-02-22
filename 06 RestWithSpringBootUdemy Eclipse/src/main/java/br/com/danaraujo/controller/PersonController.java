package br.com.danaraujo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danaraujo.data.vo.PersonVO;
import br.com.danaraujo.data.vo.tempversion.PersonVOTempVersion;
import br.com.danaraujo.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices services;

	@GetMapping
	public List<PersonVO> findAll() {

		return services.findAll();
	}

	@GetMapping("/{id}")
	public PersonVO findBiId(@PathVariable("id") Long id) {

		return services.findById(id);
	}
	
	@PostMapping
	public PersonVO create(@RequestBody PersonVO person) {
		
		return services.create(person);
	}
	
	@PostMapping("/v2")
	public PersonVOTempVersion createTempVersion(@RequestBody PersonVOTempVersion person) {
		
		return services.createTempVersion(person);
	}

	@PutMapping
	public PersonVO update(@RequestBody PersonVO person) {
		return services.update(person);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		services.delete(id);
	}
 }
