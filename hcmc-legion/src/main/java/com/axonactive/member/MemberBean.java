package com.axonactive.member;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

@ManagedBean(name = "memberBean")
@ViewScoped
public class MemberBean implements Serializable {

	private static final long serialVersionUID = 6620131034663738301L;
	private static final Logger LOGGER = Logger.getLogger(MemberBean.class);

	@EJB
	private MemberService memberService;

	private MemberBOM memberBOM;

	@PostConstruct
	public void init() {
		memberBOM = new MemberBOM();
	}

	public String insert() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Insert Member : \n\tname:" + memberBOM.getName() + "\n\tdateOfBirth: "
					+ memberBOM.getDateOfBirth() + "\n\thometown: " + memberBOM.getHometown() + "\n\tgender:"
					+ memberBOM.getGender() + "\n\tprogrammingLanguage:" + memberBOM.getProgrammingLanguageString() + "\n\tuniversity:" + memberBOM.getUniversity());
		}
		try {
			memberService.save(memberService.toEntity(memberBOM));
		} catch (Exception e) {
			LOGGER.error("Insert a member", e);
			throw e;
		}
		return "welcome?faces-redirect=true";
	}

	public String delete(Integer id) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Delete a member who has id is " + id);
		}
		try {
			memberService.remove(id);
		} catch (Exception e) {
			LOGGER.error("Delete a member", e);
			throw e;
		}
		return "welcome?faces-redirect=true";

	}

	public MemberBOM getMemberBOM() {
		return memberBOM;
	}

	public void setMemberBOM(MemberBOM memberBOM) {
		this.memberBOM = memberBOM;
	}

}
