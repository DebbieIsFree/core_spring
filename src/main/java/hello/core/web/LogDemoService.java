package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor    // 생성자 자동 주입
public class LogDemoService {       // 비즈니스 로직이 있는 서비스 계층에서 로그 출력

    // 2) 스코프와 프록시
    private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic(String id ){
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id);
    }

    // 1) 스코프와 Provider
//    private final ObjectProvider<MyLogger> myLoggerProvider;
//
//    public void logic(String id ){
//        MyLogger myLogger = myLoggerProvider.getObject();
//        myLogger.log("service id = " + id);
//    }
}
