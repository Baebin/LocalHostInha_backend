package com.piebin.web.repository;

import com.piebin.web.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByIdx(int idx);
    Page<Post> findAllByOrderByIdxDesc(Pageable pageable);
}
