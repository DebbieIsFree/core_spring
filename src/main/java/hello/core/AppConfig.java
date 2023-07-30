package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// AppConfig
// 애플리케이션의 실제 동작에 필요한 '구현 객체'를 생성한다.
// 생성한 객체 인스턴스의 참조(레퍼런스)를 '생성자'를 통해서 주입(연결)한다.
// 관심사의 분리 : 역할과 실행 분리

@Configuration
public class AppConfig {

    // @Bean memberService -> 결과적으로는 new MemoryMemberRepository() 호출
    // @Bean orderService -> new MemoryMemberRepository() 호출
    // 위 두 예시에서만 MemoryMemberRepository()가 2번 호출될 것으로 예상
    // But, 결과적으로는 1번 호출, 즉 동일 객체 인스턴스 (싱글톤 보장)

    @Bean
    public MemberService memberService(){    // 메서드명, 리턴타입을 보면 역할이 드러난다.
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
