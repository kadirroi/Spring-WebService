package HalisahaInterface;

import java.util.List;

import Model.Person;
public interface PersonInterface {

	
	public void addPerson(Person person );
	public void deletePerson(int personId);
	public void editPerson(Person person);
	public Person getPerson(int PersonId);
	public List<Person> listPersons ();
	
	
}
