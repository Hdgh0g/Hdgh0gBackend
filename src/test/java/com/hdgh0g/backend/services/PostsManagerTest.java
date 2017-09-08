package com.hdgh0g.backend.services;

import com.hdgh0g.backend.config.TestServiceConfiguration;
import com.hdgh0g.backend.domain.Post;
import com.hdgh0g.backend.exceptions.ServiceException;
import com.hdgh0g.backend.repositories.PostsRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static com.hdgh0g.backend.test_utils.catcher.ThrowableAssertion.assertThrown;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@ContextHierarchy({
        @ContextConfiguration(classes = TestServiceConfiguration.class),
        @ContextConfiguration(classes = PostsManagerTestConfiguration.class)
})
public class PostsManagerTest {

    @MockBean
    private PostsRepo postsRepo;

    @Autowired
    private PostsManager postsManager;

    @Test
    public void testGetPost() throws ServiceException {
        doReturn(Optional.of(new Post())).when(postsRepo).findById(anyLong());
        Post first = postsManager.getPost(ThreadLocalRandom.current().nextLong());

        assertThat(first, notNullValue());
    }

    @Test
    public void testGetNotExistingPost() throws ServiceException {
        doReturn(Optional.empty()).when(postsRepo).findById(anyLong());
        assertThrown(() -> postsManager.getPost(ThreadLocalRandom.current().nextLong()))
                .isInstanceOf(ServiceException.class)
                .hasMessage(ServiceException.Reason.POST_NOT_FOUND.getTitle());
    }
}
