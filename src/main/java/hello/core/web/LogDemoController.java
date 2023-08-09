package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {    // MyLogger가 잘 작동하는지 확인하는 테스트용 컨트롤러

    // 에러 해결
    // 방법 1) 스코프와 Provider
    // MyLogger를 주입받는 것이 아니라, MyLogger를 찾는 Dependency Lookup
    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final LogDemoService logProviderDemoService;

    // requestURL 값 http://localhost:8080/log-demo
    @RequestMapping("log-provider-demo")      // log-demo라는 요청이 왔을 때
    @ResponseBody
    public String logDemo(HttpServletRequest request){   // 자바 표준 서블릿, 요청 정보 받기
        // Provider에서 꺼낸 뒤, 주입 (이 시점에 생성됨 -> MyLogger의 init()메서드 호출)
        MyLogger myLogger = myLoggerProvider.getObject();

        // 고객이 어떤 URL로 요청했는지 알 수 있다.
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logProviderDemoService.logic("testID");

        return "OK";
    }

}
