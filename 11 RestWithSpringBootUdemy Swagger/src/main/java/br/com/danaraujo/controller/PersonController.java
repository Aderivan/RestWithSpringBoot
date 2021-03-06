package br.com.danaraujo.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
import br.com.danaraujo.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Person Endpoint", description = "Description for person", tags = { "PersonEndpoint" })
@RestController
@RequestMapping("api/person/v1")
public class PersonController {

	@Autowired
	private PersonServices services;

	@ApiOperation(value = "Find all people recorded")
	@GetMapping(produces = { "application/json", "application/xml" })
	public List<PersonVO> findAll() {

		List<PersonVO> persons = services.findAll();

		persons.stream()
				.forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
		return persons;
	}

	@ApiOperation(value = "Find a people by record")
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	public PersonVO findById(@PathVariable("id") Long id) {

		PersonVO personVO = services.findById(id);

		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());

		return personVO;
	}

	@ApiOperation(value = "Create a new record")
	@PostMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml" })
	public PersonVO create(@RequestBody PersonVO person) {

		PersonVO personVO = services.create(person);

		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());

		return personVO;
	}
	@ApiOperation(value = "Update a record")
	@PutMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml" })
	public PersonVO update(@RequestBody PersonVO person) {
		PersonVO personVO = services.update(person);

		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());

		return personVO;
	}
	@ApiOperation(value = "Delete a record")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		services.delete(id);
	}
}
