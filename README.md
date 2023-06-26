# T-Catch 예매 사이트

### 📓 프로젝트 개요
인터파크 티켓, YES24 티켓 등과 같이 영화 시사회, 뮤지컬, 연극, 콘서트를 예매할 수 있는 사이트입니다.

기존의 예매 사이트를 비교 및 분석하여 각 사이트 별 장점을 벤치마킹함과 동시에 사용 편의성을 증진시키기 위한 기능을 추가하였습니다.

대표적인 기능으로는 매진된 상영작의 경우, 취소표에 한해 대기표를 신청할 수 있는 드로우(Draw) 기능을 구현하였습니다. 드로우는 상영 전날 신청한 인원에 한해 랜덤으로 추첨이 이루어집니다.

또한 현재 상영작은 상영일 기준 2주 이내의 상영작을 의미하며 해당 기간동안 예매할 수 있습니다.

그 외 주요 구현 기능은 다음과 같습니다.

 * 회원가입 및 로그인, 아이디 찾기 및 비밀번호 재설정 (휴대번호와 이메일로 인증코드 검증)
 * 로그인 시 선호에 따른 맞춤형 메인 페이지 제공
 * 성별별, 세대별 예매율 통계 제공
 * 실예매자에 한하여 5점 만점으로 후기 작성 가능
 * 후기 별점을 바탕으로 메인 페이지에서 장르별 랭킹 3위까지 출력
 * 카카오 챗봇을 통한 간단한 상담 (현재 상담은 불가능)
 * 일반적인 사항 혹은 사용자가 예매한 상영작에 대한 1대1 문의 (비밀글 처리 가능)
 * 관리자 페이지에서 상영작, 회원 정보 관리 (입력, 수정, 삭제 등)
 * 관리자가 공지사항 작성, 사용자가 작성한 1대1 문의 답변 (답변 시 사용자 메인 페이지에 알람 생성)

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

~~~
</div>
</details>

<details>
<summary>3. 예매 오픈일에 맞춰 예매 버튼 활성화</summary>
<div markdown="1">

 * cateid에 따라 장르별(시사회, 뮤지컬, 연극, 콘서트)로 다르게 출력되도록 정의.

~~~

~~~
</div>
</details>

<details>
<summary>4. 후기 페이지에 성별별 예매율 제공</summary>
<div markdown="1">

 * cateid에 따라 장르별(시사회, 뮤지컬, 연극, 콘서트)로 다르게 출력되도록 정의.

~~~

~~~
</div>
</details>

<details>
<summary>5. 문자 인증을 통한 아이디 찾기</summary>
<div markdown="1">

 * cateid에 따라 장르별(시사회, 뮤지컬, 연극, 콘서트)로 다르게 출력되도록 정의.

~~~

~~~
</div>
</details>

<details>
<summary>6. 문자 및 이메일 인증을 통한 비밀번호 재설정</summary>
<div markdown="1">

 * cateid에 따라 장르별(시사회, 뮤지컬, 연극, 콘서트)로 다르게 출력되도록 정의.

~~~

~~~

</div>
</details>
<hr> 

### 주요 문제 해결 기록
상황
문제
해결
<hr> 

### 추후 보완이 필요한 부분
#### 1. JUnit 테스트 진행 및 AWS를 통한 배포
프로젝트를 시작하며 JUnit 단위 테스트를 진행하기 위해 환경설정을 하고, 최종적으로 AWS를 통한 웹 배포까지 계획했습니다. 하지만 프로젝트를 진행하다보니 우선순위에서 밀려 결과적으로 웹 배포는 하지 못했습니다. 그래서 현재 카카오 챗봇 기능도 제대로 활용할 수 없습니다. 추후 기능들을 보완하고, 단위 테스트를 통해 서비스에 대한 검증이 이뤄진 이후 웹 배포까지 해보고 싶습니다.

#### 2. 시간 관련 데이터 테이블 정규화
예매 사이트이다 보니 시간과 관련된 데이터를 다루는 기능들이 많았습니다.

예를 들어 현재 시간을 기준으로 현재/과거/미래 상영작들로 구분하고, 예매 오픈일에 맞추어 예매 버튼을 활성화하거나 비활성화했습니다. 또 사용 편의성을 위해 상세 페이지 내 서버 시간을 제공하기도 하였습니다.

현재 이 기능들은 조건문 또는 조인이 들어간 복잡한 sql 쿼리문이나 CSS를 통해 구현되었으나, 필요한 시간 데이터를 한번에 볼 수 있는 view를 만들어 기능을 구현했다면 좀 더 수월하게 코드를 짤 수 있지 않았을까 라는 생각을 했습니다.
<hr>

### 프로젝트에 대한 전반적 회고
#### 1. CS 이론 및 기반 지식의 중요성
Springboot를 활용한 CRUD, 페이징, 정렬 등 기초적인 실습은 완료하였으나, Java와 Spring의 내부 동작 원리에 대한 이해가 부족합니다.

