package org.example.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    MemberRepository memberRepository; //빈 주입

    public List<Member> getAllMembers(){
        return memberRepository.findAll(); //멤버 목록 얻기
    }
    //1.MemberReopositry 라는 빈을 주입을 받은 후
    //2.findAll() 매소드를 호출 해 멤버 테이블에 저장된 멤버 목록을 모두 가져움

}
