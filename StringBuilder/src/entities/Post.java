package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private LocalDateTime moment;
    private String title;
    private String content;
    private Integer likes;
    private List<Comment> comments = new ArrayList<>();

    public Post(){

    }

    public Post(LocalDateTime moment, String title, String content, Integer likes){
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    private String returnComments(List<Comment> comments){
        String text = "";
        for (Comment c : comments){
            text += c.toString() + String.format("%n");
        }
        return text;
    }

    private String parseTheMoment(LocalDateTime moment){
        return moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public String toString(){
        return title
                + String.format("%n")
                + likes + " Likes - " + parseTheMoment(moment)
                + String.format("%n")
                + content
                + String.format("%n")
                + String.format("Comments:%n")
                + returnComments(comments);
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

}
