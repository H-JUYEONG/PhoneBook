package com.javaex.phonebook;

public class PersonVo {

	private int personId;
	private String personName;
	private String personHp;
	private String personCompany;

	public PersonVo() {

	}

	public PersonVo(int personId, String personName, String personHp, String personCompany) {
		this.personId = personId;
		this.personName = personName;
		this.personHp = personHp;
		this.personCompany = personCompany;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonHp() {
		return personHp;
	}

	public void setPersonHp(String personHp) {
		this.personHp = personHp;
	}

	public String getPersonCompany() {
		return personCompany;
	}

	public void setPersonCompany(String personCompany) {
		this.personCompany = personCompany;
	}

}
