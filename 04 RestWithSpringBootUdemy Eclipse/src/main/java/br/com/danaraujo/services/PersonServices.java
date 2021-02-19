package br.com.danaraujo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danaraujo.exception.ResourceNotFoundExceptionCustomized;
import br.com.danaraujo.model.Person;
import br.com.danaraujo.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		
		return repository.findAll();
	}

	public Person findById(Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptionCustomized("No records found for this ID"));

	}

	public Person create(Person person) {
		return repository.save(person);
	}

	public Person update(Person person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundExceptionCustomized("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}

	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptionCustomized("No records found for this ID"));
		
		repository.delete(entity);
	}

}
