package com.tutorial.dao.member;

import java.sql.SQLException;

import com.tutorial.dto.member.MemberVO;

public interface MemberDao {
	
	//회원 정보조회
	MemberVO selectMember(String id) throws SQLException;
}
