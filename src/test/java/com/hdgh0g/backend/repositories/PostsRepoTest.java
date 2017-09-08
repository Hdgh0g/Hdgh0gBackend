package com.hdgh0g.backend.repositories;

import com.hdgh0g.backend.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@ActiveProfiles("test")
public class PostsRepoTest {

    @Autowired
    private PostsRepo postsRepo;

    @Test
    public void testGetFirstPage() {
        Page<Post> firstPage = postsRepo.findAll(PageRequest.of(0, 10));

        assertThat(firstPage.getNumber(), is(0));
        assertThat(firstPage.getContent().get(0).getTitle(), containsString("Первая запись"));
    }

    @Test
    public void testGetTags() {
        Stream<? extends Map.Entry<String, Long>> tags = postsRepo.findTags();

        assertThat(tags.collect(Collectors.toList()), not(empty()));
    }

    @Test
    public void testFindFirst() {
        Optional<Post> first = postsRepo.findById(1L);
        assertThat(first.isPresent(), is(true));
    }

    @Test
    public void testNotExistingPost() {
        Optional<Post> first = postsRepo.findById(-1L);
        assertThat(first.isPresent(), is(false));
    }
}