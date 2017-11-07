package com.my.mybatis;

import java.io.IOException;

public class MybatisBootstrapApplication {

	private static MybatisBootstrapApplication instance=new MybatisBootstrapApplication();
	
	public static MybatisBootstrapApplication me(){
		return instance;
	}
	
	void up() throws IOException{
		//real mybatis framework usage
		/*String resource = "mybatis-config.xml";  
        InputStream inputStream = Resources.getResourceAsStream(resource);  
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);  
        org.apache.ibatis.session.SqlSession session = sqlSessionFactory.openSession();  
        TicketBookingStatisticMapper dao = session.getMapper(TicketBookingStatisticMapper.class);  
        TicketBookingStatisticDto ticketBookingStatisticDto = dao.computeQuarterlySearchBookings(new String[]{"2","3"});  
        System.out.println(ticketBookingStatisticDto);  */
		
		
		
		//my own mybatis usage,the mapper interface can replace as ur own.
		//SqlSession SqlSession=new SqlSession();
		//TicketBookingStatisticMapper ticketBookingStatisticMapper=SqlSession.getMapper(TicketBookingStatisticMapper.class);
	   // UserInfo UserInfo = ticketBookingStatisticMapper.getUserInfo("LM000002");  
	   // System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>result: "+UserInfo.getUserName());
	}
	
	public static void main(String[] args) throws IOException {
		me().up();
	}
	
	
	
}