예를 들어 Spring Security 적용 시, DB를 변경하는 작업을 하는 form에는 crsf 토큰을 포함시켜야 하는데, 기한 내에 프로젝트를 완성하는 것에 집중하다 보니 왜 그래야 하는지에 대해 학습할 시간이 부족해 아쉬웠습니다.

따라서 앞으로의 학습을 통해 컴퓨터 프로그래밍이 어떤 원리로 돌아가는지, Java와 Spring이 어떤 구조로 동작하는지에 대해 학습할 예정입니다.

#### 2. 설계의 중요성
협업으로 이루어지는 만큼 처음에 최대한 상세하게 설계를 잘 해야 프로젝트를 수월하게 진행할 수 있다는 것을 알게 되었습니다.

먼저 DB 모델링을 세세하게 해야 함을 깨달았습니다. 프로젝트 도중에 몇 가지 변동사항이 생겨 DB를 수정하는 일이 발생하였고, 이에 따라 레코드를 전부 다 삭제하고 처음부터 다시 만들면서 시간 활용에 있어 비효율이 발생하였습니다.

또한 변수명 규칙은 카멜 표기법으로 하고 최대한 줄임말을 쓰지 않기로 정하고 시작했습니다. 하지만 dao나 vo처럼 자주 쓰일 변수들의 명칭에 대한 구체적인 규칙은 정하지는 않았습니다. 그 결과 CustomerDAO 객체를 생성 시 어떤 조원은 customerDao, 다른 조원은 dao라고 쓰는 문제가 발생했습니다. 다음부터는 자주 쓰는 변수명의 경우 명칭을 미리 정하는 것이 좋겠다고 생각했습니다.

#### 3. 코드 분리의 필요성
DBManager를 테이블 별로 분리하지 않고 하나의 클래스에 모든 테이블에 대한 메소드를 작성했습니다. 그 결과 코드가 너무 길어져 필요한 코드를 바로 찾기 어려워지고 팀원들의 코드를 merge할 시 충돌을 해결하기가 매우 번거로웠습니다. 다음부터는 코드의 가독성을 높이기 위해 기능별로 분할해 파일을 작성해야겠다고 생각했습니다.


#### 4. 개발자 간의 소통 방식 - 클린코드와 각주의 필요성
개발자 간의 소통은 단순히 대화로 이루어지는 것이 아니라 다른 사람이 보더라도 쉽게 이해할 수 있는 코드와 해당 코드에 대한 설명, 즉 각주로 이루어진다는 것을 깨달았습니다. 따라서 누가 보더라도 어떤 기능을 하는지 유추할 수 있도록 기능 제목과 변수명을 붙이고, 필요한 경우 자세하게 각주를 달아두는 습관을 가질 수 있게 노력하겠습니다.

#### 5. 코드의 근거에 대한 기록
시간에 쫓겨 프로젝트를 진행하다보니 코드를 작성하며 겪은 어려움과 해결 과정에 대한 구체적인 기록을 남기지 못했습니다. 그래서 프로젝트 종료 후 코드를 왜 그렇게 작성했는지, 이 코드를 작성하며 어떤 어려움이 있었고 이를 해결하기 위해 어떤 노력을 했는지에 대한 기억이 흐릿합니다. 앞으로의 발전을 위해 기능이 작동하면 그만이라는 마음가짐을 버리고 스스로 작성한 코드의 근거를 기록하는 습관을 가질 수 있게 노력하겠습니다.
<hr>


<details>
  <div> ### 📝 프로젝트 일지 </div>
  <div markdown="1">
    
   * 2/15 - 2/20
     * 담당한 테이블의 VO, ENTITY, DAO, SERVICE, MAPPER 작성
       * 카테고리, 시간 별로 Ticket을 출력하는 경우 쿼리문이 복잡하기 때문에 JPA가 아니라 myBatis로 작성
  
   * 2/21 - 2/26
     * JavaScript의 setInterval() 함수를 이용하여 상세 페이지 내 예매 버튼 하단에 서버 시간 제공
     * 성별별 예매율 제공
       * 집계함수 중 count()함수를 활용한 SQL 쿼리문 활용
       * 데이터가 없는 경우 CSS가 적용이 안되는 문제가 있었는데 프론트엔드 담당 팀원과 협업하여 수정
   
   * 2/27 - 3/1
     * 문자 인증을 통한 아이디 찾기
       * CSS를 활용하여 아이디 찾기에 필요한 정보 입력 제어
     * 문자 인증을 통한 비밀번호 재설정
       * CSS를 활용하여 비밀번호 재설정에 필요한 정보 입력 제어
         
   * 3/2 - 3/6
     * 이메일 인증을 통한 비밀번호 재설정
       * CSS를 활용하여 비밀번호 재설정에 필요한 정보 입력 제어
       * 버전 이슈로 인한 문제 발생
         * 구글링과 강사님의 도움으로 문제 해결
  </div>
</details> 
