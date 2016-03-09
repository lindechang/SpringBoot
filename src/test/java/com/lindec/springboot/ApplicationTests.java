package com.lindec.springboot;

import com.lindec.springboot.repository.Person;
import com.lindec.springboot.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void contextLoads() {
		Person person = new Person();
		person.setAge(156);
		person.setName("lindec");
		personRepository.save(person);

	}

}
