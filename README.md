# T-Catch 통합 예매 사이트

### 📓 프로젝트 개요
인터파크 티켓, YES24 티켓 등과 같이 영화 시사회, 뮤지컬, 연극, 콘서트를 예매할 수 있는 통합 예매 사이트입니다.

상영일 기준 2주 이내의 상영작을 현재 상영작으로 정의하여 해당 상영작을 예매할 수 있습니다.

또한 매진이 된 상영작의 경우, 취소표에 한해 대기표를 신청할 수 있는 드로우(Draw) 기능이 구현되어 있습니다. 드로우는 상영 전날 신청한 인원에 한해 랜덤으로 추첨이 이루어집니다.

그 외 주요 구현 기능은 다음과 같습니다.

 * 회원가입 및 로그인, 아이디 비밀번호 찾기(인증코드 이메일, 핸드폰으로 검증).
 * 5점 만점으로 리뷰 남기기.
 * 리뷰 점수를 바탕으로 메인 화면에서 카테고리 별로 랭킹 3위까지 출력.
 * 카카오 챗봇을 통한 간단한 상담 (현재 불가능)
 * 일반적인 사항 혹은 사용자가 예매한 상영작에 대한 1대1 문의 (비밀 글 처리 가능).
 * 관리자 페이지에서 상영작, 회원 정보 관리 (입력, 수정, 삭제 등)
 * 관리자가 공지사항 작성, 사용자가 작성한 1대1 문의 답변 (답변 시 사용자 메인 화면에 알람이 생성됨)

### ⏰ 개발 기간
 * 2023.02.15 - 2023.03.06 (20일)

### 👥 멤버 구성
 * 김고운
 * 신윤경
 * 이명진
 * 유근형
 * 조영민
 * 황은선
<hr>

### ⚙️ 개발환경
 * java 17
 * DataBase : ORACLE
 * ORM : MyBatis, JPA
 * Framework : SpringBoot(3.0)
 * View : HTML5, CSS3, JavaScript, Thymeleaf
 * IDE : IntelliJ Ultimate 2022
<hr>

### 🌊 서비스 흐름도

<img width="800" alt="image" src="https://user-images.githubusercontent.com/97737386/229759345-d6083d7b-17ca-4515-bfa6-0e26533c5371.png">
<hr>

### 🧮 ER-Diagram

<img width="800" alt="image" src="https://user-images.githubusercontent.com/97737386/230890793-5c7aaa4e-cca8-4330-b722-37e9d71755a0.png">
<hr>

### 💻 프로젝트 담당 기능 및 코드
(▶ 버튼을 누르면 내용을 펼칠 수 있습니다.)

<details>
<summary>1. 장르와 시간을 기준으로 상영작 출력</summary>
<div markdown="1">

 * cateid에 따라 장르별(시사회, 뮤지컬, 연극, 콘서트)로 다르게 출력되도록 정의.
 * time 변수를 정의하여 각각 값이 0, 1, 2일 때 과거, 현재, 미래 상영작을 출력.
 * 현재 날짜를 기준으로 상영일이 현재 날짜보다 과거면 과거상영작, 현재 날짜 ~ 현재 날짜+14일이면 현재 상영작, 현재 날짜+14일보다 크면 개봉예정작으로 mapper에서 sql문 정의
~~~
<select id="findAllTicketByCategory" resultType="ticketVO">
  select * from ticket where cateid=#{cateid} and
  <if test="time==0">
    ticket_date &lt; to_char(sysdate, 'yyyy/mm/dd')
  </if>
  <if test="time==1">
    ticket_date &gt; to_char(sysdate, 'yyyy/mm/dd') and ticket_date &lt;= to_char(sysdate+14, 'yyyy/mm/dd')
  </if>
  <if test="time==2">
    ticket_date &gt; to_char(sysdate+14, 'yyyy/mm/dd')
  </if>
</select>
~~~
</div>
</details>

<details>
<summary>2. 상세 페이지 내 서버 시간 제공</summary>
<div markdown="1">

 * cateid에 따라 장르별(시사회, 뮤지컬, 연극, 콘서트)로 다르게 출력되도록 정의.

