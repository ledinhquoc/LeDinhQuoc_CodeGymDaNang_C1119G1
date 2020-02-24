package com.codegym.cms.repository;

import com.codegym.cms.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {
    Page<Post>findAllByName(String name, Pageable pageable);
    Iterable<Post> findAllByName(String name, Sort sort);

    Page<Post>findAllByCategoryName(String name, Pageable pageable);
    Iterable<Post> findAllByCategoryName(String name, Sort sort);

}
