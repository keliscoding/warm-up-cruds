package io.github.zam0k.warmupspringboot.repository;

import io.github.zam0k.warmupspringboot.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
