package br.com.danaraujo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.danaraujo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
