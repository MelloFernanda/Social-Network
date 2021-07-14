import java.util.*;

public class User {
    private String id; //ATTRIBUTE FOR IDENTIFICATION
    private String name;
    private int age;
    private String login;
    private String password;

    //-----LISTS-----//
    //TO STORE POSTS DONE
    private List<Post> posts = new ArrayList<>();
    //TO STORE FRIENDS
    private List<User> friends = new ArrayList<>();
    //TO STORE COMMENTS DONE
    private List<Comment> commentsDone = new ArrayList<>();
    //TO STORE ID POST OF LIKES DONE
    private Set<String> likesDone = new HashSet<>();



    //CONSTRUCTOR
    public User(String id, String name){
        this.id=id;
        this.name=name;
        System.out.println("USER "+this.id+" CREATED SUCCESSFULLY."+
                "\nTHE NEXT STEP IS TO CREATE THE LOGIN AND PASSWORD(WITH 6 OR MORE CHARACTERS).\n");
    }



    // ----- USER METHODS ----- //
    //USER IDENTIFICATION
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    //
    //MODIFYING THE USER'S TOSTRING METHOD
    @Override
    public String toString() {
        return "User{" +
                ":'" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }




    // ----- POST METHODS ----- //
    //
    // ADD POST
    public void addPosts(Post post){
        posts.add(post);
    }
    //
    //REMOVE POST
    public void removePost(Post post){
        posts.remove(post);
    }
    //
    //GET POST BY ID
    public Post findPost(String idPost){
        for (Post p: posts
        ) {
            if (idPost==p.getIdPost()){
                return p;
            }
        }
        return null;
    }
    //
    // GET IMMUTABLE POSTS LIST
    public List<Post> getPosts() {
        return Collections.unmodifiableList(posts);
    }



    // ----- POTS LIKE ----- //
    // ADD LIKE DONE
    public void addLikeDone(String idPost){
        likesDone.add(idPost);
    }



    // ----- POST COMMENT ----- //
    // ADD COMMENT DONE
    public void addCommentDone(Comment  comment, String userCommented){
        comment.setIdUserComment(userCommented);
        commentsDone.add(comment);
    }




    // ----- FRIENDLY ----- //
    public void addFriend(User newFriend){
        friends.add(newFriend);
    }
    public void removeFriend(User enemy){
        friends.remove(enemy);
    }





    // ----- USER AGE ----- //
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }




    // ----- USER LOGIN ----- //
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login=login;
    }




    // ----- USER PASSWORD ----- //
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
