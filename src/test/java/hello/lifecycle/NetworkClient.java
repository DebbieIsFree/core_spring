package hello.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

// 빈 생명주기 콜백 방식
// 1) InitializingBean : implements InitializingBean, DisposableBean
// 2) 초기화, 소멸 메서드 지정
public class NetworkClient {

    private String url;

    // default 생성자
    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect(){
        System.out.println("connect : " + url);
    }

    // 연결이 된 상태에서 호출 가능
    public void call(String message){
        System.out.println("call : " + url + ", message : " + message);
    }

    // 서비스 종료 시 호출 (안전하게 종료)
    public void disconnect(){
        System.out.println("close : " + url);
    }


    // 1) InitializingBean, DisposableBean
    // 의존관계 주입이 끝난 뒤 호출된다.
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메세지");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }


    // 2) 초기화, 소멸 메서드 지정
    // 3) @PostConstruct, @PreDestroy
    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    // 방법 3)
    @PreDestroy
    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
