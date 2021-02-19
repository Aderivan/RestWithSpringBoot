package br.com.danaraujo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.danaraujo.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();

	public List<Person> findAll() {

		List<Person> persons = new ArrayList<>();

		for (int i = 0; i < 8; i++) {

			Person person = mockPerson(i);
			persons.add(person);

		}

		return persons;
	}

	public Person findById(String id) {

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("José");
		person.setLastName("Araújo");
		person.setAddress("Rua qualquer - PE - Brasil");
		person.setGender("Male");
		return person;
	}
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		//TODO
	}

	private Person mockPerson(int i) {

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name" + i);
		person.setLastName("Last name");
		person.setAddress("Some address in Brasil" + i);
		person.setGender("Male");
		return person;
	}
}
