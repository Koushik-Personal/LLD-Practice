package feature.blog_post.service;

public class RedditShareService implements SocialShareServiceInterface {
    @Override
    public void share() {
        System.out.println("RedditShareService");
        return;
    }
    
}
