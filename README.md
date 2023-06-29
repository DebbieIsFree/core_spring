# core #

### 개발 기간 ###
2023.06.28 ~ 

### Requirements ### 
<ul>
  <li>Project: Gradle-Groovy</li>
  <li>Spring Boot : 2.3.x</li>
  <li>Language: Java</li>
  <li>Package: Jar</li>
  <li>Java: 11</li>
</ul>
<br>
* 참고) 프로젝트 환경설정을 편리하게 하려고 스프링 부트를 사용하는 것이다. 이번 프로젝트에서는 스프링 없이
순수하게 자바로만 개발을 진행한다. (이후 다른 프로젝트에서 스프링을 사용해 다시 개발)

### Environment ###
<img src="https://github.com/DebbieIsFree/core/assets/83392219/f5d87422-293f-4147-ba8d-f1357c5cfd11" width="60" height="40"/>

### Development ###
<img src="https://github.com/DebbieIsFree/DebbieIsFree/assets/83392219/4fc55c7f-1deb-4c52-99c1-3b961f360a00" width="60" height="40"/>
<img src="https://github.com/DebbieIsFree/DebbieIsFree/assets/83392219/a567dfe3-a522-4666-9222-488b8e8fe8b0" width="60" height="40"/>

### Project Scheme ###
<img width="654" alt="스크린샷 2023-06-28 오후 8 09 46" src="https://github.com/DebbieIsFree/core/assets/83392219/eff204e0-f622-402b-9ed4-9b4d777f80f5"><br><br>

<img width="650" alt="스크린샷 2023-06-29 오전 10 48 14" src="https://github.com/DebbieIsFree/core/assets/83392219/32317c51-d1bd-48b5-bb85-f9d79c23eae2">
<img width="650" alt="스크린샷 2023-06-29 오전 10 46 32" src="https://github.com/DebbieIsFree/core/assets/83392219/f20242c7-96be-45d6-babe-1136e294cbee">
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