~~~
<select id="findAllTicketByCategory" resultType="ticketVO">
  select * from ticket where cateid=#{cateid} and
  <if test="time==0">
    ticket_date &lt; to_char(sysdate, 'yyyy/mm/dd')
  </if>
  <if test="time==1">
    ticket_date &gt; to_char(sysdate, 'yyyy/mm/dd') and ticket_date &lt;= to_char(sysdate+14, 'yyyy/mm/dd')
  </if>
  <if test="time==2">
    ticket_date &gt; to_char(sysdate+14, 'yyyy/mm/dd')
  </if>
</select>
~~~
</div>
</details>

<details>
<summary>3. 예매 오픈일에 맞춰 예매 버튼 활성화</summary>
<div markdown="1">

 * cateid에 따라 장르별(시사회, 뮤지컬, 연극, 콘서트)로 다르게 출력되도록 정의.

~~~
<select id="findAllTicketByCategory" resultType="ticketVO">
  select * from ticket where cateid=#{cateid} and
  <if test="time==0">
    ticket_date &lt; to_char(sysdate, 'yyyy/mm/dd')
  </if>
  <if test="time==1">
    ticket_date &gt; to_char(sysdate, 'yyyy/mm/dd') and ticket_date &lt;= to_char(sysdate+14, 'yyyy/mm/dd')
  </if>
  <if test="time==2">
    ticket_date &gt; to_char(sysdate+14, 'yyyy/mm/dd')
  </if>
</select>
~~~
</div>
</details>

<details>
<summary>4. 후기 페이지에 성별별 예매율 제공</summary>
<div markdown="1">

 * cateid에 따라 장르별(시사회, 뮤지컬, 연극, 콘서트)로 다르게 출력되도록 정의.

~~~
<select id="findAllTicketByCategory" resultType="ticketVO">
  select * from ticket where cateid=#{cateid} and
  <if test="time==0">
    ticket_date &lt; to_char(sysdate, 'yyyy/mm/dd')
  </if>
  <if test="time==1">
    ticket_date &gt; to_char(sysdate, 'yyyy/mm/dd') and ticket_date &lt;= to_char(sysdate+14, 'yyyy/mm/dd')
  </if>
  <if test="time==2">
    ticket_date &gt; to_char(sysdate+14, 'yyyy/mm/dd')
  </if>
</select>
~~~
</div>
</details>

<details>
<summary>5. 문자 인증을 통한 아이디 찾기</summary>
<div markdown="1">

 * cateid에 따라 장르별(시사회, 뮤지컬, 연극, 콘서트)로 다르게 출력되도록 정의.

~~~
<select id="findAllTicketByCategory" resultType="ticketVO">
  select * from ticket where cateid=#{cateid} and
  <if test="time==0">
    ticket_date &lt; to_char(sysdate, 'yyyy/mm/dd')
  </if>
  <if test="time==1">
    ticket_date &gt; to_char(sysdate, 'yyyy/mm/dd') and ticket_date &lt;= to_char(sysdate+14, 'yyyy/mm/dd')
  </if>
  <if test="time==2">
    ticket_date &gt; to_char(sysdate+14, 'yyyy/mm/dd')
  </if>
</select>
~~~
</div>
</details>

<details>
<summary>6. 문자 및 이메일 인증을 통한 비밀번호 재설정</summary>
<div markdown="1">

 * cateid에 따라 장르별(시사회, 뮤지컬, 연극, 콘서트)로 다르게 출력되도록 정의.

~~~
<select id="findAllTicketByCategory" resultType="ticketVO">
  select * from ticket where cateid=#{cateid} and
  <if test="time==0">
    ticket_date &lt; to_char(sysdate, 'yyyy/mm/dd')
  </if>
  <if test="time==1">
    ticket_date &gt; to_char(sysdate, 'yyyy/mm/dd') and ticket_date &lt;= to_char(sysdate+14, 'yyyy/mm/dd')
  </if>
  <if test="time==2">
    ticket_date &gt; to_char(sysdate+14, 'yyyy/mm/dd')
  </if>
</select>
~~~

</div>
</details>
<hr> 

### 주요 문제 해결 기록
상황
문제
해결

### 프로젝트 회고 및 부족한 점
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

모듈화 : 중복되는 코드를 모듈화하면 재사용성이 높아지고 유지보수가 훨씬 쉬워짐을 느꼈습니다.

