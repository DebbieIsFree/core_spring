package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// 설정 정보 : Configuration
@Configuration
@ComponentScan(
        // hello.core부터 찾아 들어간다.
        basePackages = "hello.core",

        // AutoAppConfig가 있는 hello.core 패키지부터 시작한다.
        basePackageClasses = AutoAppConfig.class,

        // 자동으로 스프링 빈으로 등록할 때 제외할 것을 선정
        // @ComponentScan을 사용하면 @Component가 붙은 설정 정보도 자동으로 등록된다. (ex. AppConfig 파일)
        // @Configuration 어노테이션이 붙은 것은 제외
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    // 기존의 AppConfig와 다르게 @Bean으로 등록한 클래스가 하나도 없다.
}


