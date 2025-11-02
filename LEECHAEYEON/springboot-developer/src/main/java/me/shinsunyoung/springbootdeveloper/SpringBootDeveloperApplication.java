package me.shinsunyoung.springbootdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //created_at, updated_at 자동 업데이트
//스프링부트가 시작되는 곳
@SpringBootApplication //애너테이션을 추가하면 스프링 부트 사용에 필요한 기본 설정을 해 줌
public class SpringBootDeveloperApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDeveloperApplication.class, args); //애플리케이션 실행
        //첫 번째 인수는 스프링부트3 애플리케이션의 메인 클래스로 사용할 클래스, 두번째 인수는 커맨드 라인의 인수들을 전달
    }
}