package com.axonactive.member;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("member")
public class MemberRest {

	@EJB
	private MemberService memberService;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<MemberBOM> readAll(){
		return memberService.toBoms(memberService.readAll());
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public void save(MemberBOM memberBOM){
		 memberService.save(memberService.toEntity(memberBOM));
	}
}
