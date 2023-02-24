package com.example.finalpro.db;

import com.example.finalpro.vo.CustomerVO;
import com.example.finalpro.vo.NoticeVO;
import com.example.finalpro.vo.QnaVO;
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
		} catch (Exception e) {
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

	// 공지 등록
	public static int insertNotice(NoticeVO n){
		int re=-1;
		SqlSession session=sqlSessionFactory.openSession(true);
		re=session.insert("notice.insert",n);
		session.close();
		System.out.println("DBManager에서 re:"+re);
		return re;
	}

	// QNA 등록
    public static int insertQna(QnaVO q) {
		int re=-1;
		SqlSession session=sqlSessionFactory.openSession(true);
		re=session.insert("qna.insert",q);
		session.close();
		return re;
    }

	// QNA 답변 작성 및 수정
	public static int updateAnswer(QnaVO q){
		int re=-1;
		SqlSession session=sqlSessionFactory.openSession(true);
		re=session.update("qna.updateAnswer",q);
		session.close();
		return re;
	}

	public static int deleteAnswer(int qna_no){
		int re=-1;
		SqlSession session=sqlSessionFactory.openSession(true);
		re=session.update("qna.deleteAnswer",qna_no);
		session.close();
		return re;
	}
	// 비공개 QNA일 경우 작성자가 로그인한 사용자와 일치하는지 확인
//	public static int checkWriter(QnaVO q){
//		int re=-1;
//		SqlSession session=sqlSessionFactory.openSession(true);
//		re=session.selectOne("qna.checkWriter",q);
//		session.close();
//		return re;
//	}

	//QNA 목록에서 사용자가
	public static List<Integer> findTicketidByCustid(String custid){
		List<Integer> list=null;
		SqlSession session=sqlSessionFactory.openSession();
		list=session.selectList("book.findTicketidByCuistid", custid);
		session.close();
		return list;
	}
}