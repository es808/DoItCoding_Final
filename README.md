# T-Catch 통합 예매 사이트

### 📓 프로젝트 개요
인터파크 티켓, YES24 티켓 등과 같이 영화 시사회, 뮤지컬, 연극, 콘서트를 예매할 수 있는 통합 예매 사이트입니다.

상영일 기준 2주 이내의 상영작을 현재 상영작으로 정의하여 해당 상영작을 예매할 수 있습니다.

또한 매진이 된 상영작의 경우, 취소표에 한해 대기표를 신청할 수 있는 드로우(Draw) 기능이 구현되어 있습니다. 드로우는 상영 전날 신청한 인원에 한해 랜덤으로 추첨이 이루어집니다.

그 외 주요 구현 기능은 다음과 같습니다.

 - 회원가입 및 로그인, 아이디 비밀번호 찾기(인증코드 이메일, 핸드폰으로 검증).<br>
 - 5점 만점으로 리뷰 남기기.<br>
 - 리뷰 점수를 바탕으로 메인 화면에서 카테고리 별로 랭킹 3위까지 출력.<br>
 - 카카오 챗봇을 통한 간단한 상담 (현재 불가능)<br>
 - 일반적인 사항 혹은 사용자가 예매한 상영작에 대한 1대1 문의 (비밀 글 처리 가능).<br>
 - 관리자 페이지에서 상영작, 회원 정보 관리 (입력, 수정, 삭제 등)<br>
 - 관리자가 공지사항 작성, 사용자가 작성한 1대1 문의 답변 (답변 시 사용자 메인 화면에 알람이 생성됨)<br>

### ⏰ 개발기간 및 인원
 - 2023.02.15 - 2023.03.06 (20일)
 - 6명 (김고운, 신윤경, 이명진, 유근형, 조영민, 황은선)
<hr>

### ⚙️ 개발환경
 - java 17
 - DataBase : ORACLE
 - ORM : MyBatis, JPA
 - Framework : SpringBoot(3.0)
 - View : HTML5, CSS3, JavaScript, Thymeleaf
 - IDE : IntelliJ Ultimate 2022
<hr>

### 🌊 서비스 흐름도

<img width="800" alt="image" src="https://user-images.githubusercontent.com/97737386/229759345-d6083d7b-17ca-4515-bfa6-0e26533c5371.png">
<hr>

### 🧮 ER-Diagram

<img width="800" alt="image" src="https://user-images.githubusercontent.com/97737386/230890793-5c7aaa4e-cca8-4330-b722-37e9d71755a0.png">
<hr>

### 💻 프로젝트 담당기능 및 코드
(▶ 버튼을 누르면 내용을 펼칠 수 있습니다.)

<details>
<summary>여기를 눌러주세요</summary>
<div markdown="1">       

😎숨겨진 내용😎

</div>
</details>
1. 메인 화면 구성 (시간, 카테고리, 랭킹별 상영작 출력)
2. 검색 & 카테고리 페이지 (js파일로 모듈화)
3. 로그인, 회원가입 기능 일부 구현
4. 관리자 페이지 전담
<hr> 


프로젝트 회고 및 부족한 점
1. CS이론 및 기반지식의 부족함
Springboot를 통해 CRUD, 페이징, 정렬 등 기초적인 실습은 완료했으나 어떤 원리로 기능하는지에 대해선 이해가 부족하다. 마치 세탁기를 표준세탁으로 돌릴 줄은 알지만 그 세탁기가 어떤 원리로 움직이는지에 대해선 잘 모르는 상태와 같다.

따라서 앞으로의 학습을 통해 컴퓨터 프로그래밍이 어떤 원리로 돌아가는지, Java와 Spring이 어떤 구조로 동작하는지에 대한 이해 학습이 필요하다.

2. 코드의 근거를 꼭 기록하자
프로젝트 도중 일자별 기록은 남겼으나 구체적인 과정에서의 어려움에 대해선 시간적인 이유라는 핑계로 자세히 남기질 못했다. 이에 프로젝트 종료 후 내가 작성한 코드의 이유, 어떤 어려움을 겪었고 이를 극복하기 위해 이런 식으로 코드를 작성하였는지에 대해 정확하게 기억하지 못하는 일이 벌어졌다.

기능이 작동하면 그만이라는 마음가짐을 버리고 앞으로의 발전을 위해 스스로 작성한 코드의 근거를 기록할 필요가 있다.

3. 개발자만의 소통 방식 - 클린코드와 각주의 필요성
개발자의 소통은 단순히 대화로 이루어지는 게 아니라 다른 사람이 보더라도 쉽게 이해할 수 있는 코드와 해당 코드에 대한 설명, 즉 각주로도 이루어진다는 걸 알았다. 내가 작성한 코드가 제대로 작동한다는 걸 다른 사람에게 증명하기 위해 노력해야 한다. 코드는 나만의 것이 아니라 다른 사람과의 협업 커뮤니케이션이기도 하다.

4. 초기 설계의 중요성
프로젝트 도중에 몇 가지 변동사항이 생겨 db를 수정하는 일이 있었다. 이에 따라 레코드를 전부 다 삭제하고 처음부터 다시 만들면서 비효율적인 진행이 이뤄졌다.

프로젝트를 기획할 때 가능한 변동사항이 없도록 철저하게 설계를 해야 나중에 고생하지 않는다는 교훈을 얻었다.
<hr>

보완하고 있는 점
1. 소셜 로그인 기능 구현
카카오 로그인 api를 활용하여 유저의 정보를 json으로 불러와 카카오 nickname이랑 email, 성별을 갖고 오는 거까지 성공.
이제 이걸 가지고 로그인과 회원가입을 가능하게 해야하는데 db 수정 및 시큐리티 공부가 필요하다.
<hr>



### 📝 프로젝트 기록(조영민)

- **2/15**

  ```Spring security (login, signup) 설정 완료.```
- **2/17**

  ```maven 의존성 설정 (thymleaf, Spring web, mybatis, jpa, Spring Security, lombok, tomcat)```
  
- **2/19**

  ```DB구조 생성 및 JPA를 위한 Entity 생성, mybatis를 위한 vo, DBManager, SqlMapper.xml, SqlMapConfig.xml을 생```
- **2/21**

  ```login, singup csrf_ 사용을 위해 토큰 헤드 추가 수정, passwordEncoder 설정(비밀번호 암호화)```
- **2/23**

  ```myPage Update csrf_ 수정 작성, myPage, login, singUp -> css 적용```
  
- **2/25**

  ```kakao chatBot api connect```

- **~~**

  ```draw 기능 구현```


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

------ 23.03.06
category
-ticketid가 0인 것 출력하지않기 (QNA 해당없음 때문에 인스턴스는 필요한데 목록에 나오면 안됨) O
-콘서트 인스턴스 제목 수정 O
-톡상담 동작안함

admin/listTicket
-마지막에 내용없는 페이지 나옴 O

admin/updateTicket
-주소 검색창 안나옴 O
-이미지 옆에 main이미지 없으면 엑박으로 나옴 O
-원래 있던 이미지 다른 걸로 갈아끼우면 이미지 안나옴 -> 경로 문제 (images/ticket으로 업로드 됨)

admin/updateCustomer
-수정 누르면 404 나옴 (업뎃 안됨) -> html form의 action 경로가 이상했음 O

admin/listTicketByCustid
-티켓제목 누르면 404 O

admin/listCustomer
-삭제 누르면 자식레코드 있으면 에러페이지로 감 -> DB에서 custid를 참조하는 테이블들에 cascade 설정하면 된다.
