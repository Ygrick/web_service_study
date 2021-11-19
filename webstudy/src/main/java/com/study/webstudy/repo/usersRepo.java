package com.study.webstudy.repo;

import com.study.webstudy.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface usersRepo extends CrudRepository<Users, Integer> {}
