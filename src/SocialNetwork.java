import java.util.*;

public class SocialNetwork {
    private Set<User> users = new HashSet<>();
    private Set<String> logins = new HashSet<>();
    private static int accountant; //COUNTER TO QUANTIFY NUMBER OF USERS


    //METHODS


    // ----- USER -----
    //CREATE USER AND ADD TO COUNTER
    public void addUser(User newUser){
        users.add(newUser);
        accountant++;
    }
    //
    //GET IMMUTABLE USERS LIST
    public Set<User> getUsers() {
        return Collections.unmodifiableSet(users);
    }
    //
    //GET USERS BY ID
    public User findUserByID(String idUser){
        for (User u: users
             ) {
            if (idUser==u.getId()){
                return u;
            }
        }
        return null;
    }
    //
    //USERS HISTORY
    public void printUpdates(){
        for (User u: users
        ) {
            System.out.println("\nUsuario: "+ u.getName()
                    + ", id=" + u.getId());
            System.out.println(u.getPosts());
        }
    }
    //
    //NUMBER OF USERS IN THE PLATFORM
    public int getAccountant(){
        return accountant;
    }




    // ----- POST -----
    //
    // GET POST BY ID
    public Post findPostByID(String idUser,String idPost){
        User u = findUserByID(idUser);
        return u.findPost(idPost);
    }
    //
    // ADD POST BY USER ID
    public void addPost(String idUser, Post post){
        User u = findUserByID(idUser);
        u.addPosts(post);
    }




    // ----- COMMENT -----
    //
    // ADD COMMENT BY ID USER AND POST
    public void addComment(String idUserTo, String idUserFrom, String idPostFrom, Comment comment){
        User userTo = findUserByID(idUserTo);
        User userFrom = findUserByID(idUserFrom);
        Post post = findPostByID(idUserFrom, idPostFrom);

        if (userTo!=null && userFrom!=null && post!=null){
            post.setComments(comment);
            userTo.addCommentDone(comment, idUserFrom);
        }else {
            System.out.println("Some parameter is incompatible");}
    }



    // ----- LIKE -----
    public void liked(String idUserTo, String idUserPost, String idPost){
        User userTo = findUserByID(idUserTo);
        User userFrom = findUserByID(idUserPost);
        Post post = findPostByID(idUserPost, idPost);

        if (userTo!=null && userFrom!=null && post!=null){
            post.setLikesCounter();
            userTo.addLikeDone(idPost);
        }else{
            System.out.println("Some parameter is incompatible");
        }
    }



    // ----- FRIENDSHIPS -----
    //
    // ADD FRIEND
    public void addFriendly(String idUser1, String idUser2) {
        User user1 = findUserByID(idUser1);
        User user2 = findUserByID(idUser2);

        if (user1!= null && user2!=null){
            user1.addFriend(user2);
            user2.addFriend(user1);
        }
    }
    //
    // REMOVE FRIEND
    public void removeFriendly(String idUser1, String idUser2){
        User user1 = findUserByID(idUser1);
        User user2 = findUserByID(idUser2);

        if (user1!= null && user2!=null){
            user1.removeFriend(user2);
            user2.removeFriend(user1);
        }
    }



    // ----- LOGIN -----
    //
    // GETTING IMMUTABLE LOGINS
    public Set<String> getLogins() {
        return Collections.unmodifiableSet(logins);
    }
    //
    // ADD SINGULAR LOGIN
    public void addlogin(String idUser, String login){
        User user = findUserByID(idUser);
        boolean existingUser = logins.contains(login); //Contains: SEARCH METHOD
        if (existingUser){
            user.setLogin(login);
        }else{
            System.out.println("The longin already exists! Try again.");}
    }



    // ----- PASSWORD -----
    //
    // ADD PASSWORD WITH SIX OR MORE CHARACTERS
    public void addPassword(String idUser, String password){
        int size = password.length();
        if (size >=6) {
            User user = findUserByID(idUser);
            user.setPassword(password);
        }
    }



}