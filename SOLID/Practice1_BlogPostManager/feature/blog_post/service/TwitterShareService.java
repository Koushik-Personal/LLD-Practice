package feature.blog_post.service;

public class TwitterShareService implements SocialShareServiceInterface{
    @Override
    public void share() {
        System.out.println("TwitterShareService");
        return;
    }
    
}
