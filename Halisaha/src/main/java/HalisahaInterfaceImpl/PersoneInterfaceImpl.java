package HalisahaInterfaceImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import HalisahaInterface.PersonInterface;
import Model.Person;

@Repository
public class PersoneInterfaceImpl implements PersonInterface {

	private SessionFactory sessionFactory;

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}

	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(person);

	}

	@Override
	public void deletePerson(int personId) {
		// TODO Auto-generated method stub

		Session session = this.sessionFactory.getCurrentSession();
		Person person = (Person) session.load(Person.class, new Integer(
				personId));
		
		if (person != null) {

			session.delete(person);

		}

	}

	@Override
	public void editPerson(Person person) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(person);
		
		
		
	}

	@Override
	public Person getPerson(int PersonId) {
		// TODO Auto-generated method stub
		Session session =this.sessionFactory.getCurrentSession();
		Person person = (Person) session.get(Person.class, new Integer(
				PersonId));
       
		return person;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Person> listPersons() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
	
	
		List<Person> listPerson = session.createQuery("from Person").list();
		
		return listPerson;
	}

}
