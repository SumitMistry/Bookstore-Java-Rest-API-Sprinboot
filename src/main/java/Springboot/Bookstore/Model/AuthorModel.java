package Springboot.Bookstore.Model;


public class AuthorModel {

    int authorID;
    String authorName;

    public AuthorModel(String authorName, int authorID) {
        this.authorName = authorName;
        this.authorID = authorID;
    }

    public String getAuthorNAme() {
        return authorName;
    }

    public void setAuthorNAme(String authorName) {
        this.authorName = authorName;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    @Override
    public String toString() {
        return "AuthorModel{" +
                "authorName='" + authorName + '\'' +
                ", authorID=" + authorID +
                '}';
    }
}
