package com.codegym.cms.repository;

import com.codegym.cms.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
