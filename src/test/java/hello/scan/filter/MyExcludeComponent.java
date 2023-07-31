package hello.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)   // TYPE : 클래스 레벨
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
    // 컴포넌트 스캔에서 제외할 것
}
