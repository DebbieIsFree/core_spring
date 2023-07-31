package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    // AppConfig를 통해, OrderServiceImpl은 FixDiscountPolicy에 의존하지 않는다.

    // final : 한번 값을 할당하면 수정할 수 없다. 초기화는 한 번만 가능
    // 선언만 하고 초기화는 각 객체 인스턴스에서 진행
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    // 구체에 의존하지 않고, 인터페이스(추상)에만 의존 (DIP 잘 지킴)

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}

