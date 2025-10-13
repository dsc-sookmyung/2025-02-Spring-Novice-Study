package org.example.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter //모든 필드에 대한 접근 메서드(get 메서드 자동 생성)
@NoArgsConstructor(access = AccessLevel.PROTECTED) //접근제어자가 protected인 기본 생성자 생성

public class Article {
    @Id //id 필드를 primary key로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키를 자동으로 1씩 증가
    @Column(name="id",updatable = false)
    private Long id;


    @Column(name="title",nullable = false)
    private String title;

    @Column(name="content",nullable = false)
    private String content;

    @Builder //빌더 패턴으로 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;

    }

}