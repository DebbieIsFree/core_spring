package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy")     // 문자열 오류가 발생하면 컴파일 타임 오류라서 발견할 수가 없다.
@MainDiscountPolicy         // 그래서 직접 만든 애노테이션 사용, 이때 문자열 오류가 발생하면 잡을 수 있다.
@Primary    // DiscountPolicy 구현 객체로 RateDiscountPolicy에 우선권 부여
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price){
        if(member.getGrade() == Grade.VIP){
            return price * 10 / 100;
        }else{
            return 0;
        }
    }
}

