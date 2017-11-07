tiny-mybatis
============


# 使用设计模式

+ 动态代理  `Sqisession`的接口方法，使用`MapperProxy`代理类具体实现；具体是通过`MapperRegistry`获得`MapperProxyFactory`,把invoke的行为
封装到`MapperMethod`中，调用`SqlSession`的方法。
+ 工厂模式  `MapperProxyFactory`  `SqlSessionFactory`
+ 模板方法  `BaseExecutor`和`SimpleExecutor`的关系 `BaseExecutor`中有protected方法doUpdate等在子类中实现  ；   BaseTypeHandler和BooleanTypeHandler等子类的关系类似
+ 建造在模式  `SqlSessionFactoryBuilder`创建`SqlSessionFactory`的默认实现`DefaultSqlSessionFactory`；`XMLMapperBuilder`的实现等。
+ 装饰模式   `Cache`的实现`SynchronizedCache`,`LruCache`等里面都有个Cache delegate成员变量，在子类实现上增加行为。	


    
 










		



				
