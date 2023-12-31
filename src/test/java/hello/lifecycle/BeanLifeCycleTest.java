package hello.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        // close() 메서드를 사용하기 위해서
        // AnnotationConfigApplicationContext 또는 ConfigurableApplicationContext로 바꿔준다.
        // ApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

        // 1) @Bean : InitializingBean, DisposableBean
        // 2) 초기화, 소멸 메서드 지정
        // @Bean(initMethod = "init", destroyMethod = "close")
        // 3) PostConstruct, PreDestroy
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
