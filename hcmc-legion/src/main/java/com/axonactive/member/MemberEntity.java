package com.axonactive.member;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class MemberEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="dateOfBirth", nullable=false)
	private Date dateOfBirth;
	
	@Column(name="hometown", nullable=false)
	private String hometown;
	
	@Column(name="gender", nullable=false)
	private String gender;
	
	@Column(name="programmingLanguage", nullable=false)
	private String programmingLanguage;

	@Column(name="university", nullable=false)
	private String university;
	

	public MemberEntity(int id, String name, Date dateOfBirth, String hometown, String gender,
			String programmingLanguage, String university) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.hometown = hometown;
		this.gender = gender;
		this.programmingLanguage = programmingLanguage;
		this.university = university;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getHometown() {
		return hometown;
	}


	public void setHometown(String hometown) {
		this.hometown = hometown;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getProgrammingLanguage() {
		return programmingLanguage;
	}


	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}


	public String getUniversity() {
		return university;
	}


	public void setUniversity(String university) {
		this.university = university;
	}


	public MemberEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
