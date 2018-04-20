package com.axonactive.member;

import java.util.List;

import javax.ejb.Stateless;

import com.axonactive.common.GenericServices;

@Stateless
public class MemberService extends GenericServices<MemberEntity, MemberBOM>{

	public MemberService() {
		super(MemberEntity.class);
	}

	public List<MemberEntity> readAll(){
		return em.createQuery("Select m from MemberEntity m", MemberEntity.class).getResultList();
	}
	
	
	@Override
	public MemberEntity toEntity(MemberBOM bom) {
		return new MemberEntity(bom.getMemberid() == null ? 0 : bom.getMemberid(), bom.getName(), bom. getDateOfBirth(), bom.getHometown(), bom.getGender(), String.join(", ", bom.getProgrammingLanguage()), bom.getUniversity());
	}

	@Override
	public MemberBOM toBom(MemberEntity entity) {
		if (entity != null) {
			MemberBOM emp = new MemberBOM(entity.getId(), entity.getName(), entity. getDateOfBirth(), entity.getHometown(), entity.getGender(), entity.getProgrammingLanguage().split(", "), entity.getUniversity());
			return emp;
		}
		return null;
	}
	
	
}
