package com.example.finalpro.db;

import com.example.finalpro.entity.Qna;
import com.example.finalpro.vo.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
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

	public static List<CustomerVO> findAllCustomer() {
		List<CustomerVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("customer.findAll");
		session.close();
		return list;
	}

	public static List<TicketVO> findAllTicket(){
		List<TicketVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("ticket.findAll");
		session.close();
		return list;
	}

	public static List<BookVO> findAllBook(){
		List<BookVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("book.findAll");
		session.close();
		return list;
	}

	public static List<CategoryVO> findAllCategory(){
		List<CategoryVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("category.findAll");
		session.close();
		return list;
	}

	public static List<DrawVO> findAllDraw(){
		List<DrawVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("draw.findAll");
		session.close();
		return list;
	}

	public static List<NoticeVO> findAllNotice(){
		List<NoticeVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("notice.findAll");
		session.close();
		return list;
	}
	public static List<PlaceVO> findAllPlace(){
		List<PlaceVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("place.findAll");
		session.close();
		return list;
	}

	public static List<QnaVO> findAllQna(){
		List<QnaVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("qna.findAll");
		session.close();
		return list;
	}

	public static List<ReviewVO> findAllReview(){
		List<ReviewVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("review.findAll");
		session.close();
		return list;
	}

	public static List<SeatVO> findAllSeat(){
		List<SeatVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("seat.findAll");
		session.close();
		return list;
	}

	// 특정 좌석의 잔여좌석 조회
	public static int findLeftSeatByTicketid(int ticketid){
		int num = 0;
		SqlSession session = sqlSessionFactory.openSession();
		num = session.selectOne("seat.selectLeftSeat",ticketid);
		System.out.println("잔여좌석DBM에서:"+num);
		session.close();
		return num;
	}

	// 티켓 상세 정보 조회
	public static TicketVO findByTicketid(int ticketid){
		TicketVO t = null;
		SqlSession session = sqlSessionFactory.openSession();
		t = session.selectOne("ticket.findByTicketid", ticketid);
		System.out.println("ticket객체:"+t);
		session.close();
		return t;
	}

	// 메인 페이지에서 카테고리 , 시간 별로 상영작 출력하기
	// time=0은 과거, time=1은 현재, time=2는 미래
	public static List<TicketVO> findAllTicketByCategory(int time, int cateid){
		List<TicketVO> list = null;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("time", time);
		map.put("cateid", cateid);

		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("ticket.findAllTicketByCategory", map);
		session.close();

		return list;
	}

	public static List<RankingVO> findAllRankingOrderByScore(int cateid){
		List<RankingVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("ranking.findAllRankingOrderByScore", cateid);

		session.close();

		return list;
	}

	public static List<TicketVO> findSearchTicket(String keyword){
		List<TicketVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("ticket.findSearchTicket", keyword);
		session.close();
		return list;
	}

	// 티켓의 리뷰 출력, 정렬
	public static List<ReviewVO> findReviewByTicketid(int ticketid, int re){
		List<ReviewVO> list = null;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ticketid", ticketid);
		map.put("re", re);
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("review.findReviewByTicketid",map);
		session.close();
		return list;
	}

	// 사용자의 티켓리뷰 출력
	public static List<MyReviewVO> findReviewByTicketAndCust(String custid, int ticketid){
		List<MyReviewVO> list = null;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("custid", custid);
		map.put("ticketid", ticketid);
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("review.reviewByTicketAndCust",map);
		session.close();
		return list;
	}

	// ticketid로 리뷰내역이 있나 확인
	public static List<MyReviewVO> checkReviewByTicketid(int ticketid){
		List<MyReviewVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("review.checkReview",ticketid);
		session.close();
		return list;
	}

	// 티켓 후기의 평균별점 구하기
	public static int findAvgScore(int ticketid){
		int avg = 0;
		SqlSession session = sqlSessionFactory.openSession();
		avg = session.selectOne("review.findAvgScore",ticketid);
		session.close();
		return avg;
	}

//	public static List<CustomerVO> findAll() {
//		List<CustomerVO> list = null;
//		SqlSession session = sqlSessionFactory.openSession();
//		list = session.selectList("customer.findAll");
//		session.close();
//		return list;
//	}
}
