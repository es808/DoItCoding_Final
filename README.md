# T-Catch 예매 사이트
<hr>

### 목차
[1. 프로젝트 개요](#-프로젝트-개요) </br>
[2. 개발 기간 및 멤버 구성](#-개발-기간) </br>
[3. 개발환경](#개발환경) </br>
[4. 서비스 흐름도](#-서비스-흐름도) </br>
[5. ER-Diagram](#-ER-Diagram) </br>
[6. 프로젝트 담당 기능 및 코드](#-프로젝트-담당-기능-및-코드) </br>
[7. 주요 문제 해결 기록](#-주요-문제-해결-기록) </br>
[8. 추후 보완이 필요한 부분](#-추후-보완이-필요한-부분) </br>
[9. 프로젝트에 대한 전반적인 회고](#프로젝트에-대한-전반적인-회고) </br>
[10. 프로젝트 일지](#프로젝트-일지) </br>
<hr>

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

### 👥 멤버 구성 (6명, 가나다순)
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

<img width="700" alt="image" src="https://user-images.githubusercontent.com/97737386/229759345-d6083d7b-17ca-4515-bfa6-0e26533c5371.png">
<hr>

### 🧮 ER-Diagram

<img width="700" alt="image" src="https://user-images.githubusercontent.com/97737386/230890793-5c7aaa4e-cca8-4330-b722-37e9d71755a0.png">
<hr>

### 💻 프로젝트 담당 기능 및 코드
(▶ 버튼을 누르면 내용을 펼칠 수 있습니다.)

<details>
<summary>1. 장르와 시간을 기준으로 상영작 출력</summary>

[📌 코드확인](https://github.com/es808/DoItCoding_Final/blob/148104ceca84f9f12b29643793347f207aba92d2/src/main/resources/templates/ticket/category.html#L38)

![장르와 시간을 기준으로 상영작 출력](https://github.com/es808/test01/assets/116155163/e0a16c2c-8a92-4619-a0ab-39239a89cfd5)

 * cateid에 따라 장르별(시사회, 뮤지컬, 연극, 콘서트)로 다르게 출력되도록 정의
 * time 변수를 정의하여 각각 값이 0, 1, 2일 때 과거, 현재, 미래 상영작을 출력
 * 현재 날짜를 기준으로 mapper에서 조건문을 활용하여 sql문 정의
   * 상영일이 현재 날짜보다 과거면 과거상영작
   * 현재 날짜 ~ 현재 날짜+14일 이면 현재 상영작
   * 현재 날짜+14일 보다 크면 개봉예정작

~~~
<!-- main.html에서 카테고리, 시간 별로 상영작 출력하는 mapper sql 코드 -->
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
</details>

<details>
<summary>2. 상세 페이지 내 서버 시간 제공</summary>
<div markdown="1">

[📌 코드확인](https://github.com/es808/DoItCoding_Final/blob/148104ceca84f9f12b29643793347f207aba92d2/src/main/resources/templates/ticket/detail.html#L296)  

![상세-페이지-내-서버-시간-제공](https://github.com/es808/test01/assets/116155163/88c619c0-3c41-45c0-bb92-1046c9671bef)

 * JavaScript의 setInterval() 함수를 이용
 * 사용자 편의성 증진을 위하여 상세 페이지 내 예매 버튼 하단에 서버 시간을 제공
</div>
</details>

<details>
<summary>3. 예매 오픈일에 맞춰 예매 버튼 활성화</summary>
<div markdown="1">

[📌 코드확인](https://github.com/es808/DoItCoding_Final/blob/e1bf35ef3ad310eac2373fd15e6fd65cec10c52b/src/main/resources/templates/ticket/detail.html#L205)

![예매 오픈일에 맞춰 예매 버튼 활성화](https://github.com/es808/test01/assets/116155163/56304534-a742-4597-a03a-0477efc00365)

 * 개봉일 기준으로 일주일 전인 예매 오픈 일정에 맞춰 예매 버튼 활성화
 * CSS 속성을 활용하여 예매 버튼 활성화
</div>
</details>

<details>
<summary>4. 후기 페이지에 성별별 예매율 제공</summary>
<div markdown="1">

[📌 코드확인](https://github.com/es808/DoItCoding_Final/blob/148104ceca84f9f12b29643793347f207aba92d2/src/main/resources/templates/ticket/detail.html#L307)  

![성별 통계](https://github.com/es808/test01/assets/116155163/4fd0c297-26e6-461a-8e01-3f4b86eed07e)

 * 상품 실구매자의 성별을 분석하여 후기 페이지에 성별별 예매율을 제공
 * mapper에서 집계함수 중 count()함수를 활용하여 sql문 정의

~~~
<!-- 성별통계 -->
<select id="countGender" resultType="countGenderVO">
  select gender,count(*) cnt from customer c, book b where c.custid = b.custid and b.ticketid=#{ticketid} group by gender
</select>
~~~
</div>
</details>

<details>
<summary>5. 문자 인증을 통한 아이디 찾기</summary>
<div markdown="1">

[📌 코드확인](https://github.com/es808/DoItCoding_Final/blob/148104ceca84f9f12b29643793347f207aba92d2/src/main/resources/templates/customer/findCustid.html#L17)  

![문자 인증을 통한 아이디 찾기](https://github.com/es808/test01/assets/116155163/e75f202b-41a5-43fc-ad92-0aa5957d069c)

 * 회원가입 시 등록한 이름과 전화번호를 가지고 아이디 찾기
 * 개인정보가 일치하는 경우 문자로 인증코드를 전송받아 아이디를 찾을 수 있음

~~~
<!-- findCustid 아이디 찾기 -->
<select id="findCustid" resultType="customerVO">
  select custid from customer where name=#{name} and phone=#{phone}
</select>
~~~
</div>
</details>

<details>
<summary>6. 문자 및 이메일 인증을 통한 비밀번호 재설정</summary>
<div markdown="1">

[📌 코드확인](https://github.com/es808/DoItCoding_Final/blob/148104ceca84f9f12b29643793347f207aba92d2/src/main/resources/templates/customer/findPwd.html#L20) 

 * 6-1) 전화번호 인증을 통한 비밀전호 재설정
![문자 인증을 통한 비밀번호 재설정](https://github.com/es808/test01/assets/116155163/b64c0736-93c9-4f07-b9e8-dae650c6005c)

~~~
<!-- 전화번호로 비밀번호 재설정 -->
<update id="updatePwdbyPhone" parameterType="customerVO">
  update customer set pwd=#{pwd} where custid=#{custid} and phone=#{phone}
</update>
~~~

 * 6-2) 이메일 인증을 통한 비밀전호 재설정
![이메일 인증을 통한 비밀전호 재설정](https://github.com/es808/test01/assets/116155163/6ab12a8c-f563-435e-a3cb-dc4d228019c9)

~~~
<!-- 이메일로 비밀번호 재설정 -->
<update id="updatePwdbyEmail" parameterType="customerVO">
  update customer set pwd=#{pwd} where custid=#{custid} and email=#{email}
</update>
~~~
</div>
</details>
<hr> 

### 🛠 주요 문제 해결 기록
<details>
<summary>1. 구글 SMTP 버전 이슈</summary>
<div markdown="1">
  
 * 상황: 비밀번호 재설정과 예매 및 드로우 내역 안내를 위해 구글 SMTP를 활용하여 메일을 보내는 기능을 구현해야 했습니다.
 * 문제: 교육 과정 중 진행했던 실습과 환경 및 버전이 달라져 이메일 발송이 안 되는 문제가 발생하였습니다.
 * 해결: 우선 구글링을 하며 버전을 바꾸어 실험해보고, SMTP 관련 인증도 다시 받아보았습니다. 그 과정에서 오류 메시지를 확인하니 emailSender 부분에서 오류가 발생하는 것을 알게 되었습니다. 'spring-boot-starter-mail'이라는 dependency를 추가하여 해결하였습니다.
 
[📌 코드확인](https://github.com/es808/DoItCoding_Final/blob/684bb49967ce8ac3a8a5cad68e79427074660a6e/pom.)
</div>
</details>


<hr> 

### ➕ 추후 보완이 필요한 부분
<details>
<summary>1. AWS를 통한 웹사이트 배포</summary>
<div markdown="1">
  
 * 상황: 시간과 기술적 한계로 최종 목표였던 AWS를 통한 웹사이트 배포는 하지 못했습니다.
 * 문제: 웹사이트가 배포되어야 사용할 수 있는 카카오 챗봇 서비스를 제대로 활용할 수 없습니다.
 * 보완: 기능의 완성도를 더 높인 후, JUnit을 활용한 단위 테스트를 통해 서비스에 대한 검증이 제대로 이뤄진 이후 웹사이트 배포까지 해보고 싶습니다.
</div>
</details>

<details>
<summary>2. 드로우 알고리즘 변경</summary>
<div markdown="1">
  
 * 상황: 현재의 드로우 알고리즘은 신청자에 한하여 무작위 랜덤 추첨 방식입니다.
 * 문제: 현재 방식의 경우, 무작위 랜덤 추첨이기 때문에 사이트 이용 빈도가 높은 회원과 처음 사이트를 이용한 회원 모두 동일한 확률로 드로우 서비스를 이용할 수 있습니다. 공평한 방식이라고 생각했지만, 웹사이트에 대한 회원들의 충성도를 높이는 데에는 도움이 되지 않습니다.
 * 보완: 사이트 이용 빈도와 회원의 선호에 가중치를 두어 추첨할 수 있는 알고리즘으로 변경하면 좋을 것 같습니다.
</div>
</details>

<details>
<summary>3. 시간 관련 데이터 관리</summary>
<div markdown="1">
  
 * 상황: 예매 사이트이다 보니 시간과 관련된 데이터를 다루는 기능들이 많이 있습니다. 예를 들어 현재 시간을 기준으로 현재/과거/미래 상영작들로 구분하고, 예매 오픈일에 맞추어 예매 버튼을 활성화하거나 비활성화했습니다. 또 사용 편의성을 위해 상세 페이지 내 서버 시간을 제공하기도 하였습니다.
 * 문제: 시간 관련 데이터 형식들이 varchar2 또는 date로 통일되어 있지 않습니다. 또한 기능들이 조건문 또는 조인이 들어간 복잡한 sql 쿼리문이나 CSS를 통해 구현되어 있습니다.
 * 보완: 형 변환에 대한 공부를 더 한 후, 시간 관련 데이터의 형식을 하나로 통일하여 관리하면 좋을 것 같습니다. 또한 필요한 시간 데이터를 한번에 볼 수 있는 view를 만들어 기능을 구현했다면 좀 더 수월하게 코드를 짤 수 있을 것 같습니다.
</div>
</details>

<details>
<summary>4. 웹 크롤링을 통한 후기 제공</summary>
<div markdown="1">
  
 * 상황: 별점 및 후기 기능의 신뢰성을 높이기 위해 예매 내역이 있는 회원에 한하여 후기를 작성할 수 있습니다. 
 * 문제: 예매 내역이 없는 현재 상영작과 개봉 예정작의 경우, 별점과 후기 기능을 제공할 수 없습니다. 따라서 메인 페이지에 노출되는 장르별 랭킹에 과거 상영작들만 출력됩니다. 
 * 보완: 파이썬을 활용해 후기를 제공하는 웹 사이트를 크롤링하여 현재 상영작과 상영 예정작의 기대 별점 및 예상 키워드 등을 제공하고 싶습니다.
</div>
</details>
<hr>

### 프로젝트에 대한 전반적인 회고
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
  <summary> 📝 프로젝트 일지 </summary>
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
