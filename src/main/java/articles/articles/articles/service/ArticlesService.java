package articles.articles.articles.service;

import articles.articles.articles.repository.ArticlesRepository;
import articles.articles.articles.articlesandcomments.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ArticlesService {

    @Autowired
    private ArticlesRepository articlesRepository;

    public List<Articles> getArticles(){
        return articlesRepository.findAll();
    }

    public Optional<Articles> getArticlesById(Long id) {
        boolean exists = articlesRepository.existsById(id);
        if (!exists) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article does not exist");
        }
        return articlesRepository.findArticlesById(id);
    }



    public void addNewArticle(Articles article) {
        List<Articles>  existingArticles = articlesRepository.findArticlesByTitle(article.getTitle());
        boolean exists = existingArticles.stream().anyMatch(
                a -> a.getTitle().equalsIgnoreCase(article.getTitle()) && a.getContent().equalsIgnoreCase(article.getContent())
                        && a.getPublicationDate().equalsIgnoreCase(article.getPublicationDate()));
        if (!exists) articlesRepository.save(article);
        else throw new ResponseStatusException(HttpStatus.CONFLICT, "Article already exists");
    }

    public void updateArticle(Long id, String title, String content, String publicationDate) {
        Articles  existingArticles = articlesRepository.findById(id)
                .orElseThrow(()-> new  IllegalStateException(
                        "Article with id " + id + " does not exist"
                ));

        if(title != null && !title.equalsIgnoreCase(existingArticles.getTitle())) existingArticles.setTitle(title);
        if(content != null && !content.equalsIgnoreCase(existingArticles.getContent())) existingArticles.setContent(content);
        if(publicationDate != null && !publicationDate.equalsIgnoreCase(existingArticles.getPublicationDate())) existingArticles.setPublicationDate(publicationDate);

        articlesRepository.save(existingArticles);
    }

    public void deleteArticle(Long id) {
        boolean exists = articlesRepository.existsById(id);
        if(!exists) throw new IllegalStateException("Article  with id " + id + " does not exist");
        articlesRepository.deleteById(id);

    }

}
