package com.example.finalpro.db;

import com.example.finalpro.entity.Customer;
import com.example.finalpro.vo.CustomerVO;
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
			String resource = "db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
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

	public static int updateCustomer(CustomerVO customer){
		int i = -1;
		System.out.println("DB가동");
		System.out.println(customer);
		SqlSession session = sqlSessionFactory.openSession();
		session.update("customer.updateCustomer", customer);
		System.out.println(i);
		session.commit();
		session.close();
		return i;
	}

//	public static List<CustomerVO> findAll() {
//		List<CustomerVO> list = null;
//		SqlSession session = sqlSessionFactory.openSession();
//		list = session.selectList("customer.findAll");
//		session.close();
//		return list;
//	}
}
