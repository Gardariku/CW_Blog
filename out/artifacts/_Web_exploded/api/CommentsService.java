package api;

import server.Comment;

import java.util.List;

public interface CommentsService {
    List<Comment> ShowComments(int PostID);
    boolean AddComment(int ID, String login, String text);
}
