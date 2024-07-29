package com.javaex.phonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/person_db";
	private String id = "person";
	private String pw = "person";

	private void getConnection() {

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}

	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}
	
	// 추가
		public int insertPerson(String name, String hp, String company) {

			int count = -1;

			this.getConnection();

			try {
				// 3. SQL문 준비 / 바인딩 / 실행
				// *sql문 준비
				String query = "";
				query += " insert into person ";
				query += " values(null, ?, ?, ?) ";

				// *바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, name);
				pstmt.setString(2, hp);
				pstmt.setString(3, company);

				// *실행
				count = pstmt.executeUpdate();

				// 4.결과처리
				System.out.println(count + "건 등록되었습니다.");

			} catch (SQLException e) {
				System.out.println("error:" + e);
			} 
			
			this.close();

			return count;
		}

		// 삭제
		public int deletePerson(int id) {

			int count = -1;
			
			this.getConnection();

			try {
				// 3. SQL문 준비 / 바인딩 / 실행
				// *sql문 준비
				String query = "";
				query += " delete from person ";
				query += " where person_id = ? ";

				// *바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, id);

				// *실행
				count = pstmt.executeUpdate();

				// 4.결과처리
				System.out.println(count + "건 삭제되었습니다.");

			} catch (SQLException e) {
				System.out.println("error:" + e);
			} 
			
			this.close();

			return count;
		}

		// 수정
		public int updatePerson(String name, int id) {

			int count = -1;
			
			this.getConnection();

			try {
				// 3. SQL문 준비 / 바인딩 / 실행
				// *sql문 준비
				String query = "";
				query += " update person ";
				query += " set person_name = ? ";
				query += " where person_id = ? ";

				// *바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, name);
				pstmt.setInt(2, id);

				// *실행
				count = pstmt.executeUpdate();

				// 4.결과처리
				System.out.println(count + "건 업데이트 되었습니다.");

			} catch (SQLException e) {
				System.out.println("error:" + e);
			} 

			this.close();

			return count;
		}

		// 조회1
		public PersonVo selectPersonOne(int id) {

			PersonVo personVo = null;
			
			this.getConnection();
			
			try {
				// 3. SQL문 준비 / 바인딩 / 실행
				// sql문 준비(insert문을 자바의 문자열로 만든다.)
				String query = "";
				query += " select person_id, ";
				query += "		  person_name, ";
				query += "        person_hp, ";
				query += "        person_company ";
				query += " from person ";
				query += " where person_id = ? ";

				// 바인딩
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, id);

				// 실행
				rs = pstmt.executeQuery();

				// 4.결과처리
				rs.next();
				int personId = rs.getInt("person_id");
				String name = rs.getString("person_name");
				String hp = rs.getString("person_hp");
				String company = rs.getString("person_company");

				personVo = new PersonVo(personId, name, hp, company);

			} catch (SQLException e) {
				System.out.println("error:" + e);
			} 
			
			this.close();
			
			return personVo;
		}

		// 전체 조회
		public List<PersonVo> selectPersonAll() {

			List<PersonVo> personList = new ArrayList<PersonVo>();

			this.getConnection();
			
			try {
				// 3. SQL문 준비 / 바인딩 / 실행
				// sql문 준비(insert문을 자바의 문자열로 만든다.)
				String query = "";
				query += " select person_id, ";
				query += "		  person_name, ";
				query += "        person_hp, ";
				query += "        person_company ";
				query += " from person ";

				// 바인딩
				pstmt = conn.prepareStatement(query);

				// 실행
				rs = pstmt.executeQuery();

				// 4.결과처리
				while (rs.next()) {
					int personId = rs.getInt("person_id");
					String name = rs.getString("person_name");
					String hp = rs.getString("person_hp");
					String company = rs.getString("person_company");

					PersonVo personVo = new PersonVo(personId, name, hp, company);
					personList.add(personVo);
				}

			} catch (SQLException e) {
				System.out.println("error:" + e);
			} 
			
			this.close();
			
			return personList;
		}
}
