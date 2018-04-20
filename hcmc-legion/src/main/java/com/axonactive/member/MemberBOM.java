package com.axonactive.member;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

public class MemberBOM implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8878846569356726969L;

	private Integer memberid;
	
	@NotBlank
	private String name;
	
	private Date dateOfBirth;
	
	@NotBlank
	private String hometown;
	
	private String gender = "Male";
	
	private String[] programmingLanguage = {"Other"};
	
	private String university;

	
	public MemberBOM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberBOM(Integer memberid, String name, Date dateOfBirth, String hometown, String gender,
			String[] programmingLanguage, String university) {
		super();
		this.memberid = memberid;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.hometown = hometown;
		this.gender = gender;
		this.programmingLanguage = programmingLanguage;
		this.university = university;
	}
	
	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
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

	public String[] getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String[] programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	public String getProgrammingLanguageString() {
		return String.join(", ", this.programmingLanguage);
	}
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
