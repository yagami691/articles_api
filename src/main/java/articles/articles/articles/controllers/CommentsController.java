package articles.articles.articles.controllers;


import articles.articles.articles.articlesandcomments.Comments;
import articles.articles.articles.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/articles")
public class CommentsController {

    @Autowired
    private  CommentsService commentsService;


    @PostMapping(path ="/addComment")
    public ResponseEntity<String> addComment(@RequestBody Comments comment) {
        commentsService.addComments(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body("comment " + comment +
                " added successfully");
    }
}
