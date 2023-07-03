package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// AppConfig
// 애플리케이션의 실제 동작에 필요한 '구현 객체'를 생성한다.
// 생성한 객체 인스턴스의 참조(레퍼런스)를 '생성자'를 통해서 주입(연결)한다.
// 관심사의 분리 : 역할과 실행 분리

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());   // 생성자를 통해 생성한 객체 주입
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());  // 생성자 주입
    }
}
