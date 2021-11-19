package com.study.webstudy.repo;

import com.study.webstudy.models.Progress;
import org.springframework.data.repository.CrudRepository;

public interface progressRepo extends CrudRepository<Progress, Integer> {}
