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

----- 23.02.23-24 관리자 페이지를 작성했다.

관리자 페이지에서는 작품과 고객 정보를 관리할 수 있다. 작품을 등록, 수정, 삭제하거나 고객 정보를 수정, 삭제, 내역 확인 등을 할 수 있다.
23,24일 + 25일 오전은 관리자 페이지의 insertTicket, updateTicket, listTicket 작업의 대부분을 완료하였다. 남은 건 페이징 처리 + 주소값 검색하면 자동으로 위도, 경도 불러오기.
이제 고객 정보 페이지를 만들면 된다. customer 페이지는 다음과 같은 구성이 요구된다.
회원 목록 출력
회원 정보 출력 (수정이랑 같이)
회원 검색
회원이 작성한 qna
회원이 예매한 내역
회원 정보 수정
회원 삭제

------ 23.02.25 고객 정보 페이지를 만들었다. 일부 기능은 아직 구현하지 않았지만 대다수는 만들었다. 이제 페이징 처리랑 검색만 하면 어느 정도 된다. 대부분 비슷한 작업에 논리적으로 어려운 작업이 없어서 성취감은 별로 없다.

회원 목록 출력 admin/customer/list
회원 정보 출력 (수정이랑 같이) admin/customer/update
회원 검색 X
회원이 작성한 qna admin/customer/listQna
회원이 예매한 내역 admin/customer/listTicket
회원 정보 수정 admin/customer/update
회원 삭제 admin/customer/delete

------ 23.02.26 고객 정보 페이지의 ticket, customer들 목록을 출력하는 list 페이지에서 페이징과 검색 기능을 완료했다. 일단 보이는 기능은 모두 잘 되는데 혹시 안되는 게 있을 수 있다는 걸 염두하자. 이를 위해 paging 클래스를 만들었다. 혹시 또 페이징을 한다면 유용하게 쓸 수 있을듯.

따로 controller에서 페이징 처리 작업을 열심히 하지 않더라도 thymeleaf로도 만들 수 있을 것이란 생각도 들었다. #number나 Stat을 활용하면 list의 번호들을 출력할 수 있으니까. 근데 일단 배운대로 + 구글링해서 검색한 걸 응용해서 만들었다.

이제 admin 페이지에서 남은 기능을 다음과 같다.

ticket, customer 에서 버튼 누르면 분류가 바뀌는 작업
ticket 목록 페이지에서 cateid에 따라 출력하기
ticket, customer에서 주소를 검색하는 api 적용하기 (위도, 경도도 자동으로 입력되도록)

------ 23.02.27-28

admin 페이지에서 ticket과 customer 정보를 입력, 수정할 때 지도가 나오도록 했다.
위도와 경도도 자동으로 나타나도록 설정하였다.
대신 주소 입력창이랑 주소 검색창이 달라서 이름은 수동으로 설정해야함.

------ 23.03.02

1. category 페이지에서 무한 스크롤 기능으로 ticket이 뜨는 거 완료.
2. admin/listTicket 이랑 admin/listCustomer에서 정렬하는 기능 추가.

------ 23.03.04
1. myPage에서 Qna 내역 보는 거 출력, 페이징 처리 완료 (단, 테이블과 페이징 요소 간의 CSS 처리는 아직)




2/15
- 은선: 인텔리J 및 Git 사용법 숙지

2/16
- 은선: 전체 테이블 컬럼 정리, 테이블 명세서 작성, 테이블 생성 SQL문 작성, 생성한 테이블에 맞게 VO 및 Entity 내용 수정

2/17
- 은선: 전체 테이블 컬럼 정리, 생성한 테이블에 맞게 VO 및 Entity 내용 수정
  2/26
  신윤경 : main, login, signup, mypage, detail css 정리완료
  (오류 -> main 우측 화살표 위치 조정, detail 테스트 필요, id,


// 남은 css 페이지 - 윤경

< admin -> customer >
- list.html
- listQna.html
- listTicket.html
- update.html

< admin -> ticket >
- insertTicket.html
- listTicket.html
- updateTicket.html

< qna notification (알람 homepage_frame 있는 모든 부분 적용) >



고운
- 2/19-2/20
  - Notice와 QNA의 list/detail 조회 기능 완성
- 2/21 
  - Spring Security 오류 해결
- 2/22 
  - QNA insert, Notice insert 기능 완성
- 2/23 
  - qna/detail 페이지에 관리자가 답글 작성/수정/삭제하는 기능 추가
  - QNA 글 공개 선택 여부/해당 작성자인지 여부에 따라 접근 제어
- 2/24 
  - qna/insert 페이지에 사용자가 예매한 티켓 정보 출력
- 2/25 
  - qna update & delete, notice update & delete 기능 완성
  - 조회수 증가 기능 추가
  - JS 파일 모듈화
- 2/26 
  - notice 페이징, 제목/내용 검색 기능, 카테고리별 보기 기능 추가
- 2/27 
  - 답변 알림 기능 추가 (새 테이블 notification 추가)
    -클릭하면 숫자 없어지기
    -알림 클릭하면 qna 상세페이지로 연결
    -x 누르면 삭제 (->ajax로) (화면에서 없어지기)
- 2/28
  - 전체 팀원 코드 merge 및 오류 수정
- 3/1
  - 회원가입, 회원정보 수정 페이지에서 카카오 주소 API를 적용해 사용자 주소를 입력받는 기능 추가
- 3/2
  - 예매 완료시 확인 문자메시지 전송 기능 추가
- 3/3
  - 마이페이지 내 후기(Review) 보기, 작성, 수정, 삭제 기능 추가
- 3/4
  - notification 수정(0개일 때 처리(숫자 표시 x, "알림이 없습니다." 출력))
  - myPageBook에서 insertReview로 넘어갈 때 이미 리뷰를 등록한 티켓이면 alert 띄우고 insert 화면으로 안 넘어가게 처리
  - QNA 답글 등록시 링크가 포함된 email 발송 기능
- 3/5
  - 전체 merge