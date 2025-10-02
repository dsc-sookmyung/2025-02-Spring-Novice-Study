package org.example.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //라우터 같은 역할(클라이언트 요청에 맞는 메서드 실행)
public class TestController {
   @Autowired //TestService 빈 주입
    TestService testService;

   @GetMapping("/test")
    public List<Member> getAllMembers(){
       List<Member> members=testService.getAllMembers();
       return members;
   }


}
