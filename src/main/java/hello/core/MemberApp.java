package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // 모든 객체 관리 (컨테이너)
        // AppConfig에 있는 환경 설정 정보를 가지고 스프링이 객체 생성한 것을 넣어 관리함
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2번째는 type
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("memberA = " + memberA.getName());
        System.out.println("findeMember = " + findMember.getName());
        System.out.println();
    }
}