상단 네비게이션 바에 로그인을 했을 시 로그아웃, 마이페이지 버튼을 출력하고 로그인을 하지 않았을 시 로그인과 회원가입 버튼을 출력하도록 만들었는데, 이를 위해 로그인 아이디를 세션에 저장하고 불러오는 자바스크립트 코드가 모든 페이지마다 필요했습니다. 처음에는 이 코드를 모든 html 페이지에 직접 입력했습니다. 그 후 한 조원이 일부 페이지에서 이 코드를 수정하면서 코드가 어떤 페이지에서는 동작하고 어떤 페이지에서는 동작하지 않는 문제가 발생했습니다. 또한 네비게이션 바에는 검색 창도 있었는데, 이 또한 이 코드를 만든 조원이 일부 수정하면서 일부 페이지에서만 작동하고 다른 페이지에서는 작동하지 않았습니다.

저의 제안으로 네비게이션 바와 로그인 코드를 따로 js 파일로 만든 후 각 html 마다 js 파일을 import 하는 방식으로 변경했습니다. 이렇게 하자 로그인 방식과 네비게이션 바 작동 방식에 통일성을 주고 수정 시 모든 html 파일을 수정하지 않고 한 js 파일만 수정하면 되어 유지보수가 훨씬 용이해졌습니다.

코드 분리 : DBManager를 테이블 별로 나누지 않고 하나의 클래스에 모든 테이블에 대한 메소드를 작성했습니다. 그 결과 한 파일이 너무 길어져 원하는 코드를 찾기 어려워지고 팀원들의 코드를 merge 할 시 충돌을 해결하기 매우 번거로웠습니다. 다음부터는 코드를 보기 쉽고 합치기 쉽게 하기 위해 기능별로 최대한 분할해 파일을 작성해야겠다고 생각했습니다.

설계의 중요성 : 협업으로 이루어지는 프로젝트인 만큼 처음에 최대한 세세하게 설계를 잘 해야 나중에 어려움 없이 수월하게 코딩을 할 수 있다는 것을 알게 되었습니다.

설계 시 변수명의 규칙은 카멜표기법으로 하고 줄임말을 쓰지 않고 명확한 변수명을 사용하기로 했습니다. 하지만 dao나 vo 처럼 자주 쓰일 변수들의 구체적인 명칭을 정하지는 않았습니다. 그 결과 CustomerDAO 객체를 생성 시 어떤 조원은 customerDao, 다른 조원은 dao라고 쓰는 문제가 발생했습니다. 다음부터는 자주 쓰는 변수명의 경우 명칭을 미리 정하는 것이 좋겠다고 생각했습니다.

DB 모델링 또한 최대한 세세하게 생각해서 해야 함을 느꼈습니다. 코딩을 하면서 DB 구조를 수정해야 하는 일이 자주 발생했습니다. 예를 들어 카카오 주소 API를 적용하기 위해서는 주소를 저장하는 칼럼이 네 개가 필요했는데, 처음 설계 시 하나로만 구성했기 때문에 네 개로 바꿔주어야 했습니다. 그러기 위해서 기존 Customer instance를 삭제해야 했는데, Customer 테이블의 자식 테이블이 많고 자식 테이블로 상속된 customer의 PK의 제약조건이 Not null로 설정되어 있어 각 테이블의 자식 레코드까지 모두 삭제해줘야 했습니다. Not null 제약조건의 경우 개발이 어느 정도 완료된 후 추가하는 것도 좋은 방법이 될 것 같다고 생각했습니다.

기반 지식의 중요성 : 기능을 다 완성하기는 했지만 내부 동작 원리를 모르는 채로 코딩한 경우도 있어 앞으로 더 많은 공부가 필요하다는 것을 느꼈습니다.

예를 들어 Spring Security를 적용 시, DB를 변경하는 작업을 하는 form에는 crsf 토큰을 포함시켜야 하는데, 프로젝트를 제 시간에 끝내는 것에 신경쓰다 보니 왜 그래야 하는지에 대한 학습을 할 시간은 부족해서 아쉬웠습니다. 앞으로 이런 부분들을 더 공부해나가고 싶습니다.


<hr>

### 보완하고 싶은 부분
1. 소셜 로그인 기능 구현
카카오 로그인 api를 활용하여 유저의 정보를 json으로 불러와 카카오 nickname이랑 email, 성별을 갖고 오는 거까지 성공.
이제 이걸 가지고 로그인과 회원가입을 가능하게 해야하는데 db 수정 및 시큐리티 공부가 필요하다.
<hr>



### 📝 프로젝트 일지
