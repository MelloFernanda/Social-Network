public class Comment {
    private String comment;
    private String idComment;
    private String idUserComment; //USER OF THE COMMENTED POST

    //COMMENT CONSTRUCTOR
    public Comment(String idComment, String comment){
        this.idComment=idComment;
        this.comment=comment;
    }

    public void setIdUserComment(String idUserComment) {
        this.idUserComment = idUserComment;
    }

    //GET COMMENT ATTRIBUTES
    public String getComment() {
        return comment;
    }
    public String getIdComment() {
        return idComment;
    }

    //MODIFYING THE COMMENT'S TOSTRING METHOD
    @Override
    public String toString() {
        return "{Comment=" + comment + '\'' +
                ", idComment='" + idComment + '\'' +
                '}';
    }
}
