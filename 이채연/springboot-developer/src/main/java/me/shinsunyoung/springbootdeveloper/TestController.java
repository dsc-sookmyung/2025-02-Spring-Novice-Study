package me.shinsunyoung.springbootdeveloper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//HTTP 요청과 메서드를 연결하는 장치인 라우터

public class TestController {
    @GetMapping("/test")
    public String test() { ///test GET 요청이 오면 test() 메서드 실행
        return "Hello, World!";
    }
}
