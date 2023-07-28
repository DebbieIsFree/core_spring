package hello.singleton;

public class SingletonService {
    // static : class level에 올라가서 딱 1개만 존재하게 된다.
    // 내부적으로 실행해서 객체를 생성한 다음에 instance에 참조를 넣어놓는다.
    private static final SingletonService instance = new SingletonService();

    // instance에 있는 참조를 꺼내는 유일한 방법 : getInstance()
    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }

    public void login() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}

