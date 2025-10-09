package me.sogom.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.sogom.springbootdeveloper.domain.Article;
import me.sogom.springbootdeveloper.dto.AddArticleRequest;
import me.sogom.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor    //final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    //blog 글 추가 메서드
    public Article save(AddArticleRequest request) {    //AddArticleRequest class에 저장된 값을 article DB에 저장
        return blogRepository.save(request.toEntity());
    }
    // DB에 저장된 글을 모두 가져옴
    public List<Article> findAll() {
        return blogRepository.findAll();
    }
}
