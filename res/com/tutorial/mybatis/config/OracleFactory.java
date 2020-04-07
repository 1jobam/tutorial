package com.tutorial.mybatis.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class OracleFactory {
	
	private OracleFactory() {}
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		String config = "com/tutorial/mybatis/config/sqlConfig.xml";
		
		Reader reader;
		
		try {
			reader = Resources.getResourceAsReader(config);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
			System.out.println("Factory 성공...");
		} catch (IOException e) {
			System.out.println("Factory 실패!!!");
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getOracleFactory() {
		return sqlSessionFactory;
	}

}
