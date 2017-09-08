package com.hdgh0g.backend.services;

import com.hdgh0g.backend.repositories.PostsRepo;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class PostsManagerTestConfiguration {

    @Bean
    public PostsManager postsManager(PostsRepo pr) {
        return new PostsManager(pr);
    }

}
