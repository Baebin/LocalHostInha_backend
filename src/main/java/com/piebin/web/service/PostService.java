package com.piebin.web.service;

import com.piebin.web.domain.Account;
import com.piebin.web.domain.Post;
import com.piebin.web.dto.PostRequestDto;
import com.piebin.web.dto.PostSaveRequestDto;
import com.piebin.web.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;

    @Transactional
    public Post save(Account account, PostRequestDto dto) {
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setCreated_time(LocalDateTime.now());
        post.setEdited_time(LocalDateTime.now());
        account.addPost(post);

        return repository.save(post);
    }
}
