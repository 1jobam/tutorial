package com.tutorial.service.member;

import java.sql.SQLException;

import com.tutorial.dao.member.MemberDao;
import com.tutorial.dao.member.MemberDaoImpl;
import com.tutorial.dto.member.MemberVO;
import com.tutorial.exception.NotFoundLoginException;

public class MemberServiceImpl implements MemberService {
	
	private static MemberServiceImpl serviceInstance;
	
	private MemberDao memberdao;
	
	private MemberServiceImpl() {
		memberdao = MemberDaoImpl.getDaoInstance();
	}
	
	public static MemberServiceImpl getServiceInstance() {
		if(serviceInstance == null) {
			serviceInstance = new MemberServiceImpl();
		}
		return serviceInstance;
	}

	@Override
	public void login(String id, String pwd) throws SQLException, NotFoundLoginException {
		MemberVO member = memberdao.selectMember(id);
		if(member == null || !(pwd.equals(member.getPwd()))) throw new NotFoundLoginException();
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO member = memberdao.selectMember(id);
		return member;
	}

}
