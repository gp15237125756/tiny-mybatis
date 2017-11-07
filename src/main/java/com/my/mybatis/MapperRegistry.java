package com.my.mybatis;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.binding.BindingException;

public class MapperRegistry {

	private Config config;
	//缓存MapperProxyFactory
	private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap();
	
	public MapperRegistry(Config config){
		this.config=config;
	}
	
	public <T> boolean hasMapper(Class<T> type) {
		return this.knownMappers.containsKey(type);
	}
	
	public void addMapper(Class type){
			if(type.isInterface()) {
				if (this.hasMapper(type)) {
					throw new BindingException("Type " + type
							+ " is already known to the MapperRegistry.");
				}
				this.knownMappers.put(type, new MapperProxyFactory(type));
			}

	}
	
	public <T> T getMapper(Class<T> type, SqlSession sqlSession){
		addMapper(type);
		MapperProxyFactory mapperProxyFactory = (MapperProxyFactory)this.knownMappers
				.get(type);
		if (mapperProxyFactory == null) {
			throw new BindingException(
					"Error getting mapperProxyFactory instance. ");
		} else {
			try {
				return (T)mapperProxyFactory.newInstance(sqlSession);
			} catch (Exception arg4) {
				throw new BindingException(
						"Error getting mapper instance. Cause: " + arg4, arg4);
			}
		}
	}
	
	public Collection<Class<?>> getMappers() {
		return Collections.unmodifiableCollection(this.knownMappers.keySet());
	}

}
