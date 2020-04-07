package com.tutorial.dao.member;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.tutorial.dto.member.MemberVO;
import com.tutorial.mybatis.config.OracleFactory;

public class MemberDaoImpl implements MemberDao {
	
	private static MemberDaoImpl daoInstance;
	private SqlSessionFactory oracleFactory;
	
	private MemberDaoImpl() {
		oracleFactory = OracleFactory.getOracleFactory();
	}
	
	public static MemberDaoImpl getDaoInstance() {
		if(daoInstance == null) {
			daoInstance = new MemberDaoImpl();
		}
		return daoInstance;
	}
	

	@Override
	public MemberVO selectMember(String id) throws SQLException {
		SqlSession session = oracleFactory.openSession();
		MemberVO member = session.selectOne("member.selectMember",id);
		session.close();
		return member;
	}

}
