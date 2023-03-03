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
- **2/15**
개발툴 기본설정 완료.

- **2/17**

1.Spring으로 기존 환경설정 및 maven 의존성 설정 (thymleaf, Spring web, mybatis, jpa, Spring Security, lombok, tomcat)

2.DB구조 생성 및 JPA를 위한 Entity 생성, mybatis를 위한 vo, DBManager, SqlMapper.xml, SqlMapConfig.xml을 생성해줌.

-도중 발생한 오류: 

1.Eclipse에서 java 파일 안 db폴더를 만들어 xml파일을 넣어 파일을 읽어오게 하는것과 다르게 intelij에서는 main resources 폴더에 xml파일을 넣어줘야 xml파일을 읽어오며 처리가 가능하게된다. 

2.JPA와 mybatis를 같이 사용하기위해 변수명을 바꾸어서 생성해줬는데 이러면 JPA를 정상적으로 작동할 수 없어 DB의 column명과 똑같이 변수명을 수정함.

**2/21** 

1.Spring Security Login 연결 도중 FilterChain에 대해 공부. 

2.Login을 Spring Security 내부에서 하기 때문에 PostMapping을 사용하지 않는다 html에서 input의 name을 Security에 맞게 수정하여 Login 구현, 이 때 csrf보안을 위해 토큰 전송

3.passwordEncoder를 이용해 사용자의 비밀번호 암호화

4.login 성공 후 default 페이지를 정해줌. 하지만 테스트 해본 결과 default 페이지를 지정해도 그전에 방문한 페이지로 redirect 되는 일이 발생함. 구글링으로 찾아본 결과 `.defaultSuccessUrl("/service1",true);`

뒤에 true를 붙여주면 전에 방문한 기록과 상관없이 바로 원하는 경로로 redirect 가능하다.

**2/22**

1.수정된 DB에 맞게 Entity, vo 수정

**2/23**

1.html에 js, css적용

-오류: security로 생성하고 적용하니 권한문제로 정적 자원에 대한 접근이 불허되었음.

securityconfig 내에서 

`.requestMatchers("static/css/**","/images/**","/image/**").permitAll()`

코드를 사용하여 권한 설정으로 해결하였음.

1. login, signUp page css 적용완료.

**2/24**

초기페이지 설정

시작 경로를 main.html 지정하여 서버 최초 실행시 접속페이지를 지정.

```
@GetMapping("/")
public String main() {
    return "main";
}
```

2/26

Spring security signUp

-발생오류: signUp에서 JS를 통해 데이터를 전송하는 과정에서 무반응 상태의 에러가 발생. form 태그 안에서만 csrf토큰을 생성해서 전달하는것은 의미가없고 html header에 csrf token, header 내용을 넣어줌

```
<meta name="_csrf" th:content="${_csrf.token}"/>
<meta name="_csrf_header" th:content="${_csrf.headerName}"/>
```

다음으로 ajax통신시 csrf token, header 데이터를 전송하기 위해 

```
$.ajax({
                    url,
                    type:"POST",
                    data:data,
                    beforeSend : function(xhr)
                    {   /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
                        xhr.setRequestHeader(header, token);
                    },
                    success:function(){
                        $("#btn_update").click(function(){
                            $(location).attr("href","/myPage");
                            alert("회원 정보가 성공적으로 수정되었습니다.");
                        });
                    }
                });
```

위와 같이 ajax 통신전에 csrf token, header를 먼저 전송하여 암호화를 진행하게 하여 오류 해결.

myPage.html 에서 회원정보를 수정하기 위해 필요한 전화번호 중복확인 버튼 추가.

-발생한 오류 : 전화번호 중복확인시 button을 클릭할때 submit으로 인식되는 오류 확인 

html의 form 태그안에 button의 타입을 지정하지 않으면 submit으로 인식되어 button 태그의 타입을 type = “button”으로 설정하여 에러 해결

**2/28**

1.kakao chatbot 연결

2.인증번호 메세지 전송 api 연결 및 인증번호 확인 메소드 작성.

3.라디오 버튼 checked 속성 주입

- ** 라디오 버튼 thymeleaf로 기본값 설정하기

```
th:attr="checked=${customer.gender == '값' ? 'true' : 'false'}"
```

'값' 이면 check가 true, '값'이 아니면 'false' 처리되어 라디오버튼에 체크 설정할 수 있음

**3/1 ~ 3/2**

draw 기능 구현

```jsx
drawList   //드로우 신청 회원 정보
leftSeat.  //드로우 전 예매가 끝난 공연에 남은 좌석 정보를 count
drawExec.  //드로우 가동

```

총 3개의 메소드로 나누어 기능 구현 각자의 기능만을 수행할 수 있도록 나누어 줬음

가장 깊게 고민했던 부분을 드로우 자료구조에 대해서 어떻게 구조를 작성해야할지 생각해본 결과 

신청한 회원정보만큼 랜덤 함수의 범위를 설정하고 회원정보를 linkedList로 받아 추가, 삭제를 용이하게 구성하였다. 반복문을 통하여 남은 좌석만큼 반복을 수행하고 한번 수행할 때 마다 당첨된 회원 정보가 있는 linkedList의 정보를 배열에 저장하고 삭제하여 다음 반복문 실행시 동일한 랜덤 번호가 나와도 다른 회원이 뽑힐 수 있도록 설정하였다.
