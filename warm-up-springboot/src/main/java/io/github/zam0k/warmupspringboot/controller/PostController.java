package io.github.zam0k.warmupspringboot.controller;

import io.github.zam0k.warmupspringboot.controller.dto.CreatePostDTO;
import io.github.zam0k.warmupspringboot.controller.dto.UpdatePostDTO;
import io.github.zam0k.warmupspringboot.model.Post;
import io.github.zam0k.warmupspringboot.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService service;

    @PostMapping
    public ResponseEntity<Post> createPost(@Valid @RequestBody CreatePostDTO postDTO) {
        Post newPost = service.createPost(postDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPost.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Post>> findAllPosts() {
        return ResponseEntity.ok(service.findAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long id, @Valid @RequestBody UpdatePostDTO postDTO) {
        service.updatePost(id, postDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable("id") Long id) {
        service.deletePost(id);
        return ResponseEntity.noContent().build();
    }

}

