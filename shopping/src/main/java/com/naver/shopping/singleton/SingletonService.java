package com.naver.shopping.singleton;

public class SingletonService {
    //1. static 영역에 객체 한 개만 생성
    private static final SingletonService instance = new SingletonService();
    //2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용
    public static SingletonService getInstance() {
        return instance;
    }
    //3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {

    }
    //임의로 호출 잘 되는지 확인용 함수
    public void logic() {
        System.out.println("실행 성공!");
    }
}
