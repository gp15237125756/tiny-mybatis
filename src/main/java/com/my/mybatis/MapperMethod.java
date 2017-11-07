package com.my.mybatis;

import java.lang.reflect.Method;



public class MapperMethod {

	private Class<?> mapperInterface;
	private Method method;
	private Config config;
	
	public MapperMethod(Class<?> mapperInterface, Method method,
			Config config) {
		this.mapperInterface=mapperInterface;
		this.method=method;
		this.config=config;
	}
	
	public Object execute(SqlSession sqlSession, Object[] args) {
		String sql=SimpleExecutor.sql;
		return sqlSession.selectOne(sql,args[0]);
		
	}
	
}
