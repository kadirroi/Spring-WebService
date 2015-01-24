package HalisahaServiceInterfaceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import HalisahaServiceInterface.PersoneServiceInterface;
import Model.Person;
import HalisahaInterface.PersonInterface;

@Service
public class PersoneServiceInterfaceImpl implements PersoneServiceInterface {

	private PersonInterface personInterface;
	public void setPersonInterface(PersonInterface personInterface) {
		this.personInterface = personInterface;
	}
	
	@Transactional
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		this.personInterface.addPerson(person);
	}


	@Transactional
	public void deletePerson(int personId) {
		// TODO Auto-generated method stub
		this.personInterface.deletePerson(personId);
	}


	@Transactional
	public void editPerson(Person person) {
		// TODO Auto-generated method stub
		this.personInterface.editPerson(person);
	}

	@Transactional
	public Person getPerson(int PersonId) {
		// TODO Auto-generated method stub
		return this.personInterface.getPerson(PersonId);
	
	}
	@Transactional
	public List<Person> listPersons() {
		// TODO Auto-generated method stub
		return this.personInterface.listPersons();
	}

}
