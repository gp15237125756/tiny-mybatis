package com.my.mybatis;


public class Config {
	
	private MapperRegistry mapperRegistry;

	public Config() {
		super();
		this.mapperRegistry = new MapperRegistry(this);
	}

	public MapperRegistry getMapperRegistry() {
		return mapperRegistry;
	}

	public void setMapperRegistry(MapperRegistry mapperRegistry) {
		this.mapperRegistry = mapperRegistry;
	}
	
	

}
