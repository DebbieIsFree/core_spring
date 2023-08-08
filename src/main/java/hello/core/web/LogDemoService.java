package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor    // 생성자 자동 주입
public class LogDemoService {       // 비즈니스 로직이 있는 서비스 계층에서 로그 출력

    private final MyLogger myLogger;

    public void logic(String id ){
        myLogger.log("service id = " + id);
    }
}
