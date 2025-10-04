package me.sogom.springbootdeveloper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

//    @Sql("/insert-members.sql")
    @Test
    /*void getMemberByName() {
        //when
        Member member = memberRepository.findByName("C").get();

        //then
        assertThat(member.getId()).isEqualTo(3);
    }*/
    /*void saveMember() {
        //given
        Member member = new Member(1L, "A");
        //when
        memberRepository.save(member);
        //then
        assertThat(memberRepository.findById(1L).get().getName()).isEqualTo("A");
    }*/
    void saveMembers() {
        //given
        List<Member> members = List.of(new Member(2L, "B"),
                new Member(3L, "C"));
        //when
        memberRepository.saveAll(members);
        //then
        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }
}