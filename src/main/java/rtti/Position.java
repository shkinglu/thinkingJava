package rtti;

import rtti.Person.NullPerson;

public  class Position {
	
	private String title;
	private Person person;
	
	public Position(String title,Person employee){
		this.title=title;
		this.person=employee;
		if(person==null){
			person=NullPerson.NULL;
		}
	}

	public Position(String title) {
		this.title=title;
		this.person=NullPerson.NULL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
		if(person==null){
			person=NullPerson.NULL;
		}
	}
}
