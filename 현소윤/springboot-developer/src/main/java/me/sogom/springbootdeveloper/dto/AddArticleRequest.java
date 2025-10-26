package me.sogom.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sogom.springbootdeveloper.domain.Article;

import java.lang.reflect.Array;

@NoArgsConstructor  //기본 생성자 추가
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() { //생성자를 사용해 객체 생성
        return Article.builder()    //빌더 패턴을 이용해 DTO를 Entity로 변환
                .title(title)
                .content(content)
                .build();
    }
}
