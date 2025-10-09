package me.sogom.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.sogom.springbootdeveloper.domain.Article;
import me.sogom.springbootdeveloper.dto.AddArticleRequest;
import me.sogom.springbootdeveloper.dto.UpdateArticleRequest;
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
    //DB에 저장되어 있는 글의 ID를 이용해 글을 조회
    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id)); //해당 id가 없을 시 exception 발생
    }
    //삭제하고자 하는 글의 ID를 입력받아 글을 삭제
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional  //트랜잭션 메서드
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found: "+id));

        article.update(request.getTitle(), request.getContent());
        return article;
    }
}
