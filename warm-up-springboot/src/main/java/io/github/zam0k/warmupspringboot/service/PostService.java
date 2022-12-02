package io.github.zam0k.warmupspringboot.service;


import io.github.zam0k.warmupspringboot.controller.dto.CreatePostDTO;
import io.github.zam0k.warmupspringboot.controller.dto.UpdatePostDTO;
import io.github.zam0k.warmupspringboot.model.Post;

import java.util.List;

public interface PostService {
    Post createPost(CreatePostDTO postDTO);
    List<Post> findAllPosts();
    Post findPostById(Long id);
    void updatePost(Long id, UpdatePostDTO postDTO);
    void deletePost(Long id);
}
