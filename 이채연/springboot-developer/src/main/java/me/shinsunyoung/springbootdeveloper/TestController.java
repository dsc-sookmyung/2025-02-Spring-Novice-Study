package me.shinsunyoung.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Autowired
TestService testService;
@RestController
//HTTP 요청과 메서드를 연결하는 장치인 라우터

@GetMapping("/test")
public List<Member> getAllMembers() {
    List<Member> members = testService.getAllMembers();
    return members;
}
