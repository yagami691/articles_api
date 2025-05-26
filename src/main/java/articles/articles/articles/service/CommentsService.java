package articles.articles.articles.service;

import articles.articles.articles.articlesandcomments.Comments;
import articles.articles.articles.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;

    public void addComments(Comments comment){
        Optional<Comments> existComments  = commentsRepository.findByComment(comment.getComment());
        if(existComments.isEmpty()){
            commentsRepository.save(comment);
        }else throw new IllegalStateException("Comment " + comment.getComment() + " already exists");
    }
}
