package com.my.mybatis;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * proxy object for interface
 * @author Xerxes
 *
 */
public class MapperProxy implements InvocationHandler,Serializable{

	private static final long serialVersionUID = -7804598630120539125L;

	private final Class<?> mapperInterface;
	
	private final SqlSession sqlSession;
	
	private Map<Method, MapperMethod> methodCache;
	
	public  MapperProxy(SqlSession sqlSession,Class<?> mapperInterface,Map<Method, MapperMethod> methodCache){
		this.mapperInterface=mapperInterface;
		this.methodCache=methodCache;
		this.sqlSession=sqlSession;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if(method.getDeclaringClass().getClass().getSimpleName()=="Object"){
			return method.invoke(this, args);
		}
		MapperMethod handler=cacheMapperMethod(method);
		return handler.execute(sqlSession, args);
	}
	
	public MapperMethod cacheMapperMethod(Method method){
		MapperMethod ret=methodCache.get(method);
		if(ret==null){
			ret=new MapperMethod(mapperInterface,method,sqlSession.getConf());
			methodCache.put(method,ret);
		}
		return ret;
	}
	
	
	
	
	
	
	

}
