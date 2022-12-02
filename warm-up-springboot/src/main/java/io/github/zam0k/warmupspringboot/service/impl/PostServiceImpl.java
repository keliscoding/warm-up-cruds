package io.github.zam0k.warmupspringboot.service.impl;

import io.github.zam0k.warmupspringboot.controller.dto.CreatePostDTO;
import io.github.zam0k.warmupspringboot.controller.dto.UpdatePostDTO;
import io.github.zam0k.warmupspringboot.model.Post;
import io.github.zam0k.warmupspringboot.repository.PostRepository;
import io.github.zam0k.warmupspringboot.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository repository;

    @Override
    public Post createPost(CreatePostDTO postDTO) {
        Post newPost = new Post();
        newPost.setTitle(postDTO.getTitle());
        newPost.setDescription(postDTO.getDescription());
        newPost.setProfile(postDTO.getProfile());

        try {
            return repository.save(newPost);
        } catch (Exception ex) {
            throw new Error(ex.getMessage());
        }
    }

    @Override
    public List<Post> findAllPosts() {
        return repository.findAll();
    }

    @Override
    public Post findPostById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find post"));
    }

    @Override
    public void updatePost(Long id, UpdatePostDTO postDTO) {
        Post post = repository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find post"));
        if(postDTO.getDescription() != null) {
            post.setDescription(postDTO.getDescription());
        }

        if(postDTO.getTitle() != null) {
            post.setTitle(postDTO.getTitle());
        }

        if(postDTO.getProfile() != null) {
            post.setProfile(postDTO.getProfile());
        }

        repository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Cannot find post");
        }
    }
}
