package com.my.mybatis;




public class SqlSession {

	//private Configuration config=null;
	
	private Executor executor=new SimpleExecutor();
	
	private Config conf=new Config();
	
	
	
	public <T> T getMapper(Class<T> mapperInterface){
		return conf.getMapperRegistry().getMapper(mapperInterface, this);
	}
	
	public <T> T selectOne(String statement, Object parameter){
		return executor.query(statement, parameter);
	}

	public Config getConf() {
		return conf;
	}

	


}
