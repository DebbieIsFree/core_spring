# core #

<br>

<a href="https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8/dashboard">강의 링크 : 스프링 핵심 원리 - 기본편</a>

<br>

### Requirements ### 
<ul>
  <li>Project: Gradle-Groovy</li>
  <li>Spring Boot : 2.3.x</li>
  <li>Language: Java</li>
  <li>Package: Jar</li>
  <li>Java: 11</li>
</ul>
<br>

### Environment ###
<img src="https://github.com/DebbieIsFree/core/assets/83392219/1c39fe69-4307-4909-b4ba-24043572e270" width="60" height="40"/>

### Development ###
<img src="https://github.com/DebbieIsFree/DebbieIsFree/assets/83392219/4fc55c7f-1deb-4c52-99c1-3b961f360a00" width="60" height="40"/>
<img src="https://github.com/DebbieIsFree/DebbieIsFree/assets/83392219/a567dfe3-a522-4666-9222-488b8e8fe8b0" width="60" height="40"/> 
<img src="https://github.com/DebbieIsFree/core/assets/83392219/2c887809-ae22-4eb6-9f39-51e082932876" width="60" height="40"/>


### Project Scheme ###
<img width="562" alt="스크린샷 2023-07-28 오후 10 01 11" src="https://github.com/DebbieIsFree/core/assets/83392219/6a9e53de-ec6e-4101-9829-2e8d7946a771"><br>
<img width="562" alt="스크린샷 2023-07-28 오후 10 02 25" src="https://github.com/DebbieIsFree/core/assets/83392219/952a73f9-a3d1-4f41-9544-5407cf707d85"><br>
<img width="562" alt="스크린샷 2023-07-28 오후 10 05 14" src="https://github.com/DebbieIsFree/core/assets/83392219/0bc17c35-1490-4d7f-86f5-6778c64453ba">



<br>
<ol>
    <li>주문 생성: 클라이언트는 주문 서비스에 주문 생성을 요청한다.</li>
    <li>회원 조회: 할인을 위해서는 회원 등급이 필요하다. 그래서 주문 서비스는 회원 저장소에서 회원을 조회 한다.</li>
    <li>할인 적용: 주문 서비스는 회원 등급에 따른 할인 여부를 할인 정책에 위임한다.</li>
    <li>주문 결과 반환: 주문 서비스는 할인 결과를 포함한 주문 결과를 반환한다.</li>
</ol>
<br>

### Features ###
<ol>
  <li>회원</li>
  <ul>
    <li>회원 가입을 하고 조회할 수 있다.</li>
    <li>회원은 일반과 VIP 두 가지 등급이 있다.</li>
    <li>회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다. (미확정 > 인터페이스)</li>
  </ul>
  <br>
  <li>주문과 할인 정책</li>
   <ul>
    <li>회원은 상품을 주문할 수 있다.</li>
    <li>회원 등급에 따라 할인 정책을 적용할 수 있다.</li>
    <li>할인 정책은 모든 VIP는 1,000원을 할인해주는 고정 금액 할인을 적용한다. (추후 변경될 수 있음)</li>
    <li>할인 정책은 변경 가능성이 높다. 최악의 경우 할인을 적용하지 않을 수도 있다.</li>
  </ul>
</ol>
<br>
* 개발 당시에 결정이 안된 요구사항이 있다. 그렇다고 정책이 결정될 때까지 개발을 무기한 대기할 수 없으므로 
객체 지향 설계 방법을 사용한다. <br><br>
* 인터페이스를 만들고 구현체를 언제든지 갈아끼울 수 있도록 설계한다.

