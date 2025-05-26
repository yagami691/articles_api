package articles.articles.articles.controllers;

import articles.articles.articles.service.ArticlesService;
import articles.articles.articles.articlesandcomments.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/articles")
public class ArticlesController {
    @Autowired
    private ArticlesService articlesService;

    @GetMapping("/allUsers")
    public List<Articles> getArticles() {
           return articlesService.getArticles();
    }

    @GetMapping("/articlesId")
    public Optional<Articles> getArticleById(@RequestParam Long id) {
        return articlesService.getArticlesById(id);
    }

    @PostMapping
    public ResponseEntity<String> createArticle(@RequestBody Articles articles) {
         articlesService.addNewArticle(articles);
         return ResponseEntity.status(HttpStatus.CREATED).body("article added successfully");
    }

    @PutMapping(path="/{articleId}")
    public ResponseEntity<String> updateArticle(
            @PathVariable Long articleId,
            @RequestBody Articles articles) {
        articlesService.updateArticle(articleId,
                articles.getTitle(), articles.getContent(), articles.getPublicationDate());
        return ResponseEntity.ok("Article updated successfully");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteArticleById(@PathVariable Long id) {
        articlesService.deleteArticle(id);
        return ResponseEntity.ok("Article deleted successfully");
    }


}
