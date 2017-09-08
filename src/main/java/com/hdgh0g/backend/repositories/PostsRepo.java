package com.hdgh0g.backend.repositories;

import com.hdgh0g.backend.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.stream.Stream;

@Repository
public interface PostsRepo extends CrudRepository<Post, Long>{

    Page<Post> findAll(Pageable page);

    @Query("select new org.apache.commons.lang3.tuple.ImmutablePair(tag, count(tag)) " +
            "from Post p left join p.tags tag " +
            "group by tag")
    Stream<? extends Map.Entry<String,Long>> findTags();
}
