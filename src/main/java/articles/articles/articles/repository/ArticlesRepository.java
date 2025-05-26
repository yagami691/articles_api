package articles.articles.articles.repository;

import articles.articles.articles.articlesandcomments.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticlesRepository extends JpaRepository<Articles, Long> {
    Optional<Articles> findArticlesById(Long id);
    List<Articles> findArticlesByTitle(String title);


}
