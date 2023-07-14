package com.piebin.web.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.piebin.web.domain.Account;
import com.piebin.web.domain.Post;
import com.piebin.web.dto.PostRequestDto;
import com.piebin.web.dto.PostSaveRequestDto;
import com.piebin.web.repository.AccountRepository;
import com.piebin.web.repository.PostRepository;
import com.piebin.web.service.PostService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PostController {
    private static Logger logger = LoggerFactory.getLogger(PostController.class);

    private final AccountRepository accountRepository;

    private final PostService postService;
    private final PostRepository postRepository;

    @PostMapping("/api/post/save")
    public ResponseEntity<Boolean> save(
            @RequestBody PostSaveRequestDto dto) {
        Optional<Account> account = accountRepository.findById(dto.getId());
        if (account.isPresent())
            return ResponseEntity.ok(false);
        PostRequestDto postRequestDto = new PostRequestDto();
        postRequestDto.setTitle(dto.getTitle());
        postRequestDto.setDescription(dto.getDescription());
        postService.save(account.get(), postRequestDto);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/api/post/get")
    public String getPost(
            @RequestParam("id") int id) {

        Optional<Post> optional = postRepository.findByIdx(id);

        JsonObject jo = new JsonObject();
        if (optional.isPresent()) {
            JsonArray ja = new JsonArray();

            Post post = optional.get();
            JsonObject jo_post = new JsonObject();
            jo_post.addProperty("id", post.getIdx());
            jo_post.addProperty("user", post.getAccount().getName());
            jo_post.addProperty("title", post.getTitle());
            jo_post.addProperty("description", post.getDescription());
            jo_post.addProperty("created_time", post.getCreated_time().toString());
            jo_post.addProperty("edited_time", post.getEdited_time().toString());
            ja.add(jo_post);

            jo.add("data", ja);
        }

        return jo.toString();
    }

    @GetMapping("/api/post/search")
    public String getPosts(
            @RequestParam("page") int page,
            @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Post> posts = postRepository.findAllByOrderByIdxDesc(pageable);

        JsonObject jo = new JsonObject();
        JsonArray ja = new JsonArray();
        posts.getContent().forEach(post -> {
            JsonObject jo_post = new JsonObject();
            jo_post.addProperty("id", post.getIdx());
            jo_post.addProperty("user", post.getAccount().getName());
            jo_post.addProperty("title", post.getTitle());
            ja.add(jo_post);
        });
        jo.add("data", ja);
        return jo.toString();
    }

    //
    // Test API
    //

    @GetMapping("/api/test/post/save")
    public ResponseEntity<Boolean> save(
            @RequestParam("id") String id,
            @RequestParam("title") String title,
            @RequestParam("description") String description) {
        Optional<Account> account = accountRepository.findById(id);
        if (!account.isPresent())
            return ResponseEntity.ok(false);
        logger.info(account.get().getId() + " " + account.get().getPassword());

        PostRequestDto postRequestDto = new PostRequestDto();
        postRequestDto.setTitle(title);
        postRequestDto.setDescription(description);
        postService.save(account.get(), postRequestDto);
        return ResponseEntity.ok(true);
    }
}
