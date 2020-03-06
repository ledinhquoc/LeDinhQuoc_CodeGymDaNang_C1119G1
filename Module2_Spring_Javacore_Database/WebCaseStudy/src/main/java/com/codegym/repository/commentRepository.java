package com.codegym.repository;

import com.codegym.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface commentRepository extends JpaRepository< Comment,Integer> {
}
