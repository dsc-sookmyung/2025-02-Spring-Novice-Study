package me.leejoowon.springbootdeveloper.repository;

import me.leejoowon.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
public class BlogRepository {
}
