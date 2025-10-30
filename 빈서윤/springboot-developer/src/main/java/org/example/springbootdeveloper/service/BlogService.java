package org.example.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.domain.Article;
import org.example.springbootdeveloper.dto.AddArticleRequest;
import org.example.springbootdeveloper.dto.UpdateArticleRequest;
import org.example.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //빈을 생성자로 생성
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    //sav()는 JpaRepository에서 지원하는 저장 메서드로
    //AddArticleRequest 클래스에 저장된 값들은 article 데이터베이스에 저장
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());

    }

    //블로그의 내용을 불러오는 api 작성
    //article 테이블에 저장되어 있는 모든 데이터를 조회합니다.=> 요청을 받아 controller에 전달
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found: "+id));
    }
    public void delete(Long id) {

        blogRepository.deleteById(id);
    }

    @Transactional //데이터를 바꾸기 위해 묶은 작업 단위
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("no found:" +id));

        article.update(request.getTitle(),request.getContent());

        return article;
    }
}
