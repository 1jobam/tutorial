package com.tutorial.service.member;

import java.sql.SQLException;

import com.tutorial.dto.member.MemberVO;
import com.tutorial.exception.NotFoundLoginException;

public interface MemberService {
	
	//로그인
	void login(String id, String pwd) throws SQLException, NotFoundLoginException;

	//회원 정보조회
	MemberVO getMember(String id) throws SQLException;
}
