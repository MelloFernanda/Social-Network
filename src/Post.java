import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Post {
    private String post;
    private String idPost;
    private int likesCounter;
    List<Comment> comments = new ArrayList<>();


    //CONSTRUCTOR
    public Post(String idPost, String post) {
        this.post = post;
        this.idPost = idPost;
    }



    // ----- POST ----- //
    //PEGAR ID DO POST
    public String getIdPost() {
        return idPost;
    }

    //MODIFYING THE POST'S TOSTRING METHOD
    @Override
    public String toString() {
        return "\nPost{" +
                "post='" + post + '\'' +
                ", idPost='" + idPost + '\'' +
                ", likesCounter=" + likesCounter +
                ", comments=" + comments +
                '}'+"\n";
    }




    // ----- COMMENT ----- //
    public void setComments(Comment comment){
        comments.add(comment);
    }

    // GET IMMUTABLE COMMENTS LIST
    public List<Comment> getComments() {
        return Collections.unmodifiableList(comments);
    }




    // ----- LIKE ----- //
    //INCREMENTAR LIKE
    public void setLikesCounter() {
        this.likesCounter ++;
    }
}
