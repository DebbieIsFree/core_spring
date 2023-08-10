package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
// 1) 스코프와 Provider
//@Scope(value = "request")   // HTTP 요청당 하나씩 빈 생성, HTTP 요청이 끝나는 시점에 소멸
// 2) 스코프와 프록시, 가짜 proxy 객체(CGLIB) 생성, 등록, 주입
// Provider, Proxy : 요청이 있을 때까지 진짜 객체 조회 지연
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {     // 로그 출력 클래스

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    // 요청이 들어왔을 때 (생성 시점)
    @PostConstruct
    public void init(){
        // generate globally unique id
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create: " + this);
    }

    // request scope는 종료 메서드가 호출된다. (소멸 시점)
    @PreDestroy
    public void close(){
        System.out.println("[" + uuid + "] request scope bean close : " + this);
    }
}
