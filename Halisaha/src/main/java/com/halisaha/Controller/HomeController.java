package com.halisaha.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import HalisahaServiceInterface.PersoneServiceInterface;
import Model.Person;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private PersoneServiceInterface personeService;

	@Autowired(required = true)
	// dispatcher içindekiyle niye ayný oluyor
	@Qualifier(value = "personeService")
	public void setPersoneServiceInterface(
			PersoneServiceInterface personeService) {
		this.personeService = personeService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Test() {
		Person person = new Person();
		person.setId(10);
		person.setName("Ali");
		this.personeService.addPerson(person);

		return "home";
	}

	@ResponseBody
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public List<Person> getPersone() {

		List<Person> list = this.personeService.listPersons();

		return list;

	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {

		return "test";
	}

	@ResponseBody
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public Person getPerson(@RequestParam(value = "id", required = false) int id) {
		return this.personeService.getPerson(id);

	}

}
