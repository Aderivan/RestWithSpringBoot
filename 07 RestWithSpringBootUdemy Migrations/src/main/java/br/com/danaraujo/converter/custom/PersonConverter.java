package br.com.danaraujo.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.danaraujo.data.model.Person;
import br.com.danaraujo.data.vo.tempversion.PersonVOTempVersion;

@Service
public class PersonConverter {
	
	public PersonVOTempVersion convertEntityToVo(Person person) {
		PersonVOTempVersion vo = new PersonVOTempVersion();
		
		vo.setId(person.getId());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setAddress(person.getAddress());
		vo.setBirthday(new Date());
		vo.setGender(person.getGender());
		return vo;
	}
	
	public Person convertVoToEntity(PersonVOTempVersion personTemp) {
		Person person = new Person();
		
		person.setId(personTemp.getId());
		person.setFirstName(personTemp.getFirstName());
		person.setLastName(personTemp.getLastName());
		person.setAddress(personTemp.getAddress());		
		person.setGender(personTemp.getGender());
		return person;
	}
}
