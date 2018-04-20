package com.axonactive.member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

@ManagedBean(name = "memberListBean")
@ViewScoped
public class MemberListBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1583084340414538009L;
	private static final Logger LOGGER = Logger.getLogger(MemberListBean.class);

	@EJB
	private MemberService memberService;

	private List<MemberBOM> members = new ArrayList<MemberBOM>();

	@PostConstruct
	public void init() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get the list of members");
		}
		try {
			members = memberService.toBoms(memberService.readAll());
		} catch (Exception e) {
			LOGGER.error("Get the list of members", e);
			throw e;
		}
	}

	public List<MemberBOM> getMembers() {
		// System.out.println(LOGGER.isDebugEnabled());
		return members;
	}

	public void setMembers(List<MemberBOM> members) {
		this.members = members;
	}

}
