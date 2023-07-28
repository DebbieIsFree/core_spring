package hello.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatelessServiceTest {
    @Test
    void statefulServiceSingleton(){ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatelessService statelessService1 = ac.getBean(StatelessService.class);
        StatelessService statelessService2 = ac.getBean(StatelessService.class);

        // ThreadA : A 사용자가 10,000원 주문
        int userAPrice = statelessService1.order("userA", 10000);
        // ThreadB : B 사용자가 20,000원 주문
        int userBPrice = statelessService2.order("userB", 20000);

        // ThreadA : 사용자 A가 주문 금액 조회
        System.out.println("price = " + userAPrice);
    }

    static class TestConfig {
        @Bean
        public StatelessService statefulService(){
            return new StatelessService();
        }
    }
}