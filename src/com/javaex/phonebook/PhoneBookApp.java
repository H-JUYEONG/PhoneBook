package com.javaex.phonebook;

import java.util.List;

public class PhoneBookApp {

	public static void main(String[] args) {

		PersonDao personDao = new PersonDao();

		// 추가
		// personDao.insertPerson("유재석", "010-1111-7777", "02-3434-6666");

		// 삭제
		// personDao.deletePerson(4);

		// 수정
		// personDao.updatePerson("황정민", 5);

		// 조회1
		// PersonVo personVo = personDao.selectPersonOne(1);
		// System.out.print(personVo.getPersonId() + ". ");
		// System.out.print(personVo.getPersonName() + "\t");
		// System.out.print(personVo.getPersonHp() + "\t");
		// System.out.print(personVo.getPersonCompany());

		// 전체 조회
		List<PersonVo> personList = personDao.selectPersonAll();
		for (int i = 0; i < personList.size(); i++) {
			System.out.print(personList.get(i).getPersonId() + ". ");
			System.out.print(personList.get(i).getPersonName() + "\t");
			System.out.print(personList.get(i).getPersonHp() + "\t");
			System.out.println(personList.get(i).getPersonCompany());
		}

	}

}
