package application;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import entities.*;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Post[] post = {
            new Post(LocalDateTime.parse("21/06/2018 13:05:44", fmt1),
                    "Traveling to New Zealand",
                    "I'm going to visit this wonderful country!",
                    12),
            new Post(LocalDateTime.parse("28/07/2018 23:14:19", fmt1),
                    "Good night guys",
                    "See you tomorrow",
                    5)
        };
        Comment[] comment1 = {
                new Comment("Have a nice trip"),
                new Comment("Wow that's awesome!"),
        };
        Comment[] comment2 = {
                new Comment("Good night"),
                new Comment("May the Force be with you"),
        };

        for (Comment c : comment1){
            post[0].addComment(c);
        }
        for (Comment c : comment2){
            post[1].addComment(c);
        }


        for (Post p : post){
            System.out.println(p);
        }
    }
}