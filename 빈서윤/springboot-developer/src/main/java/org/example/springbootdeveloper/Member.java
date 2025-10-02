package org.example.springbootdeveloper;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Entity //엔티티로 지정(Member 객체를 JPA가 관리하는 엔티티로)
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED) //엔티티는 반드시 기본 생성자가 있어야 한다
@AllArgsConstructor


public class Member {
    @Id //Id 필드를 primary key로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //primary key 생성 방식 결정, 자동으로 설정되게 지정
    @Column(name="id",updatable = false) //데이터 베이스의 컬럼과 필드를 매칭
    private Long id; //DB테이블의 id 칼럼과 매칭

    @Column(name="name",nullable = false)
    private String name; //DB 테이블의 name 칼럼과 매칭
}
