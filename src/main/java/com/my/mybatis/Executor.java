package com.my.mybatis;

public interface Executor {

	<T> T query(String statement,Object param);
}
