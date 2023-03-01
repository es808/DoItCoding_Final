# DoItCoding_Final

### 👥 멤버구성
 - 김고운
 - 신윤경
 - 이명진
 - 유근형
 - 조영민
 - 황은선
<hr>

### ⚙️ 개발환경
 - java 17
 - DataBase : ORACLE
 - ORM : MyBatis, JPA
 - Framework : SpringBoot(3.0)

### 📝 프로젝트 기록
- 2/15 개발툴 기본설정 완료.

### 브런치
1.23.02.15 
유근형 브런치 생성.


2.23.02.17
2차 프로젝트의 main 페이지를 스프링으로 옮기기


---- 23.02.20
Spring 구조 복습

- main.html을 Spring으로 옮기기 (dao, entity, service, mapper 작성)
- 카테고리, 시간 별로 Ticket을 출력하는 경우 쿼리문이 복잡하기 때문에 jpa가 아니라 mybatis로 작성.

DAO / CustomerDAO, RankingDAO, ReviewDAO, TicketDAO

entity / Customer, Ranking

service / CustomerService, RankingService

resources/db/ TicketMapper.xml

----- 23.02.21
Spring으로 main과 search를 구현하는 중. 2차 프로젝트 때 했던 페이지를 Spring으로 다시 구현하는 중.

- Spring에서 Ajax를 하는 작업을 하고 있다. sql문이 복잡한 게 있어서 jpa보다 mybatis로 작업했다.
- Controller에서 @Resposebody를 통해 통신을 하면 Json 형태로 자동 변환해주기 때문에 Ajax 통신이 손쉬워진다.
- 오늘은 그 방법을 모색하느라 시간이 가서 main의 랭킹 출력밖에 못 했다. 더군다나 review가 없는데 출력하는 바람에 안 되는 걸 몰라서 1시간 가량 헤맸다. 뭘 테스트하든지 데이터 삽입을 먼저 하자.
- IntelliJ에서 CSS와 이미지 파일을 불러오기 위해서는 static 폴더에 넣어야 하는 것, 또한 html에서 해당 파일들의 경로를 지정할 때는 static를 쓰지 않아도 된다는 걸 알았다.
- 오랜만에 주도적으로 코딩하는 느낌이라 나름 재밌다. 근데 이게 학원에서 부담없이 배우는 작업이 아니라 돈 받고 하는 일이 된다면... 부담스럽다.



------ 23.02.22
Spring으로 main, search, category 구현 완료. 모두 복잡한 sql문이 있어서 mybatis로 작업.
- Spring에서 Ajax 하는 방법을 찾았다. 모든 페이지가 비슷해서 손쉽게 할 수 있었다.
- mypage 작업만 하면 된다.





2/15
- 은선: 인텔리J 및 Git 사용법 숙지

2/16
- 은선: 전체 테이블 컬럼 정리, 테이블 명세서 작성, 테이블 생성 SQL문 작성, 생성한 테이블에 맞게 VO 및 Entity 내용 수정

2/17
- 은선: 전체 테이블 컬럼 정리, 생성한 테이블에 맞게 VO 및 Entity 내용 수정
  2/26
  신윤경 : main, login, signup, mypage, detail css 정리완료
  (오류 -> main 우측 화살표 위치 조정, detail 테스트 필요, id,






고운
- 2/19-2/20 Notice와 QNA의 list/detail 조회 기능 완성
- 2/21 Spring Security 오류 해결
- 2/22 QNA insert, Notice insert 기능 완성
- 2/23 qna/detail 페이지에 관리자가 답글 작성/수정/삭제하는 기능 추가
  QNA 글 공개 선택 여부/해당 작성자인지 여부에 따라 접근 제어
- 2/24 qna/insert 페이지에 사용자가 예매한 티켓 정보 출력
- 2/25 qna update & delete, notice update & delete 기능 완성
  조회수 증가 기능 추가
  JS 파일 모듈화
- 2/26 notice 페이징, 제목/내용 검색 기능, 카테고리별 보기 기능 추가
    - 2/27 답변 알림 기능 추가 (새 테이블 notification 추가)
      -클릭하면 숫자 없어지기
      -알림 클릭하면 qna 상세페이지로 연결
      -x 누르면 삭제 (->ajax로) (화면에서 없어지기)
