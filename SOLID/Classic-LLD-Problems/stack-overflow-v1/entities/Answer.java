package entities;

import java.util.List;
import java.util.UUID;

public class Answer extends Content {

    public Answer(User user, String answerBody) {
        super(user, answerBody);
    }
    private Question question;
    private List<Comment> comments;

}
