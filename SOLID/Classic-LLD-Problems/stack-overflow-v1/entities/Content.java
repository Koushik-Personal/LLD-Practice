package entities;

import java.util.List;
import java.util.UUID;

public class Content {
    private UUID Id;
    private User user;
    private String body;
    private List<Vote> votes;

    public Content(User user, String body) {
        this.Id = UUID.randomUUID();
        this.user = user;
        this.body = body;
    }

    

}
