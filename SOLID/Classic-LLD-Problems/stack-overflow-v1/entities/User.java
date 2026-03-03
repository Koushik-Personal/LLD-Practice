package entities;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;


public class User {
    private UUID userId;   //Read only
    private String username; // Read and Write 
    private String email; // Read and Write
    private AtomicInteger reputation; 

    public User(String username, String email) {
        this.userId = UUID.randomUUID();
        this.username = username;
        this.email = email;
        this.reputation = new AtomicInteger(0);
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getReputation() {
        return reputation.get();
    }
    
    public void incrementReputation(int points) {
        reputation.addAndGet(points);
    }

    public void decrementReputation(int points) {
        reputation.addAndGet(-points);
    }

}
