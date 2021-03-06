package com.codegym.blog_manager_spring_boot.repository;

import com.codegym.blog_manager_spring_boot.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {

}