package com.hdgh0g.backend.test_utils;

import com.hdgh0g.backend.domain.Post;
import groovy.lang.IntRange;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.Instant;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class PostTestUtils {

    public static Post configurePost() {
        Set<String> tags = new IntRange(1, ThreadLocalRandom.current().nextInt(5,10))
                .stream()
                .map(i -> RandomStringUtils.randomAlphabetic(10, 15))
                .collect(Collectors.toSet());
        return new Post(
                ThreadLocalRandom.current().nextLong(),
                RandomStringUtils.randomAlphabetic(100),
                Instant.now(),
                RandomStringUtils.randomAlphabetic(2000),
                tags
        );
    }
}
