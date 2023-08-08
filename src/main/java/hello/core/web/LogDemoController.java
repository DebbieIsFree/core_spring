package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {    // MyLogger가 잘 작동하는지 확인하는 테스트용 컨트롤러

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")      // log-demo라는 요청이 왔을 때
    @ResponseBody
    public String logDemo(HttpServletRequest request){   // 자바 표준 서블릿, 요청 정보 받기
        // 고객이 어떤 URL로 요청했는지 알 수 있다.
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testID");

        return "OK";
    }

}
