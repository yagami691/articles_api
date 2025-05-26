package articles.articles.articles.articlesandcomments;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private String title;
    private String content;
    private String publicationDate;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Comments> comments = new ArrayList<>();


    public Articles(String title, String content, String publicationDate) {
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
    }
}
