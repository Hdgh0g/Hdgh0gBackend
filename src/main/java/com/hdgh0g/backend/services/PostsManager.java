package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.Post;
import com.hdgh0g.backend.exceptions.ServiceException;
import com.hdgh0g.backend.repositories.PostsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.stream.Collectors;

import static com.hdgh0g.backend.exceptions.ServiceException.Reason.POST_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PostsManager {

    private final PostsRepo postsRepo;

    public Page<Post> findAll(Pageable pageable, String tag) {
        return postsRepo.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Map<String, Long> getTags() {
        return postsRepo.findTags().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Post getPost(Long id) throws ServiceException {
        return postsRepo.findById(id).orElseThrow(() -> new ServiceException(POST_NOT_FOUND));
    }
}
