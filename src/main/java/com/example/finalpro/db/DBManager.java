package com.example.finalpro.db;

import com.example.finalpro.vo.CustomerVO;
import com.example.finalpro.vo.TicketVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class DBManager {
	public static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			System.out.println("ok1");
			String resource = "db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			System.out.println("ok2");
			sqlSessionFactory =
			  new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static List<CustomerVO> findAll() {
		List<CustomerVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("customer.findAll");
		session.close();
		return list;
	}

	// 메인 페이지에서 카테고리 , 시간 별로 상영작 출력하기
	// time=0은 과거, time=1은 현재, time=2는 미래
	public static List<TicketVO> findAllTicketByCategory(int time, int cateid){
		List<TicketVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("ticket.findAllTicketByCategory");
		session.close();

		return list;
	}

//	public static List<CustomerVO> findAll() {
//		List<CustomerVO> list = null;
//		SqlSession session = sqlSessionFactory.openSession();
//		list = session.selectList("customer.findAll");
//		session.close();
//		return list;
//	}
}
