package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;  // 인터페이스(추상화)만 존재, DIP 준수

    // 생성자를 통해서 memberRepository에 들어갈 구현체(객체) 선택  : 생성자 주입
    // DI (Dependency Injection) 의존 관계 주입, 의존성 주입

    @Autowired  // 의존관계 자동 주입, ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 싱글톤 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
