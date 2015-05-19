package com.sds.icto.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.icto.mysite.domain.MemberVo;
import com.sds.icto.mysite.repository.MemberDao;

@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	
	public void joinUser( MemberVo vo  ) {
		memberDao.insert(vo);	
	}
	
	public MemberVo authUser( MemberVo vo ) {
		MemberVo memberVo = memberDao.getMember(vo);
		return memberVo;
	}
}
