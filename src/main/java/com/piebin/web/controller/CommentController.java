package com.piebin.web.controller;

import com.piebin.web.domain.Account;
import com.piebin.web.domain.Comment;
import com.piebin.web.domain.Post;
import com.piebin.web.dto.CommentGetRequestDto;
import com.piebin.web.dto.CommentRequestDto;
import com.piebin.web.repository.AccountRepository;
import com.piebin.web.repository.PostRepository;
import com.piebin.web.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final AccountRepository accountRepository;
    private final PostRepository postRepository;

    private final CommentService commentService;

    @PostMapping("/api/comment/save")
    public ResponseEntity<Boolean> save(
            @RequestBody CommentRequestDto dto) {
        Optional<Account> optionalAccount = accountRepository.findByIdx(dto.getAccount_idx());
        if (!optionalAccount.isPresent())
            return ResponseEntity.ok(false);
        Optional<Post> optionalPost = postRepository.findByIdx(dto.getPost_idx());
        if (!optionalPost.isPresent())
            return ResponseEntity.ok(false);
        commentService.save(optionalAccount.get(), optionalPost.get(), dto);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/api/comment/get")
    public String get(
            @RequestBody CommentGetRequestDto dto) {
        List<Comment> list = commentService.getList(dto);
        return commentService.getJsonList(list);
    }

    //
    // Test API
    //

    @GetMapping("/api/test/comment/save")
    public ResponseEntity<Boolean> save(
            @RequestParam("account_idx") int account_idx,
            @RequestParam("post_idx") int post_idx,
            @RequestParam("text") String text) {
        Optional<Account> optionalAccount = accountRepository.findByIdx(account_idx);
        if (!optionalAccount.isPresent())
            return ResponseEntity.ok(false);
        Optional<Post> optionalPost = postRepository.findByIdx(post_idx);
        if (!optionalPost.isPresent())
            return ResponseEntity.ok(false);
        CommentRequestDto dto = new CommentRequestDto();
        dto.setAccount_idx(account_idx);
        dto.setPost_idx(post_idx);
        dto.setText(text);
        commentService.save(optionalAccount.get(), optionalPost.get(), dto);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/api/test/comment/get")
    public String get(
            @RequestParam("post_idx") int post_idx) {
        CommentGetRequestDto dto = new CommentGetRequestDto();
        dto.setPost_idx(post_idx);

        List<Comment> list = commentService.getList(dto);
        return commentService.getJsonList(list);
    }
}
