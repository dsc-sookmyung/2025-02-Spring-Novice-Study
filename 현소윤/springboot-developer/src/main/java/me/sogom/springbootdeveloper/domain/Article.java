package me.sogom.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity //엔티티로 지정
@Getter //클래스 필드에 대해 별도 코드 없이 모든 필드에 대한 접근자 메서드 생성 가능
@NoArgsConstructor(access = AccessLevel.PROTECTED)  //접근 제어자가 protected인 기본 생성자 대치
public class Article {

    @Id //id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)   //'title'이라는 not null column과 매핑
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder    //빌더 패턴으로 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
    //요청받은 애용으로 값을 수정
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
