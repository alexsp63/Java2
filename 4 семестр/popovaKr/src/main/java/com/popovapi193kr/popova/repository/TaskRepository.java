package com.popovapi193kr.popova.repository;

import com.popovapi193kr.popova.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
