package com.hdgh0g.backend.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.hdgh0g.backend.domain.Post;
import com.hdgh0g.backend.exceptions.ApiException;
import com.hdgh0g.backend.exceptions.ServiceException;
import com.hdgh0g.backend.services.PostsManager;
import com.hdgh0g.backend.views.PostView;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/posts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class PostsController {

    private final PostsManager postsManager;

    @GetMapping
    @JsonView(PostView.ListView.class)
    public Page<Post> getAllPosts(Pageable pageable,
                                  @RequestParam(required = false) String tag) {
        return postsManager.findAll(pageable, tag);
    }

    @GetMapping("/tags")
    public Map<String,Long> getPostTags() {
        return postsManager.getTags();
    }

    @GetMapping("/{id}")
    @JsonView(PostView.FullView.class)
    public Post getPost(@PathVariable Long id) throws ApiException {
        try {
            return postsManager.getPost(id);
        } catch (ServiceException e) {
            throw new ApiException(e, HttpStatus.NOT_FOUND);
        }
    }
}