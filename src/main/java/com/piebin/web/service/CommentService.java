package com.piebin.web.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.piebin.web.domain.Account;
import com.piebin.web.domain.Comment;
import com.piebin.web.domain.Post;
import com.piebin.web.dto.AccountGetInfoRequestDto;
import com.piebin.web.dto.CommentGetRequestDto;
import com.piebin.web.dto.CommentRequestDto;
import com.piebin.web.repository.AccountRepository;
import com.piebin.web.repository.CommentRepository;
import com.piebin.web.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public Comment save(Account account, Post post, CommentRequestDto dto) {
        Comment comment = new Comment(dto);
        comment.setCreated_time(LocalDateTime.now());
        comment.setEdited_time(LocalDateTime.now());

        comment.setAccount(account);
        post.addComment(comment);

        return commentRepository.save(comment);
    }

    public List<Comment> getList(CommentGetRequestDto dto) {
        Optional<Post> post = postRepository.findByIdx(dto.getPost_idx());
        List<Comment> list = new ArrayList<>();
        if (post.isPresent())
            list = commentRepository.findAllByPost(post.get());
        return list;
    }

    public String getJsonList(List<Comment> list) {
        JsonObject jo = new JsonObject();
        JsonArray ja = new JsonArray();
        for (Comment comment : list) {
            JsonObject jo_comment = new JsonObject();
            jo_comment.addProperty("idx", comment.getIdx());
            jo_comment.addProperty("text", comment.getText());
            jo_comment.addProperty("name", comment.getAccount().getName());
            jo_comment.addProperty("created_time", comment.getCreated_time().toString());
            jo_comment.addProperty("edited_time", comment.getEdited_time().toString());
            ja.add(jo_comment);
        }
        jo.add("data", ja);
        return jo.toString();
    }
}
