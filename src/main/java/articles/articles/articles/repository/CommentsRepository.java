package articles.articles.articles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import articles.articles.articles.articlesandcomments.Comments;

import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    Optional<Comments> findByComment(String comment);


}
